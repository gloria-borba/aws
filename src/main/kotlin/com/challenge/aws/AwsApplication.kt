package com.challenge.aws

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class AwsApplication

fun main(args: Array<String>) {
    runApplication<AwsApplication>(*args)
}
