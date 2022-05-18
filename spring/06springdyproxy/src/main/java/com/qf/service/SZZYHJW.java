package com.qf.service;

/**
 * @author Administrator
 * @version V1.0
 * @Project spring
 * @Package com.qf.service
 * @Description:
 * @Date 2022/5/18 20:55
 */

public class SZZYHJW {
    public void StringAppend(String s){
        StringBuilder sb = new StringBuilder("书中自有颜如玉");
        sb.append(s);
        System.err.println(sb.toString());
    }
}
