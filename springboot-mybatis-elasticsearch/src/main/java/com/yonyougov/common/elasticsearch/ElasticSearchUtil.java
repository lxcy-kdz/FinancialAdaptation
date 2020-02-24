package com.yonyougov.common.elasticsearch;

import com.yonyougov.entity.Balance;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.springframework.data.elasticsearch.ElasticsearchException;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.DefaultResultMapper;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsMapper;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;
import org.springframework.data.elasticsearch.core.mapping.ElasticsearchPersistentEntity;
import org.springframework.data.elasticsearch.core.mapping.ElasticsearchPersistentProperty;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * ElasticSearch工具类
 *
 * @author kongdezhi
 */
@Component
public class ElasticSearchUtil {

    private ElasticsearchTemplate elasticsearchTemplate;

    private ElasticsearchConverter elasticsearchConverter;

    private ResultsMapper resultsMapper;

    public ElasticSearchUtil(ElasticsearchTemplate elasticsearchTemplate, ElasticsearchConverter elasticsearchConverter) {
        this.elasticsearchTemplate = elasticsearchTemplate;
        this.elasticsearchConverter = elasticsearchConverter;
        this.resultsMapper = new DefaultResultMapper(elasticsearchConverter.getMappingContext());
    }

    public <T> boolean createIndex(Class<T> clazz) {
        ElasticsearchPersistentEntity persistentEntity = elasticsearchConverter.getMappingContext().getRequiredPersistentEntity(clazz);
        boolean indexExists = elasticsearchTemplate.indexExists(persistentEntity.getIndexName());
        if (!indexExists) {
            elasticsearchTemplate.createIndex(clazz);
            XContentBuilder xContentBuilder = null;
            try {
                ElasticsearchPersistentProperty property = (ElasticsearchPersistentProperty) persistentEntity.getRequiredIdProperty();
                xContentBuilder = MappingBuilder.buildMapping(clazz, persistentEntity.getIndexType(),
                        property.getFieldName(), persistentEntity.getParentType());
                System.out.println(xContentBuilder.prettyPrint().toString());
            } catch (Exception e) {
                throw new ElasticsearchException("无法为" + clazz.getSimpleName() + "建立映射", e);
            }
            return elasticsearchTemplate.putMapping(clazz, xContentBuilder);
        } else {
            return true;
        }
    }

    public <S> S save(S entity) throws Exception {
        ElasticsearchPersistentEntity requiredPersistentEntity = getRequiredPersistentEntity(entity.getClass());
        Assert.notNull(entity, "保存的文档为空");
        elasticsearchTemplate.index(createIndexQuery(entity, requiredPersistentEntity));
        elasticsearchTemplate.refresh(requiredPersistentEntity.getIndexName());
        return entity;
    }

    public <S> List<S> save(List<S> entities) throws Exception {
        Assert.notNull(entities, "保存的文档为空");
        Assert.notEmpty(entities, "保存的文档为空");
        List<IndexQuery> queries = new ArrayList<>();
        ElasticsearchPersistentEntity requiredPersistentEntity = null;
        for (S s : entities) {
            if (requiredPersistentEntity == null) {
                requiredPersistentEntity = getRequiredPersistentEntity(s.getClass());
            }
            queries.add(createIndexQuery(s, requiredPersistentEntity));
        }
        elasticsearchTemplate.bulkIndex(queries);
        elasticsearchTemplate.refresh(requiredPersistentEntity.getIndexName());
        return entities;
    }

    public <T> T findById(Class<T> clazz, String id) {
        ElasticsearchPersistentEntity requiredPersistentEntity = getRequiredPersistentEntity(clazz);
        GetQuery query = new GetQuery();
        query.setId(id);
        GetResponse response = elasticsearchTemplate.getClient()
                .prepareGet(requiredPersistentEntity.getIndexName(), requiredPersistentEntity.getIndexType(), query.getId()).execute()
                .actionGet();
        return resultsMapper.mapResult(response, clazz);
    }

    private <T> IndexQuery createIndexQuery(T entity, ElasticsearchPersistentEntity requiredPersistentEntity) throws Exception {
        IndexQuery query = new IndexQueryBuilder()
                .withId(getId(entity, requiredPersistentEntity))
                .withObject(entity)
                .withVersion(getVersion(entity, requiredPersistentEntity))
                .withIndexName(requiredPersistentEntity.getIndexName())
                .withType(requiredPersistentEntity.getIndexType())
                .build();
        return query;
    }

    private <T> String getId(T entity, ElasticsearchPersistentEntity requiredPersistentEntity) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = entity.getClass().getDeclaredField(requiredPersistentEntity.getIdProperty().getName());
        declaredField.setAccessible(true);
        Object id = declaredField.get(entity);
        declaredField.setAccessible(false);
        return String.valueOf(id);
    }

    private <T> Long getVersion(T entity, ElasticsearchPersistentEntity requiredPersistentEntity) throws NoSuchFieldException, IllegalAccessException {
        if (requiredPersistentEntity.getVersionProperty() == null) {
            return null;
        }
        Field declaredField = entity.getClass().getDeclaredField(requiredPersistentEntity.getVersionProperty().getName());
        declaredField.setAccessible(true);
        Object id = declaredField.get(entity);
        declaredField.setAccessible(false);
        return Long.valueOf(String.valueOf(id));
    }

    private <T> ElasticsearchPersistentEntity getRequiredPersistentEntity(Class<T> clazz) {
        return elasticsearchConverter.getMappingContext().getRequiredPersistentEntity(clazz);
    }

    public ElasticsearchTemplate getElasticsearchTemplate(){
        return elasticsearchTemplate;
    }
}
