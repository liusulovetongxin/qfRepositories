package com.qf.exceptions;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.exceptions
 * @Description:
 * @Date 2022/5/24 23:33
 */

public class BaseException extends RuntimeException {
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
