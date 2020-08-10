package com.eb.demo.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author Louhwz
 * @Date 2020/08/10
 * @Time 20:17
 */

@EnableZuulProxy
@SpringBootApplication
@EnableSwagger2
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
