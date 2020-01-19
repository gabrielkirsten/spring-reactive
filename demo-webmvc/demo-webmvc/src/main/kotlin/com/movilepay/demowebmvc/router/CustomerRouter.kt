package com.movilepay.demowebmvc.router

import com.movilepay.demowebmvc.handler.CustomerHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class CustomerRouter {

    @Bean
    fun postCustomer(handler: CustomerHandler) = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            "/customers".nest {
                POST("", handler::postCustomer)
            }
        }
    }

}