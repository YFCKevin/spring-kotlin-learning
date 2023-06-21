package com.yfckevin.springkotlinlearning.config

import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Declarables
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.StringRedisTemplate

@Configuration
class AppConfig {

    @Bean
    fun stringRedisTemplate(redisConnectionFactory: RedisConnectionFactory): StringRedisTemplate {
        return StringRedisTemplate(redisConnectionFactory)
    }

    @Bean
    fun simpleQueue() = Queue("simple", false)

    @Bean
    fun broadcastQueue() = Queue("broadcast", false)

    @Bean
    fun exchange() = TopicExchange("test")

    @Bean
    fun bindings() = Declarables(
        BindingBuilder.bind(simpleQueue()).to(exchange()).with("broadcast"),
        BindingBuilder.bind(broadcastQueue()).to(exchange()).with("broadcast")
    )

}