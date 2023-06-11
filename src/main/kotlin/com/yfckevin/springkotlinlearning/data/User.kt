package com.yfckevin.springkotlinlearning.data

import com.yfckevin.springkotlinlearning.data.dto.UserDto
import javax.persistence.*

@Entity
@Table(name = "member")
data class User (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,

        @Column
        var firstname: String,

        @Column
        var lastname: String,

        @Column
        var age: Int,

        ){
    fun toDto() = UserDto(
            id = id,
            name = "$firstname, $lastname",
            age = age,
    )
}