package com.yfckevin.springkotlinlearning.data.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "_order")
data class Order (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @Column
    var userId: Long,

    @Column
    var firstName: String?,

    @Column
    var orderPrice: Int,

    @Column
    var createTime: LocalDateTime
){

}