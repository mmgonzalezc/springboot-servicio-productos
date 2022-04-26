package com.formacionbdi.springboot.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/***
 * Actuará como un cliente de descubrimiento de spring y se registrará en el servidor eureka
 */
@EnableEurekaClient
@SpringBootApplication
public class SpringbootServicioProductosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServicioProductosApplication.class, args);
    }

}
