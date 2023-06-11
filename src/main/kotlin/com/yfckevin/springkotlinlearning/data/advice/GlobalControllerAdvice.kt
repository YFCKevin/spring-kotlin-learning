package com.yfckevin.springkotlinlearning.data.advice

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalControllerAdvice {

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException() = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("問題出現！")
}