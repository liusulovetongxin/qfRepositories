package com.qf.constans;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.constans
 * @Description:
 * @Date 2022/5/24 11:59
 */

public interface ResultCode {
    int SUCCESS = 1;
    int ERROR = 0;
    int DATA_NULL = 2;
    int ID_NOTALLOWED = 3;
    int NOT_LOGIN = 401;
    int USERNAME_PASSWORD_NULL =4;
    int USERNAME_PASSWORD_ERROR =5;

}
