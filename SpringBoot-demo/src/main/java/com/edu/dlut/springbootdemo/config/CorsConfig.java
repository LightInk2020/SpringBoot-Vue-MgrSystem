//package com.edu.dlut.springbootdemo.config;
//
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * ClassName: CrosConfig
// * Description:
// * Date: 2021/9/27 21:49
// *
// * @author Crescent
// * @version 1.0
// * @since JDK 1.8
// */
//@SpringBootConfiguration
//public class CorsConfig implements WebMvcConfigurer {
//
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")//允许来访问的主机+端口当。仍然报错时，我们可以把.allowedOrigins("*")改成.allowedOriginPatterns("*")
//                .allowedMethods("GET","POST","HEAD","PUT","DELETE","OPTIONS")
//                .allowCredentials(true)
//                .maxAge(3600)
//                .allowedHeaders("*");
//    }
//}
