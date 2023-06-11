package com.yfckevin.springkotlinlearning.data.dto

import com.yfckevin.springkotlinlearning.data.User

data class UserDto (

        val id: Long?,

        val name: String,

        val age: Int,
){
    fun toDo() = User(
            id = id,
            firstname = name.split(",")[0].trim(),
            lastname = name.split(",")[1].trim(),
            age = age
    )

}
