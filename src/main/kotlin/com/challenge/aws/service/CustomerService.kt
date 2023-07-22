package com.challenge.aws.service

import com.challenge.aws.model.Customer
import com.challenge.aws.repository.DynamoDB
import org.springframework.stereotype.Service

@Service
class CustomerService(private val repository: DynamoDB) {
    fun get(): List<Customer>? {
        return repository.get()
    }
}
