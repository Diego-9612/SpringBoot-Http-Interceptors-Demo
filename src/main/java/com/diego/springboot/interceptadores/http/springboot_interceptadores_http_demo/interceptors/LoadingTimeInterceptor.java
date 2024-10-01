package com.diego.springboot.interceptadores.http.springboot_interceptadores_http_demo.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Interceptor que mide el tiempo de carga de las solicitudes.
 */
@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

    // Logger para registrar los eventos en el sistema de logs
    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    /**
     * Se ejecuta después de que el controlador maneja la solicitud, pero antes de
     * que se renderice la vista.
     * 
     * @param request      objeto HttpServletRequest que contiene la solicitud del
     *                     cliente.
     * @param response     objeto HttpServletResponse que contiene la respuesta del
     *                     servidor.
     * @param handler      el controlador que maneja la solicitud.
     * @param modelAndView la vista y el modelo a renderizar.
     * @throws Exception si ocurre algún error.
     */

    /**
     * Se ejecuta antes de que el controlador maneje la solicitud.
     * 
     * @param request  objeto HttpServletRequest que contiene la solicitud del
     *                 cliente.
     * @param response objeto HttpServletResponse que contiene la respuesta del
     *                 servidor.
     * @param handler  el controlador que maneja la solicitud.
     * @return true si la ejecución debe continuar, false si se detiene.
     * @throws Exception si ocurre algún error.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HandlerMethod controller = ((HandlerMethod) handler);
        logger.info("LoadingTimeInterceptor:preHandle() Entrando..." + controller.getMethod().getName());
        long start = System.currentTimeMillis();
        request.setAttribute("start", start);

        Random random = new Random();
        int delay = random.nextInt(500);
        Thread.sleep(delay);


        //Map<String, String> json = new HashMap<>();
        //json.put("error", "no tienes acceso a esta pagina");
        //json.put("date", new Date().toString());

        //ObjectMapper mapper = new ObjectMapper();
        //String jsoString = mapper.writeValueAsString(json);
        //response.setContentType("aplication/json");
        //response.setStatus(401);
        //response.getWriter().write(jsoString);


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        long end = System.currentTimeMillis();
        long start = (long) request.getAttribute("start");
        long result = end - start;
        logger.info("tiempo transcurrido" + result + "milisegundos");

        logger.info(
                "LoadingTimeInterceptor:postHandle() Saliendo..." + ((HandlerMethod) handler).getMethod().getName());
    }

}