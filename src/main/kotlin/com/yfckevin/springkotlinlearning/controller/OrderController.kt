package com.yfckevin.springkotlinlearning.controller

import com.yfckevin.springkotlinlearning.data.dto.RequestDto
import com.yfckevin.springkotlinlearning.data.dto.UserDto
import com.yfckevin.springkotlinlearning.service.OrderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController (
    val orderService: OrderService
){

    @PostMapping
    fun addOrder(@RequestBody requestDto: RequestDto) = orderService.addOrderBeforeCreateUser(requestDto)
}