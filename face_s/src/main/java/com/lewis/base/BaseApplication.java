package com.lewis.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication

@MapperScan("com.lewis.base.mapper")//与dao层的@Mapper二选一写上即可(主要作用是扫包)
public class BaseApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BaseApplication.class);
    }

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
    }
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
    //    corsConfiguration.addExposedHeader(HttpHeaderConStant.X_TOTAL_COUNT);
        return corsConfiguration;
    }

    /**
     * 跨域过滤器
     *
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }
}