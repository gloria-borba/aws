package com.challenge.aws.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient

@Configuration
class DynamoConfig {

    @Bean
    fun createDynamoClient(config: AWSProperties): DynamoDbClient {
        val client = DynamoDbClient.builder()
            .region(Region.of(config.region))

        client.credentialsProvider(
                StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(config.accessKey, config.secretKey)
                )
        )

        return client.build()
    }
}
