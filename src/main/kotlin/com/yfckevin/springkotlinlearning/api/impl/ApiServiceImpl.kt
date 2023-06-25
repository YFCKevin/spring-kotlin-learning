package com.yfckevin.springkotlinlearning.api.impl

import com.yfckevin.springkotlinlearning.api.ApiService
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ApiServiceImpl : ApiService {

    private val webClient = WebClient.builder().build()

    override fun decodedBase64(encodedStr: String) = doBase64Decoded(encodedStr)
    
    override fun decodedBase64(encodedStrs: List<String>) = run {
        // 將資料轉換成Mono<String>型態，並非馬上執行
        encodedStrs.map { doBase64Decoded(it) }.toList()
    }.run {
        // 將多個獨立Mono組合成Flux，按順序發出元素，最後再將Flux內所有元素收集到List中
        Flux.mergeSequential(this).collectList()
    }

    private fun doBase64Decoded(encodedStr: String): Mono<String> = run {
        webClient.get()
            .uri("https://httpbin.org/base64/${encodedStr}")
            .retrieve()
            .bodyToMono(String::class.java)
    }

}