package com.yfckevin.springkotlinlearning.reactor

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/demoRx")
class DemoRxController (
    val rxService: RxService
){

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/{encodedStr}")
    suspend fun get(@PathVariable encodedStr: String) = also {
         logger.info(encodedStr)
    }.run {
        rxService.decodedBase64(encodedStr)
    }

    @PostMapping
    suspend fun decodedBase64Str(@RequestBody base64Strs: List<String>) = also {
        logger.info(base64Strs.toString())
    }.run {
        rxService.decodedBase64(base64Strs)
    }
}