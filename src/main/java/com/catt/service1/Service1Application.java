package com.catt.service1;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/***
 * @Author: Huang Zhi Jie
 * @Description: http://localhost:8001/test/getTestPort
 * @Date: 2020/7/14  19:39
 * @Param null:
 * @return: null
 **/
// 去掉springboot 默认的数据源配置
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
// 扫描mapper的包，或者读者可以在对应的mapper上加上@Mapper的注解
@MapperScan("com.catt.service1.test.mapper")
public class Service1Application {

    public static void main(String[] args) {
        SpringApplication.run(Service1Application.class, args);
    }

    /**
     * MP分页插件,后面会有说明
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


}
