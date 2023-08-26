package com.example.springwebfluxcrud;

import com.example.springwebfluxcrud.controller.EmployeeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class SpringWebfluxCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebfluxCrudApplication.class, args);
    }

    @Bean
    RouterFunction<ServerResponse> routes(EmployeeController employeeController) {
        return
                nest(path("/api/posts"),
                        nest(accept(MediaType.APPLICATION_JSON),
                                route(method(HttpMethod.GET), employeeController::getEmployee)
                                        .andRoute(DELETE("/{id}"), employeeController::deleteEmployee)
                                        .andRoute(POST("/"), employeeController::saveEmployee)
                                        .andRoute(PUT("/{id}"), employeeController::updateEmployee)));

    }
}
