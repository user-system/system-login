package com.ld.system.login.server.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * SwaggerConfig 配置类
 *
 * @author 王海龙
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("login")
                .description("登录相关API文档")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket debugApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName("login")
                .select()
                // 加了ApiOperation注解的方法，生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 包下的类，生成接口文档
                .apis(RequestHandlerSelectors.basePackage("com.ld.system.login.server"))
                .paths(PathSelectors.regex("^(?!auth).*$"))
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .apiInfo(apiInfo());
    }

    private List<ApiKey> securitySchemes() {
        ApiKey apiKey = new ApiKey("Authorization", "Authorization", "header");
        List<ApiKey> apiKeyList = new ArrayList<>();
        apiKeyList.add(apiKey);
        return apiKeyList;
    }

    private List<SecurityContext> securityContexts() {
        SecurityContext securityContext = SecurityContext
                .builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^(?!auth).*$"))
                .build();
        List<SecurityContext> securityContextList = new ArrayList<>();
        securityContextList.add(securityContext);
        return securityContextList;
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;

        SecurityReference securityReference = new SecurityReference("Authorization", authorizationScopes);
        List<SecurityReference> securityReferenceList = new ArrayList<>();
        securityReferenceList.add(securityReference);
        return securityReferenceList;
    }
}

