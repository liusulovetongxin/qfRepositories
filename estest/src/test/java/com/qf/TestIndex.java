package com.qf;

import com.qf.config.EsConfig;
import com.qf.service.IndexService;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.xcontent.XContentBuilder;
import org.elasticsearch.xcontent.json.JsonXContent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Administrator
 * @version V1.0
 * @Project estest
 * @Package com.qf
 * @Description:
 * @Date 2022/6/20 19:58
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EsConfig.class)
public class TestIndex {
    private String indexName = "sms-logs-index-zck";
    private IndexService indexService;

    @Autowired
    public void setIndexService(IndexService indexService) {
        this.indexService = indexService;
    }

    @Test
    public void testCreateIndex() throws Exception{
        CreateIndexRequest request = new CreateIndexRequest(indexName);
        request.settings(Settings.builder()
                .put("number_of_shards",5)
                .put("number_of_replicas",1));
        XContentBuilder builder = JsonXContent.contentBuilder()
                .startObject()
                .startObject("properties")
                .startObject("corpName").field("type", "keyword").endObject()
                .startObject("createDate").field("type", "date").field("format", "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis").endObject()
                .startObject("fee").field("type", "integer").endObject()
                .startObject("ipAddr").field("type", "ip").endObject()
                .startObject("longCode").field("type", "keyword").endObject()
                .startObject("mobile").field("type", "keyword").endObject()
                .startObject("operatorId").field("type", "integer").endObject()
                .startObject("province").field("type", "keyword").endObject()
                .startObject("replyTotal").field("type", "integer").endObject()
                .startObject("state").field("type", "integer").endObject()
                .startObject("smsContent").field("type", "text").field("analyzer", "ik_max_word").endObject()
                .startObject("sendDate").field("type", "date").field("format", "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis").endObject()
                .endObject()
                .endObject();
        request.mapping(builder);
        CreateIndexResponse response = indexService.createIndex(indexName, request);
        System.err.println(response);
    }
    @Test
    public void testDelete() throws Exception {
        AcknowledgedResponse response = indexService.deleteIndex(indexName);
        System.err.println(response);
    }
    @Test
    public void testGet() throws Exception {
        indexService.getIndex(indexName);
    }


}
