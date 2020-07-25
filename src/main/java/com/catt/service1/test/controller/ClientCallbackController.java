package com.catt.service1.test.controller;


import com.catt.service1.test.entity.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ClientCallbackController {


    @GetMapping("/user/{username}")
    public UserVO user(@PathVariable String username) {
        return new UserVO(username, username + "@foxmail.com");
    }

    @GetMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication) {
        return authentication;
    }


}