package com.yx.strategy.config;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/10/4 15:32
 */
import org.springframework.context.annotation.Bean;
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
//@ComponentScan(basePackages = "com.yx.boot.web")
public class Swagger2Config {

        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.any())
                    .apis(RequestHandlerSelectors.basePackage("com.yx.strategy"))
                    //.paths(PathSelectors.any())
                    .build()
                    .apiInfo(apiInfo());
        }

        private ApiInfo apiInfo() {
            Contact contact = new Contact("宇轩的接口测试平台", "https://172.16.1.41/xuan", "yuxuan.zhu@transwarp.cn");
            return new ApiInfoBuilder()
                    .title("量化交易平台项目，策略服务API文档")
                    .description("包含策略服务API")
                    .version("1.0.1")
                    .contact(contact)
                    .termsOfServiceUrl("")
                    .license("")
                    .licenseUrl("")
                    .build();
        }
}
