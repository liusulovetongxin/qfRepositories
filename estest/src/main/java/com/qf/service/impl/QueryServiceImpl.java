package com.qf.service.impl;

import com.qf.service.QueryService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.CardinalityAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @version V1.0
 * @Project estest
 * @Package com.qf.service.impl
 * @Description:
 * @Date 2022/6/20 21:09
 */
@Service
public class QueryServiceImpl implements QueryService {
    private RestHighLevelClient client;

    @Autowired
    public void setClient(RestHighLevelClient client) {
        this.client = client;
    }
    public SearchResponse baseQuery(String index,QueryBuilder queryBuilder) throws Exception{
        // 创建查询的请求
        SearchRequest searchRequest = new SearchRequest(index);
        // 获取查询的对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 设置查询类型
        searchSourceBuilder.query(queryBuilder);
        // 设置查询条件
//        SearchRequest source = searchRequest.source(searchSourceBuilder);
//        SearchResponse response = client.search(source,RequestOptions.DEFAULT);
        return baseQuery(index, searchSourceBuilder);
    }

    public SearchResponse baseQuery(String index,SearchSourceBuilder searchSourceBuilder) throws Exception {
        SearchRequest searchRequest = new SearchRequest(index);
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        return response;
    }


        @Override
    public SearchResponse termQuery(String index, String field, String value) throws Exception {
//        SearchRequest searchRequest = new SearchRequest(index);
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        SearchSourceBuilder query = searchSourceBuilder.query(QueryBuilders.termQuery(field, value));
//        searchRequest.source(query);
//        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        return baseQuery(index,QueryBuilders.termQuery(field, value));
    }

    @Override
    public SearchResponse termsQuery(String index, String field, String... value) throws Exception {
        return baseQuery(index, QueryBuilders.termsQuery(field, value));
    }
    @Override
    public SearchResponse matchAllQuery(String index) throws Exception {
        return baseQuery(index,QueryBuilders.matchAllQuery());
    }

    @Override
    public SearchResponse matchQuery(String index, String field, String value) throws Exception {
        return baseQuery(index,QueryBuilders.matchQuery(field,value));
    }

    @Override
    public SearchResponse booleanQuery(String index, String field, String value, Operator operator) throws Exception {
        return baseQuery(index,QueryBuilders.matchQuery(field,value).operator(operator));
    }

    @Override
    public SearchResponse multiMatch(String index, String value, String... field) throws Exception {
        return baseQuery(index,QueryBuilders.multiMatchQuery(value,field));
    }

    @Override
    public SearchResponse idsQuery(String index, String... ids) throws Exception {
        return baseQuery(index, QueryBuilders.idsQuery().addIds(ids));
    }

    @Override
    public SearchResponse prefixQuery(String index, String field, String value) throws Exception {
        return baseQuery(index, QueryBuilders.prefixQuery(field, value));
    }

    @Override
    public SearchResponse fuzzyQuery(String index, String field, String value) throws Exception {
        return baseQuery(index, QueryBuilders.fuzzyQuery(field, value));
    }

    @Override
    public SearchResponse wildcardQuery(String index, String field, String value) throws Exception {
        return baseQuery(index, QueryBuilders.wildcardQuery(field, value));
    }

    @Override
    public SearchResponse rangeQuery(String index, QueryBuilder queryBuilder) throws Exception {
        return baseQuery(index, queryBuilder);
    }

    @Override
    public SearchResponse createScrollQuery(String index, QueryBuilder queryBuilder, int size) throws Exception {
        SearchRequest searchRequest = new SearchRequest(index);
        searchRequest.scroll("1m");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(queryBuilder);
        searchSourceBuilder.size(size);
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        return search;
    }

    @Override
    public SearchResponse scrollQuery(String scrollId) throws Exception {
        SearchScrollRequest request = new SearchScrollRequest(scrollId).scroll("1m");
        SearchResponse scroll = client.scroll(request, RequestOptions.DEFAULT);
        return scroll;
    }

    @Override
    public SearchResponse boolQuery(String index, QueryBuilder queryBuilder) throws Exception {
        SearchResponse searchResponse = baseQuery(index, queryBuilder);
        return searchResponse;
    }

    @Override
    public SearchResponse highLightQuery(String index, QueryBuilder queryBuilder, HighlightBuilder highlightBuilder) throws Exception {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(queryBuilder).highlighter(highlightBuilder);
        return baseQuery(index, searchSourceBuilder);
    }
    @Override
    public SearchResponse cardinalityAggre(String index, String field) throws Exception {

        CardinalityAggregationBuilder aggregationBuilder = AggregationBuilders
                //创建聚合的builder 参数是别名
                .cardinality("bieming")
                //设置哪个列作为聚合的列
                .field(field);
        return aggressQuery(index,aggregationBuilder);
    }

    @Override
    public SearchResponse rangeAggre(String index, AggregationBuilder aggregationBuilder) throws Exception {
        return aggressQuery(index,aggregationBuilder);
    }

    public SearchResponse aggressQuery(String index, AggregationBuilder builder) throws Exception {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //设置聚合
        searchSourceBuilder.aggregation(builder);
        return baseQuery(index, searchSourceBuilder);
    }
}
