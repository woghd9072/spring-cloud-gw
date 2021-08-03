package com.jaehong

import mu.KotlinLogging
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.stereotype.Component

@Component
class GWLogger {
    private val logger = KotlinLogging.logger {  }

    fun write(request: ServerHttpRequest, body: String) {
        logger.info {
            StringBuilder("HTTP REQUEST")
                    .append("URI     : ${request.method} ${request.uri}\n")
                    .append("Headers : ${request.headers}\n")
                    .append("Body    : $body")
        }
    }
    fun write(response: ServerHttpResponse, body: String) {
        logger.info {
            StringBuilder("HTTP RESPONSE")
                    .append("STATUS  : ${response.statusCode}\n")
                    .append("Headers : ${response.headers}")
                    .append("Body    : $body")
        }
    }
}