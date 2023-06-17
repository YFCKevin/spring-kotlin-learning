package com.yfckevin.springkotlinlearning.data.dto

import com.yfckevin.springkotlinlearning.data.User
import com.yfckevin.springkotlinlearning.data.enu.Gender
import java.time.LocalDateTime

data class UserDto (

        val id: Long?,

        val name: String,

        val age: Int,

        val gender: Gender,

        val createTime: LocalDateTime
){
    fun toDo() = User(
            id = id,
            firstName = name.split(",")[0].trim(),
            lastName = name.split(",")[1].trim(),
            age = age,
            createTime = createTime,
            gender = gender
    )

}
