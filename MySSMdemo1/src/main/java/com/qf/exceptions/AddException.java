package com.qf.exceptions;

/**
 * @author Administrator
 * @version V1.0
 * @Project MySSMdemo1
 * @Package com.qf.exceptions
 * @Description:
 * @Date 2022/5/25 1:30
 */

public class AddException extends BaseException{
    public AddException(String message, int code) {
        super(message, code);
    }
}
