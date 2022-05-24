package com.qf.exceptions;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.exceptions
 * @Description:
 * @Date 2022/5/25 0:15
 */

public class QueryException extends BaseException{
    public QueryException(String message, int code) {
        super(message, code);
    }
}
