package com.qf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author Administrator
 * @version V1.0
 * @Project FunctionAndStream
 * @Package com.qf
 * @Description:
 * @Date 2022/6/11 17:37
 */
@Data
@ToString
@AllArgsConstructor
public class TestData {
    private Long id;
    private String username;
    private String password;
    private TestData2 data;
}
