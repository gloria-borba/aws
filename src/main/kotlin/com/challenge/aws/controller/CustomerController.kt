package com.challenge.aws.controller

import com.challenge.aws.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customer")
class CustomerController {

    @Autowired
    private lateinit var service: CustomerService

    @GetMapping
    fun get(): ResponseEntity<Any> {
        val customers = service.get()
        return ResponseEntity(customers, HttpStatus.OK)
    }

    //TODO fazer criacao de item
}
