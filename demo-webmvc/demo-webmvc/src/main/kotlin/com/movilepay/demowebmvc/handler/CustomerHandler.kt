package com.movilepay.demowebmvc.handler

import com.movilepay.demowebmvc.model.Customer
import com.movilepay.demowebmvc.repository.CustomerRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class CustomerHandler(private val customerRepository: CustomerRepository) {

    suspend fun postCustomer(request: ServerRequest): ServerResponse {
        val customer = request.awaitBody<Customer>()
        return ok().bodyValueAndAwait(customerRepository.save(customer))
    }

}
