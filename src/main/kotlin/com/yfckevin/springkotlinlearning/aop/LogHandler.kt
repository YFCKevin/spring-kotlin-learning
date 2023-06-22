package com.yfckevin.springkotlinlearning.aop

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.*

@Aspect
@Component
class LogHandler {

    private val logger = LoggerFactory.getLogger(javaClass)

    // 要在何處觸發
    @Pointcut("execution(* com.yfckevin.springkotlinlearning.controller..*(..))")
    fun pointCut(){}

    // 實際上要做什麼事
    @Before("pointCut()")
    fun log(joinPoint: JoinPoint){
        logger.info("log handler args -> ${Arrays.toString(joinPoint.args)}")
    }
}