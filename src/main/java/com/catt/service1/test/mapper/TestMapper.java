package com.catt.service1.test.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.catt.service1.test.entity.TCutoverRelAlarm;

@DS("catt")
public interface TestMapper extends BaseMapper<TCutoverRelAlarm> {

}
