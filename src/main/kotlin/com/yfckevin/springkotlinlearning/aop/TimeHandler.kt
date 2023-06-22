package com.yfckevin.springkotlinlearning.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch

@Aspect
@Component
class TimeHandler {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Pointcut("execution(* com.yfckevin.springkotlinlearning.controller..*(..))")
    fun pointCut(){}

    @Around("pointCut()")
    fun around(proceedingJoinPoint: ProceedingJoinPoint){
        val stopWatch = StopWatch()
        stopWatch.start()
        proceedingJoinPoint.proceed()
        stopWatch.stop()

        logger.info("${proceedingJoinPoint.signature.declaringTypeName}::${proceedingJoinPoint.signature.name} cost ${stopWatch.totalTimeNanos}")
    }
}