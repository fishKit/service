package com.catt.service1.test.entity;

import lombok.Data;

/**
 * @description:
 * @author: Huang Zhi Jie
 * @time: 2020/7/23 11:29
 */
@Data
public class Jwt {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private int expires_in;
    private String scope;
    private String jti;
}
