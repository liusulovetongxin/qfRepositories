package com.qf.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.qf.constant.ResultCode;
import lombok.Data;

/**
 * @author Administrator
 * @version V1.0
 * @Project MySSMdemo1
 * @Package com.qf.dto
 * @Description:
 * @Date 2022/5/25 1:34
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class R {
    private int code;
    private String msg;
    private Object data;

    public  static R setOk(){
        return setOk(null);
    }
    public static R setOk(Object data){
        return R.setResult(ResultCode.SUCCESS, "成功", data);
    }

    public static R setError(){
        return setError(null);
    }
    public static R setError(Object data){
        return setResult(ResultCode.ERROR, "失败", data);
    }
    public static R setResult(int code,String msg,Object data){
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
}
