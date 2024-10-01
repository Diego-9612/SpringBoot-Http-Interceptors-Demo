package com.diego.springboot.interceptadores.http.springboot_interceptadores_http_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuración de Spring MVC donde se registran los interceptores HTTP.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    // Inyecta el interceptor "timeInterceptor"
    @Autowired
    @Qualifier("timeInterceptor")
    private HandlerInterceptor timeInterceptor;

    /**
     * Registra el interceptor para interceptar las solicitudes HTTP.
     * 
     * @param registry registro de interceptores donde se agrega el timeInterceptor.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(timeInterceptor).addPathPatterns("app/inter");
        registry.addInterceptor(timeInterceptor).excludePathPatterns("app/inter");
    }
}
