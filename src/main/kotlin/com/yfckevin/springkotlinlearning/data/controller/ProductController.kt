package com.yfckevin.springkotlinlearning.data.controller

import com.yfckevin.springkotlinlearning.data.dao.ProductDao
import com.yfckevin.springkotlinlearning.data.entity.Product
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController (
    val productDao: ProductDao
){
    @PostMapping
    fun addProduct(@RequestBody product: Product) = productDao.save(product)

    @GetMapping("/{id}")
    fun queryProductById(@PathVariable id: String) = productDao.findById(id).orElseThrow{ RuntimeException() }

    @PutMapping("/{id}")
    fun modifyProductById(@RequestBody product: Product) =
        productDao.findById(product.id!!).orElseThrow { RuntimeException() }
            .run {
                this.name = product.name
                this.price = product.price
                this.count = product.count
                this.productStatus = product.productStatus

                productDao.save(this)
            }


    @DeleteMapping("/{id}")
    fun deleteProductById(@PathVariable id: String) = productDao.deleteById(id)
}