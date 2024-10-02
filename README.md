# SpringBoot-Http-Interceptors-Demo

Este proyecto es una demostración de cómo implementar interceptores HTTP en una aplicación Spring Boot. Los interceptores permiten interceptar las solicitudes HTTP antes y después de ser procesadas por los controladores, lo cual es útil para tareas como la autenticación, autorización, registro de eventos o medición de tiempos.

## Características del proyecto

- Medición del tiempo de carga de las solicitudes HTTP.
- Uso de interceptores para modificar el comportamiento antes y después de que el controlador maneje la solicitud.
- Registro de información de cada solicitud procesada.

## Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3**
- **Maven**
- **SLF4J para logging**

## Estructura del proyecto

- **Controladores**: Contienen las rutas que manejan las solicitudes HTTP.
- **Interceptors**: Lógica del interceptor para medir tiempos y realizar operaciones antes y después de los controladores.
- **Configuración**: Se configura el registro del interceptor para aplicarlo a las rutas seleccionadas.

## ¿Cómo funciona?

Este proyecto utiliza un interceptor llamado `LoadingTimeInterceptor`, que mide el tiempo que tarda en procesarse una solicitud. El interceptor:
1. Registra el tiempo de inicio en `preHandle()`, que se ejecuta antes de que la solicitud llegue al controlador.
2. Introduce un pequeño retraso aleatorio para simular un proceso que tarda en responder.
3. Calcula el tiempo total que tardó la solicitud en el método `postHandle()`, que se ejecuta después de que el controlador procesó la solicitud.
4. Muestra el tiempo transcurrido en los logs.
