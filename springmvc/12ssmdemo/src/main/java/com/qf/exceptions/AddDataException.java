package com.qf.exceptions;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.exceptions
 * @Description:
 * @Date 2022/5/24 23:35
 */

public class AddDataException extends BaseException{

    public AddDataException(String message, int code) {
        super(message, code);
    }
}
