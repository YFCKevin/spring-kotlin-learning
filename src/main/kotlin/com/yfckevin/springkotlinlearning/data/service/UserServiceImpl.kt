package com.yfckevin.springkotlinlearning.data.service

import com.yfckevin.springkotlinlearning.data.dao.UserDao
import com.yfckevin.springkotlinlearning.data.dto.UserDto
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
        val userDao: UserDao
): UserService{
    override fun addUser(userDto: UserDto) = userDao.save(userDto.toDo()).toDto()

    override fun queryUserById(id: Long) =
            userDao.findById(id)
                    .map { it.toDto() }
                    .orElseThrow { RuntimeException() }

    override fun modifyUser(userDto: UserDto) =
            userDao.findById(userDto.id!!)
                    .orElseThrow { RuntimeException() }
                    .apply {
                        this.firstname = userDto.name.split(",")[0].trim()
                        this.lastname = userDto.name.split(",")[1].trim()
                        this.age = userDto.age
                    }
                    .run {
                        userDao.save(this).toDto()
                    }

    override fun modifyUserAgeById(age: Int, id: Long) =
            userDao.findById(id)
                    .orElseThrow { RuntimeException() }
                    .apply { this.age = age }
                    .run { userDao.save(this).toDto() }

    override fun deleteUserById(id: Long) = userDao.deleteById(id)
}