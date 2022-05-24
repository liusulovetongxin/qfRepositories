package com.qf.advices;

import com.qf.dto.R;
import com.qf.exceptions.BaseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Administrator
 * @version V1.0
 * @Project springmvc
 * @Package com.qf.advices
 * @Description:
 * @Date 2022/5/24 23:38
 */
@RestControllerAdvice
public class MyExceptionAdvice {
    @ExceptionHandler
    public R processBaseException(BaseException baseException){
        baseException.printStackTrace();
        return R.setResult(baseException.getCode(), baseException.getMessage(), null);
    }
}
