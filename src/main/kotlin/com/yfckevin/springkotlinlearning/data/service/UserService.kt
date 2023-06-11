package com.yfckevin.springkotlinlearning.data.service

import com.yfckevin.springkotlinlearning.data.dto.UserDto

interface UserService {

    fun addUser(userDto: UserDto): UserDto

    fun queryUserById(id: Long): UserDto

    fun modifyUser(userDto: UserDto): UserDto

    fun modifyUserAgeById(age: Int, id: Long): UserDto

    fun deleteUserById(id: Long)
}