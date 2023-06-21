package com.yfckevin.springkotlinlearning.mq

import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import kotlin.math.log

@Component
class MessageReceivers {

    private val logger = LoggerFactory.getLogger(javaClass)

    @RabbitListener(queues = ["simple"])
    fun handleSimple(msg: String) = logger.info("simple -> $msg")

    @RabbitListener(queues = ["broadcast"])
    fun handleBroadcast(msg: String) = logger.info("broadcast -> $msg")
}