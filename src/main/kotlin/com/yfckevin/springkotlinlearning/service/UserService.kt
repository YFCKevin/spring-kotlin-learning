package com.yfckevin.springkotlinlearning.service

import com.yfckevin.springkotlinlearning.data.dto.UserDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

interface UserService {

    fun addUser(userDto: UserDto): UserDto

    fun queryUserById(id: Long): UserDto

    fun queryUserByFirstName(firstName: String): List<UserDto>

    fun queryUserByLastName(lastName: String, pageable: Pageable): Page<UserDto>

    fun modifyUser(userDto: UserDto): UserDto

    fun modifyUserAgeById(age: Int, id: Long): UserDto

    fun deleteUserById(id: Long)
}