package com.qf.service.impl;

import com.qf.service.IndexService;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.MappingMetadata;
import org.elasticsearch.common.settings.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Administrator
 * @version V1.0
 * @Project estest
 * @Package com.qf.service.impl
 * @Description:
 * @Date 2022/6/20 19:43
 */

@Service
public class IndexServiceImpl implements IndexService {
    private RestHighLevelClient client;

    @Autowired
    public void setClient(RestHighLevelClient client) {
        this.client = client;
    }

    @Override
    public CreateIndexResponse createIndex(String index, CreateIndexRequest createIndexRequest) throws Exception {
        if (!indexExist(index)) {
            CreateIndexResponse response = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            return response;
        }
        return null;

    }

    @Override
    public boolean indexExist(String index) throws Exception {
        GetIndexRequest request = new GetIndexRequest(index);
        return client.indices().exists(request, RequestOptions.DEFAULT);
    }

    @Override
    public AcknowledgedResponse deleteIndex(String index) throws Exception {
        if (indexExist(index)) {
            DeleteIndexRequest request = new DeleteIndexRequest(index);
            AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
            return response;
        }
        return null;
    }

    @Override
    public void getIndex(String index) throws Exception {
        GetIndexRequest request = new GetIndexRequest(index);
        GetIndexResponse response = client.indices().get(request, RequestOptions.DEFAULT);
        Map<String, MappingMetadata> mappings = response.getMappings();
        Map<String, Settings> settings = response.getDefaultSettings();
        System.err.println(response);
    }


}
