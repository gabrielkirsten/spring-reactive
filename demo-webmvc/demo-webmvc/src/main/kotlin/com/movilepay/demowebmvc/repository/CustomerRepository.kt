package com.movilepay.demowebmvc.repository

import com.movilepay.demowebmvc.model.Customer
import org.springframework.stereotype.Repository

@Repository
class CustomerRepository {

    fun save(customer: Customer) = customer

}
