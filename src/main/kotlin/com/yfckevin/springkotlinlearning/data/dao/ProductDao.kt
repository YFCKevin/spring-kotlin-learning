package com.yfckevin.springkotlinlearning.data.dao

import com.yfckevin.springkotlinlearning.data.entity.Product
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductDao : MongoRepository<Product, String> {
}