package com.qf.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.util.StringUtils;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User implements CheckNull{

  private Long id;
  private String username;
  private String password;
  private String realname;
  private String email;
  private String gender;
  private Long flag;
  private Long role;

  @Override
  public boolean isEmpty(CheckType type) {
    switch (type){
      case ADD:
        return !StringUtils.hasText(username)&&!StringUtils.hasText(password)&&!StringUtils.hasText(realname)&&!StringUtils.hasText(email)&&!StringUtils.hasText(gender);
      case UPDATE:
        return false;
    }
    return false;
  }
}
