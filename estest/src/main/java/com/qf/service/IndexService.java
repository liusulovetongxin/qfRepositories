package com.qf.service;

import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

/**
 * @author Administrator
 * @version V1.0
 * @Project estest
 * @Package com.qf.service
 * @Description:
 * @Date 2022/6/20 19:40
 */

public interface IndexService {
    CreateIndexResponse createIndex(String index, CreateIndexRequest createIndexRequest) throws Exception;

    boolean indexExist(String index) throws Exception;

    AcknowledgedResponse deleteIndex(String index) throws Exception;

    void getIndex(String index) throws Exception;
}
