package com.diego.springboot.interceptadores.http.springboot_interceptadores_http_demo.controllers;

import java.util.Collections;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador que maneja las solicitudes HTTP entrantes a "/app".
 */
@RestController
@RequestMapping("/app")
public class AppController {

    /**
     * Maneja las solicitudes GET en "/app/int".
     * 
     * @return un mensaje de prueba indicando que el controlador ha sido interceptado.
     */
    @GetMapping("/inter")
    public Map<String, String> interceptor() {
        return Collections.singletonMap("message", "handler intercetor del controlador");
    }

    @GetMapping("/intertwo")
    public Map<String, String> interceptorTwo() {
        return Collections.singletonMap("message", "handler intercetor Two del controlador");
    }

    @GetMapping("/intertree")
    public Map<String, String> interceptorTre() {
        return Collections.singletonMap("message", "handler intercetor Tre del controlador");
    }

}
