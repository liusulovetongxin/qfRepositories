package com.qf;

import com.qf.config.EsConfig;
import com.qf.service.QueryService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.range.ParsedRange;
import org.elasticsearch.search.aggregations.bucket.range.RangeAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.ParsedCardinality;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version V1.0
 * @Project estest
 * @Package com.qf
 * @Description:
 * @Date 2022/6/20 21:16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EsConfig.class)
public class TestQuery {
    private QueryService queryService;

    @Autowired
    public void setQueryService(QueryService queryService) {
        this.queryService = queryService;
    }
    private String indexName = "sms-logs-index";

    @Test
    public void testTermQuery() throws Exception {
        SearchResponse searchResponse = queryService.termQuery(indexName, "state", "1");
        Arrays.stream(searchResponse.getHits().getHits()).forEach(documentFields -> {
            System.err.println(documentFields.getSourceAsString());
        });
    }
    @Test
    public void testTermsQuery() throws Exception {
        SearchResponse searchResponse = queryService.termsQuery(indexName, "state", "1");
        Arrays.stream(searchResponse.getHits().getHits()).forEach(documentFields -> {
            System.err.println(documentFields.getSourceAsString());
        });
    }
    @Test
    public void testMatchAllQuery() throws Exception {
        SearchResponse response = queryService.matchAllQuery(indexName);
        System.err.println(response);
    }
    @Test
    public void testMatchQuery() throws Exception {
        SearchResponse response = queryService.matchQuery(indexName,"corpName","盒马");
        System.err.println(response);
    }
    @Test
    public void testBooleanQuery() throws Exception {
        SearchResponse response = queryService.booleanQuery(indexName, "smsContent", "收货安装", Operator.AND);
        System.err.println(response);
    }

    @Test
    public void testMultiMatchQuery() throws Exception {
        SearchResponse response = queryService.multiMatch(indexName, "北京", "province","smsContent");
        System.err.println(response);
    }
    @Test
    public void testIds()throws Exception{
        SearchResponse searchResponse = queryService.idsQuery(indexName, "2", "3", "5");
        System.err.println(searchResponse);
    }

    @Test
    public void testPrefix() throws Exception{
        SearchResponse searchResponse = queryService.prefixQuery(indexName, "corpName", "老");
        System.err.println(searchResponse);
    }
    @Test
    public void testFuzzy() throws Exception{
        SearchResponse searchResponse = queryService.fuzzyQuery(indexName, "corpName", "盒");
        System.err.println(searchResponse);
    }
    @Test
    public void testWildcard() throws Exception{
        SearchResponse corpName = queryService.wildcardQuery(indexName, "corpName", "的?");
        System.err.println(corpName);
    }
    @Test
    public void testRangeQuery() throws Exception{
        RangeQueryBuilder fee = QueryBuilders.rangeQuery("fee").gt(1).lt(10);
        SearchResponse searchResponse = queryService.rangeQuery(indexName, fee);
        System.err.println(searchResponse);
    }

    @Test
    public void testCreateScrollQuery() throws Exception{
        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        SearchResponse searchResponse = queryService.createScrollQuery(indexName, matchAllQueryBuilder, 5);
        String scrollId = searchResponse.getScrollId();
        System.err.println(searchResponse);
    }
    @Test
    public void testScrollQuery() throws Exception{
        SearchResponse searchResponse = queryService.scrollQuery("FGluY2x1ZGVfY29udGV4dF91dWlkDXF1ZXJ5QW5kRmV0Y2gBFkNOYjJzbUVTUzZ5a1pSRC1ER0QtamcAAAAAAAAPuBZvTjFidnV6VlEwQ3RQRVBKNG9pODVR");
        System.err.println(searchResponse);
    }

    @Test
    public void testBoolQuery() throws Exception{
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().minimumShouldMatch(1)
                .should(QueryBuilders.termQuery("province", "北"))
                .should(QueryBuilders.termQuery("province", "北"))
                .must(QueryBuilders.matchQuery("smsContent", "的"))
                .mustNot(QueryBuilders.termQuery("operatorId", "2"));
        SearchResponse searchResponse = queryService.boolQuery(indexName, boolQueryBuilder);
        System.err.println(searchResponse);
    }
    @Test
    public void testHighLightQuery() throws Exception {
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("smsContent", "盒马");
        HighlightBuilder highlightBuilder = new HighlightBuilder()
                .field("smsContent")
                .preTags("<span color='red'>")
                .postTags("</span>")
                .fragmentSize(0);
        SearchResponse searchResponse = queryService.highLightQuery(indexName, matchQueryBuilder, highlightBuilder);
        System.err.println(searchResponse);
        List<Map> list = new ArrayList<>();
        Arrays.stream(searchResponse.getHits().getHits()).parallel().forEach(documentFields -> {
            Map<String, HighlightField> highlightFields = documentFields.getHighlightFields();
            Map<String, Object> sourceAsMap = documentFields.getSourceAsMap();
            list.add(sourceAsMap);
            highlightFields.entrySet().parallelStream().forEach(highlightFieldEntry->{
                String fieldName = highlightFieldEntry.getKey();
                HighlightField highlightField = highlightFieldEntry.getValue();
                if (highlightField != null) {
                    Text[] fragments = highlightField.getFragments();
                    if (fragments != null) {
                        String s = fragments[0].toString();
                        sourceAsMap.put(fieldName,s);
                    }
                }
            });

        });
        System.err.println(list);
    }

    @Test
    public void testCardinalityAggre() throws Exception {
        SearchResponse response = queryService.cardinalityAggre(indexName, "province");
        //从返回结果中获取聚合的属性
        Aggregations aggregations = response.getAggregations();
        //拿到指定别名的聚合
        ParsedCardinality aggregation = aggregations.get("bieming");
        // System.err.println(aggregation);
        System.err.println(aggregation.getValue());
    }

    @Test
    public void testRangeAggre() throws Exception {
        RangeAggregationBuilder aggregationBuilder = AggregationBuilders
                .range("bieming") //别名,是一个范围类型的聚合
                .field("fee")//设置聚合的字段
                .addUnboundedTo(5.0)//小于5
                .addRange(5, 10)//大于等于5小于10
                .addUnboundedFrom(10);//大于等10
        SearchResponse response = queryService.rangeAggre(indexName, aggregationBuilder);
        ParsedRange aggregation = response.getAggregations().get("bieming");
        // System.err.println(aggregation);
        aggregation.getBuckets().parallelStream().forEach(bucket -> {
            System.err.println(bucket.getKeyAsString() +"-=--->"+ bucket.getDocCount());
        });
    }
}
