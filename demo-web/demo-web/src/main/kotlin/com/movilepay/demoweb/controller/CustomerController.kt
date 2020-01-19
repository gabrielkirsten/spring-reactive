package com.movilepay.demoweb.controller

import com.movilepay.demoweb.model.Customer
import com.movilepay.demoweb.repository.CustomerRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("customers")
class CustomerController(private val customerRepository: CustomerRepository) {

    @PostMapping
    fun postCustomer(@RequestBody customer: Customer) = customerRepository.save(customer)

}