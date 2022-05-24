package com.qf.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TbUser implements CheckNull {

  private Long id;
  private String username;
  private String password;
  private String email;
  private String gender;
  private Long flag;
  private Long role;
  private String code;


  @Override
  public boolean isEmpty(CheckType type) {
    switch (type){
      case ADD:
        return !StringUtils.hasText(email) || !StringUtils.hasText(password) || !StringUtils.hasText(gender) || !StringUtils.hasText(username);
      case UPDATE:
        return (ObjectUtils.isEmpty(id) || id <= 0) || (!StringUtils.hasText(email)
                && !StringUtils.hasText(password)
                && !StringUtils.hasText(gender)
                && !StringUtils.hasText(code)
                && ObjectUtils.isEmpty(flag)
                && ObjectUtils.isEmpty(role));
    }
    return false;
  }
}
