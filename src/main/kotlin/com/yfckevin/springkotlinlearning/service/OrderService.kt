package com.yfckevin.springkotlinlearning.service

import com.yfckevin.springkotlinlearning.dao.OrderDao
import com.yfckevin.springkotlinlearning.data.dto.OrderDto
import com.yfckevin.springkotlinlearning.data.dto.RequestDto
import com.yfckevin.springkotlinlearning.data.dto.UserDto

interface OrderService {
    fun addOrderBeforeCreateUser(requestDto: RequestDto): OrderDto
}