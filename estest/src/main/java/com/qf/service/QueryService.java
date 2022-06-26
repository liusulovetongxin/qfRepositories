package com.qf.service;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;

/**
 * @author Administrator
 * @version V1.0
 * @Project estest
 * @Package com.qf.service.impl
 * @Description:
 * @Date 2022/6/20 21:09
 */

public interface QueryService {
    SearchResponse termQuery(String index, String field, String value) throws Exception;
    SearchResponse termsQuery(String index, String field, String... value) throws Exception;
    SearchResponse matchAllQuery(String index) throws Exception;
    SearchResponse matchQuery(String index,String field,String value) throws Exception;
    SearchResponse booleanQuery(String index, String field, String value, Operator operator) throws Exception;
    SearchResponse multiMatch(String index, String value, String... field) throws Exception;
    SearchResponse idsQuery(String index, String... ids) throws Exception;
    SearchResponse prefixQuery(String index,String field, String value) throws Exception;
    SearchResponse fuzzyQuery(String index,String field, String value) throws Exception;
    SearchResponse wildcardQuery(String index,String field, String value) throws Exception;
    SearchResponse rangeQuery(String index, QueryBuilder queryBuilder) throws Exception;
    SearchResponse createScrollQuery(String index, QueryBuilder queryBuilder, int size) throws Exception;
    SearchResponse scrollQuery(String scrollId) throws Exception;
    SearchResponse boolQuery(String index, QueryBuilder queryBuilder) throws Exception;
    SearchResponse highLightQuery(String index, QueryBuilder queryBuilder, HighlightBuilder highlightBuilder) throws Exception;
    SearchResponse cardinalityAggre(String index, String field) throws Exception;

    SearchResponse rangeAggre(String index, AggregationBuilder aggregationBuilder) throws Exception;

}
