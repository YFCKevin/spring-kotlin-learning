package com.yfckevin.springkotlinlearning.data.dto

import com.yfckevin.springkotlinlearning.data.entity.User
import com.yfckevin.springkotlinlearning.data.enu.Gender
import java.io.Serializable
import java.time.LocalDateTime

data class UserDto (

        val id: Long?,

        val name: String,

        val age: Int,

        val gender: Gender,

        val createTime: LocalDateTime
) : Serializable {
    fun toDo() = User(
            id = id,
            firstName = name.split(",")[0].trim(),
            lastName = name.split(",")[1].trim(),
            age = age,
            createTime = createTime,
            gender = gender
    )

}
