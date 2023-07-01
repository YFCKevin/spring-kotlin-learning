package com.yfckevin.springkotlinlearning.reactor.impl

import com.yfckevin.springkotlinlearning.api.ApiService
import com.yfckevin.springkotlinlearning.reactor.RxService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class RxServiceImpl : RxService {

    private val webClient = WebClient.builder().build()

    override suspend fun decodedBase64(encodedStr: String) = doBase64Decoded(encodedStr)
    
    override suspend fun decodedBase64(encodedStrs: List<String>) =
        coroutineScope {
            encodedStrs.map {
                async(Dispatchers.IO) { doBase64Decoded(it) }
            }.toList().awaitAll()
        }

    private suspend fun doBase64Decoded(encodedStr: String) = webClient.get()
            .uri("https://httpbin.org/base64/${encodedStr}")
            .retrieve()
            .awaitBody<String>()
}