package com.yfckevin.springkotlinlearning.service.impl

import com.yfckevin.springkotlinlearning.dao.OrderDao
import com.yfckevin.springkotlinlearning.dao.UserDao
import com.yfckevin.springkotlinlearning.data.dto.OrderDto
import com.yfckevin.springkotlinlearning.data.dto.RequestDto
import com.yfckevin.springkotlinlearning.data.entity.Order
import com.yfckevin.springkotlinlearning.service.OrderService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class OrderServiceImpl (
    val orderDao: OrderDao,
    val userDao: UserDao
) : OrderService {

    @Transactional(rollbackFor = [Exception::class])
    override fun addOrderBeforeCreateUser(requestDto: RequestDto) = run {

        val savedUser = userDao.save(requestDto.userDto.toDo())

        val saveOrder = orderDao.save(Order(null, savedUser.id!!, savedUser.firstName, requestDto.orderDto.orderPrice, LocalDateTime.now()))

        OrderDto(requestDto.userDto.id, saveOrder.orderPrice, saveOrder.createTime, "A0" + saveOrder.userId, saveOrder.firstName!!)
    }
}