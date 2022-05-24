package com.qf.exceptions;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.exceptions
 * @Description:
 * @Date 2022/5/24 23:47
 */

public class UpdataException extends BaseException{
    public UpdataException(String message, int code) {
        super(message, code);
    }
}
