package com.yfckevin.springkotlinlearning.api

import reactor.core.publisher.Mono

interface ApiService {

    fun decodedBase64(encodedStr: String): Mono<String>
    fun decodedBase64(encodedStrs: List<String>): Mono<MutableList<String>>
}