package com.qf.pojo;

import lombok.Data;

@Data
public class TbUser {

  private Long id;
  private String username;
  private String password;
  private String email;
  private String gender;
  private Long flag;
  private Long role;
  private String code;

}
