package com.yfckevin.springkotlinlearning.data.dto

import com.yfckevin.springkotlinlearning.data.enu.Gender
import java.io.Serializable
import java.time.LocalDateTime

data class OrderDto (

    val id: Long?,

    val orderPrice: Int,

    val createTime: LocalDateTime,

    val uid: String,

    val firstName: String,
) : Serializable {

}
