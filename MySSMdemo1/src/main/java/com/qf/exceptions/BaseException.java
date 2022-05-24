package com.qf.exceptions;

/**
 * @author Administrator
 * @version V1.0
 * @Project MySSMdemo1
 * @Package com.qf.exceptions
 * @Description:
 * @Date 2022/5/25 1:28
 */

public class BaseException extends RuntimeException{
    private int code;

    public BaseException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
