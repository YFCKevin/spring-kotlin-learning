package com.yfckevin.springkotlinlearning.data.dto

import java.io.Serializable

class RequestDto (
    val userDto: UserDto,
    val orderDto: OrderDto
) : Serializable {

}
