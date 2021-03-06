package com.sf.mymall.config;

import com.sf.mymall.base.BaseSwaggerConfig;
import com.sf.mymall.entity.SwaggerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties getProperties(){
        return SwaggerProperties.builder()
                .apiBasePackage("com.sf.mymall.controller")
                .title("mall后台系统")
                .description("mall后台相关接口文档")
                .contactName("sf")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }

}
