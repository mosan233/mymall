package com.sf.mymall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/*
* mybatis类
* */

@Configuration
@EnableTransactionManagement//开启事务管理器
@MapperScan({"com.sf.mymall.mapper"})//扫描包
public class MybatisConfig {
}
