package com.movilepay.demoweb.model

import java.util.*

data class Customer(
        val id: UUID = UUID.randomUUID(),
        val name: String
)
