package com.yfckevin.springkotlinlearning.data.controller

import com.yfckevin.springkotlinlearning.data.dto.UserDto
import com.yfckevin.springkotlinlearning.data.service.UserService
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController (
        val userService: UserService
){

    @PostMapping
    fun addUser(@RequestBody userDto: UserDto) = userService.addUser(userDto)

    @GetMapping("/{id}")
    fun queryUserById(@PathVariable id: Long) = userService.queryUserById(id)

    @GetMapping("/{firstName}")
    fun queryUserByFirstName(@PathVariable firstName: String) = userService.queryUserByFirstName(firstName)

    @GetMapping
    fun queryUserByLastName(
        @RequestParam lastName: String,
        @RequestParam page: Int,
        @RequestParam column: String,
        @RequestParam size: Int,
        @RequestParam direction: Sort.Direction,
    ) = userService.queryUserByLastName(lastName, PageRequest.of(page, size, direction, column))

    @PutMapping
    fun modifyUser(@RequestBody userDto: UserDto) = userService.modifyUser(userDto)

    @PatchMapping
    fun modifyUserById(@RequestBody userDto: UserDto) = userService.modifyUserAgeById(userDto.age, userDto.id!!)

    @DeleteMapping("/{id}")
    fun deleteUserById(@PathVariable id: Long) = userService.deleteUserById(id)

}