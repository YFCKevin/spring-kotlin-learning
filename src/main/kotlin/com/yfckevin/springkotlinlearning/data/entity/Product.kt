package com.yfckevin.springkotlinlearning.data.entity

import com.yfckevin.springkotlinlearning.data.enu.ProductStatus
import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.Id

@Document
data class Product(

    @Id
    val id: String?,

    var name: String,

    var price: Double,

    var count: Int,

    var productStatus: ProductStatus,
)
