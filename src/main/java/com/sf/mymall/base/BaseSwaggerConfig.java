package com.sf.mymall.base;

import com.sf.mymall.entity.SwaggerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public abstract class BaseSwaggerConfig {

    @Bean
    public Docket createRestApi(){
        SwaggerProperties swaggerProperties = getProperties();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo(swaggerProperties))
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getApiBasePackage()))
                .paths(PathSelectors.any())
                .build();
//        if (swaggerProperties.isEnableSecurity()) {
//            docket.securitySchemes(securitySchemes()).securityContexts(securityContexts());
//        }
        return docket;
    }

    public ApiInfo apiInfo(SwaggerProperties swaggerProperties){
        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .version(swaggerProperties.getVersion())
                .contact(new Contact(swaggerProperties.getContactName(),swaggerProperties.getContactUrl(),swaggerProperties.getContactEmail()))
                .build();
    }

    public abstract SwaggerProperties getProperties();
}
