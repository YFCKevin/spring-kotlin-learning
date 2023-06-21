package com.yfckevin.springkotlinlearning

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling

@EnableCaching
@EnableAsync
@EnableScheduling
@SpringBootApplication
class SpringKotlinLearningApplication

fun main(args: Array<String>) {
	runApplication<SpringKotlinLearningApplication>(*args)
}
