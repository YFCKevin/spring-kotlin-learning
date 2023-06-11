package com.yfckevin.springkotlinlearning.data

import com.yfckevin.springkotlinlearning.data.dto.UserDto
import javax.persistence.*

@Entity
@Table
data class User (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,

        var firstname: String,

        var lastname: String,

        var age: Int,

        ){
    fun toDto() = UserDto(
            id = id,
            name = "$firstname, $lastname",
            age = age,
    )
}