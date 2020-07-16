package com.catt.service1.test.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@DS("catt")
public interface CommonMapper extends BaseMapper {

    //@Select("select TABLE_SCHEMA, TABLE_NAME, TABLE_COMMENT, VERSION, TABLE_ROWS, CREATE_TIME, UPDATE_TIME from information_schema.TABLES where TABLE_SCHEMA = (select database()) and TABLE_NAME ")
    @Select("select TABLE_SCHEMA, TABLE_NAME, TABLE_COMMENT, VERSION, TABLE_ROWS, CREATE_TIME, UPDATE_TIME from information_schema.TABLES ${ew.customSqlSegment}")
    List<Map<Object, Object>> selectTableInfoByMyWrapper(@Param(Constants.WRAPPER) Wrapper tableWrapper);

    /**
     * 和Mybatis使用方法一致
     *
     * @param tableName
     * @return
     */
    @Select("select *\n" +
            "from information_schema.COLUMNS\n" +
            "where TABLE_SCHEMA = (select database())\n" +
            "  AND TABLE_NAME = #{tableName}")
    List<Map<Object, Object>> selectByName(@Param("tableName") String tableName);
}
