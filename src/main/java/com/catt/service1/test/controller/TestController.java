package com.catt.service1.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.catt.service1.test.entity.TCutoverRelAlarm;
import com.catt.service1.test.mapper.CommonMapper;
import com.catt.service1.test.mapper.TestMapper;
import com.catt.service1.test.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "端口测试啊")
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

    @ApiOperation(value = "获取当前端口号", notes = "测试获取端口")
    @GetMapping(value = "/getTestPort")
    public String getTestPort() {
        return "当前的端口号是：" + port;
    }

    @ApiOperation(value = "获取当前输入得端口号", notes = "测试获取输入端口")
    @ApiImplicitParam(paramType = "query", name = "id", value = "端口id", required = true, dataType = "String")
    @GetMapping(value = "/getTestPort1")
    public String getTestPort(@RequestParam(value = "id", required = false) String id) {
        return "当前的端口号是：" + id;
    }

    @ApiOperation(value = "获取当前告警", notes = "测试获取告警")
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
