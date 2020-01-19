package com.movilepay.demoweb.repository

import com.movilepay.demoweb.model.Customer
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class CustomerRepository(private val jdbcTemplate: JdbcTemplate) {

    private val namedTemplate by lazy {
        NamedParameterJdbcTemplate(jdbcTemplate)
    }

    fun save(customer: Customer): Customer {
        val sql = """
            INSERT INTO customer VALUES (
                :id,
                :name
            )
        """.trimIndent()

        val params = mapOf(
                "id" to customer.id,
                "name" to customer.name
        )

        namedTemplate.update(sql, params)

        return customer
    }
}
