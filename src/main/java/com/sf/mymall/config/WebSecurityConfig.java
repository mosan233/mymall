package com.sf.mymall.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;


@EnableWebSecurity//启用spring security的web安全支持
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()//添加httpServletRequest的限制访问
                .antMatchers("/home").permitAll()//配置允许访问的路径
                .anyRequest().authenticated()//其它任意请求都需认证
                .and()
                .formLogin()//添加表单认证支持
                .loginPage("/login")//登陆页面
                .permitAll()
                .and()
                .logout()//添加注销支持
                .permitAll();
    }

}