package com.qf.Provider;

import com.qf.pojo.TbUser;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatis2
 * @Package com.qf.Provider
 * @Description:
 * @Date 2022/5/17 16:59
 */

public class MyProvider {

    public String updateUser(TbUser tbUser){
        StringBuilder sb = new StringBuilder("update tb_user set ");
        if (tbUser.getEmail() != null &&tbUser.getEmail() != ""){
            sb.append("email=").append("#{email}").append(",");
        }
        if (tbUser.getEmail() != null &&tbUser.getEmail() != ""){
            sb.append("code=").append("#{code}").append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(" where id =").append("#{id}");
        String sql = sb.toString();
        System.err.println(sql);
        return sql;
    }

}
