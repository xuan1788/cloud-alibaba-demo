package com.yx.boot.config;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/10/4 15:32
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@ComponentScan(basePackages = "com.yyg.boot.web")
public class Swagger2Config {

        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.any())
                    .apis(RequestHandlerSelectors.basePackage("com.yx.boot.web"))
                    //.paths(PathSelectors.any())
                    .build()
                    .apiInfo(apiInfo());
        }

        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("XXX项目接口文档")
                    .description("XXX项目接口测试")
                    .version("1.0.1")
                    .contact(new Contact("一一哥","https://yiyige.blog.csdn.net/","2312119590"))
                    .termsOfServiceUrl("")
                    .license("")
                    .licenseUrl("")
                    .build();
        }
}
