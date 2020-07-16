package com.catt.service1.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.catt.service1.test.entity.TCutoverRelAlarm;
import com.catt.service1.test.mapper.CommonMapper;
import com.catt.service1.test.mapper.TestMapper;
import com.catt.service1.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Huang Zhi Jie
 * @time: 2020/5/22 18:15
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Value("${server.port}")
    String port;
    @Autowired
    private TestService testService;
    @Autowired
    private TestMapper testMapper;

    @Autowired
    private CommonMapper commonMapper;

    @GetMapping(value = "/getTestPort")
    public String getTestPort() {
        return "当前的端口号是：" + port;
    }

    @GetMapping(value = "/getTestPort1")
    public String getTestPort(@RequestParam(value = "id", required = false) String id) {
        return "当前的端口号是：" + id;
    }

    @GetMapping(value = "/list/alarm")
    public List<TCutoverRelAlarm> alarm() {
        return testMapper.selectList(null);
    }

    @GetMapping(value = "/list/table")
    public List<Map<Object, Object>> table() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.apply("TABLE_SCHEMA = (select database())");
        return commonMapper.selectTableInfoByMyWrapper(queryWrapper);
    }

    @GetMapping(value = "/list/tableInfo")
    public List<Map<Object, Object>> tableInfo(@RequestParam(value = "tableName", required = true) String tableName) {
        return commonMapper.selectByName(tableName);
    }
}
