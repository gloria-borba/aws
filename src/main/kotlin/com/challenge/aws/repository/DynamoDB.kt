package com.challenge.aws.repository

import com.challenge.aws.constants.CUSTOMER_TABLE_NAME
import com.challenge.aws.model.Customer
import org.springframework.stereotype.Component
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException
import java.lang.Exception

@Component
class DynamoDB(private val dynamoDbClient: DynamoDbClient) {

    //Todo Deixar genérico, usar T
    fun get(): List<Customer>? {
        val enhancedClient = DynamoDbEnhancedClient.builder()
            .dynamoDbClient(dynamoDbClient)
            .build()

        try {
            val table: DynamoDbTable<Customer> = enhancedClient.table(CUSTOMER_TABLE_NAME, TableSchema.fromBean(Customer::class.java))
            val results: Iterator<Customer> = table.scan().items().iterator()
            return results.asSequence().toList()
        } catch (e: DynamoDbException) {
            e.printStackTrace()
        } catch (e: Exception){
            e.printStackTrace()
        }
        return null
    }
}
