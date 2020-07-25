package com.catt.service1.test.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Huang Zhi Jie
 * @time: 2020/7/23 11:40
 */
@Slf4j
@RestController
@Api(value = "登录")
@RequestMapping("/login")
public class LoginController {
    //http://localhost:7007/oauth/token
}
