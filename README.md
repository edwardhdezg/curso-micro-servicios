# Microservicios con Spring Cloud, Docker y Kubernetes

## Descripción del Proyecto

Este proyecto se centra en la implementación de una arquitectura de microservicios utilizando tecnologías modernas como Spring Cloud, Docker y Kubernetes. El objetivo es crear una aplicación distribuida, escalable y resiliente.

![Microservices](https://img-c.udemycdn.com/course/750x422/3590282_d81a_4.jpg)

## Tecnologías Utilizadas

### Java 17
Java 17 es la última versión LTS (Long-Term Support) de Java. Ofrece nuevas características y mejoras de rendimiento, así como soporte a largo plazo, lo que lo hace ideal para aplicaciones empresariales.

### Spring Boot
Spring Boot simplifica el desarrollo de aplicaciones basadas en Spring. Proporciona un marco de trabajo que permite crear aplicaciones robustas y de alto rendimiento con configuración mínima. Spring Boot se encarga de las configuraciones iniciales y ofrece características para el monitoreo y la administración de aplicaciones.

### Feign
Feign es un cliente HTTP declarativo para crear servicios web. Facilita las llamadas a servicios RESTful mediante la definición de interfaces Java. Esto permite una mayor legibilidad y una reducción en el código necesario para las solicitudes HTTP.

### Spring Cloud
Spring Cloud proporciona herramientas para desarrollar aplicaciones distribuidas. Facilita la configuración y el despliegue de microservicios, ofreciendo soluciones para problemas comunes en sistemas distribuidos, como la configuración centralizada, descubrimiento de servicios y balanceo de carga.

### Docker
Docker es una plataforma que permite empaquetar aplicaciones y sus dependencias en contenedores. Los contenedores garantizan que la aplicación se ejecute de manera consistente en cualquier entorno, lo que simplifica el desarrollo, las pruebas y el despliegue de aplicaciones.

### Kubernetes
Kubernetes es un sistema de orquestación de contenedores que automatiza la implementación, el escalado y la gestión de aplicaciones en contenedores. Proporciona una infraestructura robusta para la gestión de contenedores Docker, permitiendo el escalado automático y el equilibrio de carga de las aplicaciones.

### AWS EC2
Amazon Elastic Compute Cloud (EC2) es un servicio web que proporciona capacidad de computación escalable en la nube de AWS. Permite lanzar y gestionar instancias de servidores virtuales, facilitando el despliegue de aplicaciones a gran escala y ofreciendo flexibilidad y control sobre los recursos de computación.

## Beneficios de Cada Tecnología

- **Java 17:** Mejora de rendimiento y nuevas características con soporte a largo plazo.
- **Spring Boot:** Simplificación en el desarrollo y configuración de aplicaciones Java.
- **Feign:** Reducción de código y mayor claridad en las llamadas a servicios RESTful.
- **Spring Cloud:** Facilita la creación y gestión de microservicios distribuidos.
- **Docker:** Empaquetado y despliegue consistente de aplicaciones en cualquier entorno.
- **Kubernetes:** Automatización de la gestión, escalado y despliegue de contenedores, asegurando alta disponibilidad y escalabilidad.
- **AWS EC2:** Escalabilidad y flexibilidad en el despliegue de aplicaciones con control total sobre los recursos de computación.

## Estructura del Proyecto

La estructura del proyecto sigue la arquitectura de microservicios, donde cada componente es un servicio independiente que interactúa con otros servicios a través de interfaces definidas. Cada microservicio está empaquetado en un contenedor Docker y desplegado en un clúster de Kubernetes.
