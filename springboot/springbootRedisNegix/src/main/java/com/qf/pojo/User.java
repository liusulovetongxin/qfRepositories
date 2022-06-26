package com.qf.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.util.StringUtils;

/**
 * @author Administrator
 * @version V1.0
 * @Project springbootRedisNegix
 * @Package com.qf.pojo
 * @Description:
 * @Date 2022/6/18 14:39
 */
@Data
@ToString
public class User implements CheckNull {
    private Long id;
    private String username;
    private String password;

    @Override
    public boolean isEmpty() {
        return !StringUtils.hasText(username)&&!StringUtils.hasText(password);
    }
}
