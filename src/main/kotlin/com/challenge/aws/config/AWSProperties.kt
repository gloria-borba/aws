package com.challenge.aws.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "aws")
class AWSProperties(
    var accessKey: String? = null,
    var secretKey: String? = null,
    var region: String? = "us-east-1"
)
