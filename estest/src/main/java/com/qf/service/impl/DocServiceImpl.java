package com.qf.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qf.service.DocService;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @version V1.0
 * @Project estest
 * @Package com.qf.service.impl
 * @Description:
 * @Date 2022/6/20 20:21
 */
@Service
public class DocServiceImpl implements DocService {
    private ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    private RestHighLevelClient client;

    @Autowired
    public void setRestHighLevelClient(RestHighLevelClient restHighLevelClient) {
        this.client = restHighLevelClient;
    }


    @Override
    public void addDoc(String index, String json) throws Exception {
        IndexRequest request = new IndexRequest(index).source(json, XContentType.JSON);
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.err.println(objectMapper.writeValueAsString(response));
    }

    @Override
    public void addDoc(String index, String id, String json) throws Exception {
        IndexRequest request = new IndexRequest(index)
                .id(id)
                .source(json, XContentType.JSON);
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.err.println(objectMapper.writeValueAsString(response));
    }
    public void getDoc(String index, String id) throws Exception {
        GetRequest getRequest = new GetRequest(index, id);
        GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);
        System.err.println(response.getSourceAsString());
    }

    @Override
    public void updateDoc(String index, String id, String json) throws Exception {
        //更新数据,指定index,和doc的id,已经要更新的内容
        UpdateRequest request = new UpdateRequest(index, id).doc(json, XContentType.JSON);
        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        System.err.println(objectMapper.writeValueAsString(response));
    }

    @Override
    public void deleteDoc(String index, String id) throws Exception {
        DeleteRequest deleteRequest = new DeleteRequest(index, id);
        DeleteResponse response = client.delete(deleteRequest, RequestOptions.DEFAULT);
        System.err.println(objectMapper.writeValueAsString(response));
    }

    @Override
    public void bulkDoc(BulkRequest bulkRequest) throws Exception {
        BulkResponse response = client.bulk(bulkRequest, RequestOptions.DEFAULT);
//        System.err.println(objectMapper.writeValueAsString(response));
        System.err.println(response.toString());
    }
}
