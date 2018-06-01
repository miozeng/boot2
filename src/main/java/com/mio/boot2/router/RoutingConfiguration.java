package com.mio.boot2.router;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfiguration {
	
//    @Bean
//    public RouterFunction<ServerResponse> monoRouterFunction(CustomerHandler customerHandler) {
//        return route(GET("/api/customer").and(accept(MediaType.APPLICATION_JSON)), customerHandler::getAll)
//        		.andRoute(GET("/api/customer/{id}").and(accept(MediaType.APPLICATION_JSON)), customerHandler::getCustomer)
//        		.andRoute(POST("/api/customer/post").and(accept(MediaType.APPLICATION_JSON)), customerHandler::postCustomer)
//                .andRoute(PUT("/api/customer/put/{id}").and(accept(MediaType.APPLICATION_JSON)), customerHandler::putCustomer)
//                .andRoute(DELETE("/api/customer/delete/{id}").and(accept(MediaType.APPLICATION_JSON)), customerHandler::deleteCustomer);
//    }
//    
}