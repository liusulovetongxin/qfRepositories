package com.qf.result;

import lombok.Data;

/**
 * @author Administrator
 * @version V1.0
 * @Project springbootRedisNegix
 * @Package com.qf.result
 * @Description:
 * @Date 2022/6/19 19:46
 */
@Data
public class R {
    private boolean code;
    private String msg;
    private Object result;

    public static R setOk(){
        return setOk(null);
    }
    public static R setOk(Object result){
        return setResult(true, "成功", result);
    }
    public static R setError(){
        return setError(null);
    }
    public static R setError(Object result){
        return setResult(false, "失败", result);
    }

    public static R setResult(boolean code,String msg,Object result){
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        r.setResult(result);
        return r;
    }
}
