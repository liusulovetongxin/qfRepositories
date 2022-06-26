package com.qf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qf.config.EsConfig;
import com.qf.pojo.SmsLog;
import com.qf.service.DocService;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author Administrator
 * @version V1.0
 * @Project estest
 * @Package com.qf
 * @Description:
 * @Date 2022/6/20 20:33
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EsConfig.class)
public class TestDoc {
    private DocService docService;

    @Autowired
    public void setDocService(DocService docService) {
        this.docService = docService;
    }
    private ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    private String indexName = "sms-logs-index";

    @Test
    public void testAddDoc() throws Exception{
        SmsLog smsLog = new SmsLog();
        smsLog.setCorpName("老王的金屋");
        smsLog.setFee(1);
        smsLog.setCreateDate(new Date());
        smsLog.setSmsContent("尊敬的用户您好,我们是诈骗公司,现在要对您实时诈骗,请您认真配合,不要不识抬举");
        smsLog.setIpAddr("10.9.12.200");
        smsLog.setMobile("13838383838");
        smsLog.setLongCode("1069123000");
        smsLog.setOperatorId(1);
        smsLog.setReplyTotal(2);
        smsLog.setState(1);
        smsLog.setProvince("北京");
        smsLog.setSendDate(new Date());
        docService.addDoc(indexName, objectMapper.writeValueAsString(smsLog));
    }
    @Test
    public void testAddWithId() throws Exception {
        SmsLog smsLog = new SmsLog();
        smsLog.setCorpName("老马拉面");
        smsLog.setFee(1);
        smsLog.setCreateDate(new Date());
        smsLog.setSmsContent("楼下办公室好热,又潮湿,空调还坏了");
        smsLog.setIpAddr("10.9.12.200");
        smsLog.setMobile("13838383838");
        smsLog.setLongCode("1069123000");
        smsLog.setOperatorId(1);
        smsLog.setReplyTotal(2);
        smsLog.setState(1);
        smsLog.setProvince("北京");
        smsLog.setSendDate(new Date());
        docService.addDoc(indexName, "2", objectMapper.writeValueAsString(smsLog));
    }
    @Test
    public void testGetDoc() throws Exception {
        docService.getDoc(indexName,"1");
    }

    @Test
    public void testUpdateDoc() throws Exception {
        SmsLog smsLog = new SmsLog();
        smsLog.setSmsContent("160块钱的冰冻切糕,名字叫钟薛高,我穷我买不起,我感觉谁买谁sb");
        docService.updateDoc(indexName,"1",objectMapper.writeValueAsString(smsLog));
    }


    @Test
    public void testDeleteDoc() throws Exception {
        docService.deleteDoc(indexName,"1");
    }

    @Test
    public void testBulk() throws Exception {
        //创建批量操作,并指定默认的index
        BulkRequest bulkRequest = new BulkRequest(indexName);
        SmsLog smsLog = new SmsLog();
        smsLog.setCorpName("老马拉面");
        smsLog.setFee(1);
        smsLog.setCreateDate(new Date());
        smsLog.setSmsContent("楼下办公室好热,又潮湿,空调还坏了");
        smsLog.setIpAddr("10.9.12.200");
        smsLog.setMobile("13838383838");
        smsLog.setLongCode("1069123000");
        smsLog.setOperatorId(1);
        smsLog.setReplyTotal(2);
        smsLog.setState(1);
        smsLog.setProvince("北京");
        smsLog.setSendDate(new Date());

        SmsLog updateBean = new SmsLog();
        updateBean.setCorpName("编程界不能没有陈依涵,就像跳高界不能没有霍金一样");
        //添加要做的批量操作
        bulkRequest.add(new IndexRequest(indexName).id("5").source(objectMapper.writeValueAsString(smsLog), XContentType.JSON))
                .add(new UpdateRequest(indexName, "1").doc(objectMapper.writeValueAsString(updateBean), XContentType.JSON))
                .add(new DeleteRequest(indexName, "2"));
        docService.bulkDoc(bulkRequest);
    }
}
