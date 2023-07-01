package com.yfckevin.springkotlinlearning.reactor

interface RxService {

    suspend fun decodedBase64(encodedStr: String): String
    suspend fun decodedBase64(encodedStrs: List<String>): List<String>
}