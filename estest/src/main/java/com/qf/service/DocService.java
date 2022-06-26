package com.qf.service;

import org.elasticsearch.action.bulk.BulkRequest;

/**
 * @author Administrator
 * @version V1.0
 * @Project estest
 * @Package com.qf.service
 * @Description:
 * @Date 2022/6/20 20:21
 */

public interface DocService {
    void addDoc(String index,String json) throws Exception;
    void addDoc(String index,String id,String json) throws Exception;
    void getDoc(String index, String id) throws Exception;
    void updateDoc(String index, String id, String json) throws Exception;
    void deleteDoc(String index, String id) throws Exception;
    void bulkDoc(BulkRequest bulkRequest) throws Exception;
}
