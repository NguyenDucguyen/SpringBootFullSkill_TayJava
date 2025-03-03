package vn.tayjava.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class AppConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//       registry.addMapping("/**")
//               .allowCredentials(true)
//               .allowedOrigins("http://localhost:8080")
//               .allowedHeaders("*")
//               .allowedMethods("*");
//    }

//    @Bean
//    public WebMvcConfigurer corsFilter() {
//        return new WebMvcConfigurer() {
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowCredentials(true)
//                        .allowedOrigins("http://localhost:8080")
//                        .allowedHeaders("*")
//                        .allowedMethods("*");
//            }
//        };
//    }
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:8080");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
