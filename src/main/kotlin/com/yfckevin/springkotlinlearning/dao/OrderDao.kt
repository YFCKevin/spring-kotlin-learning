package com.yfckevin.springkotlinlearning.dao

import com.yfckevin.springkotlinlearning.data.entity.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface OrderDao : JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
}