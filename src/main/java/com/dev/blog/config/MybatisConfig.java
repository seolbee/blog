package com.dev.blog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan(basePackages = {"com.dev.blog.mapper"})
public class MybatisConfig {

}
