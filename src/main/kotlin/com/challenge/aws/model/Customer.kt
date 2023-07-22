package com.challenge.aws.model

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey

@DynamoDbBean
class Customer(
    @get:DynamoDbPartitionKey
    var legalDocument: String?  = null,
    @get:DynamoDbSortKey
    var email: String?  = null,
    var birthdate: String?  = null,
    var name: String?  = null,
    var phone: Long? = null
)
