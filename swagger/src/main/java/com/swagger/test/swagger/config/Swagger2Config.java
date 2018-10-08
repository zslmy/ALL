package com.swagger.test.swagger.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.security.Timestamp;
import java.util.Date;


@Configuration
@EnableSwagger2
public class Swagger2Config {
    public static final String BASE_PACKAGE = "com.swagger.test.swagger.controller";
    @Value("${swagger.enable}")
    private boolean enableSwagger;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()) // 生产环境的时候关闭 swagger 比较安全
                .enable(enableSwagger) //将Timestamp类型全部转为Long类型
                .directModelSubstitute(Timestamp.class, Long.class) //将Date类型全部转为Long类型
                .directModelSubstitute(Date.class, Long.class).select() // 扫描接口的包路径，不要忘记改成自己的
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("接口服务").description(" API 服务").termsOfServiceUrl("http://swagger.io/").contact(new Contact("Swagger", "127.0.0.1", "zscool@163.com")).version("1.0").build();
    }
}
