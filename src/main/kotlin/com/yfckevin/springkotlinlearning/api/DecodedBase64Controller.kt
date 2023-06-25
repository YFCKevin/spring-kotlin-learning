package com.yfckevin.springkotlinlearning.api

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Base64
import kotlin.math.log

@RestController
@RequestMapping("/base64")
class DecodedBase64Controller (
    val apiService: ApiService
){

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/{encodedStr}")
    fun get(@PathVariable encodedStr: String) = also {
         logger.info(encodedStr)
    }.run {
        apiService.decodedBase64(encodedStr)
    }

    @PostMapping
    fun decodedBase64Str(@RequestBody base64Strs: List<String>) = also {
        logger.info(base64Strs.toString())
    }.run {
        apiService.decodedBase64(base64Strs)
    }
}