package com.qf.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Administrator
 * @version V1.0
 * @Project estest
 * @Package com.qf.pojo
 * @Description:
 * @Date 2022/6/20 19:39
 */

@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SmsLog {

    @JsonProperty("corpName")
    private String corpName;
    @JsonProperty("mobile")
    private String mobile;
    @JsonProperty("createDate")
    private Date createDate;
    @JsonProperty("sendDate")
    private Date sendDate;
    @JsonProperty("longCode")
    private String longCode;
    @JsonProperty("smsContent")
    private String smsContent;
    @JsonProperty("state")
    private Integer state;
    @JsonProperty("province")
    private String province;
    @JsonProperty("operatorId")
    private Integer operatorId;
    @JsonProperty("ipAddr")
    private String ipAddr;
    @JsonProperty("replyTotal")
    private Integer replyTotal;
    @JsonProperty("fee")
    private Integer fee;
}
