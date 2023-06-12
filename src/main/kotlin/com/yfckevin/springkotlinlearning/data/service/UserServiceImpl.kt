package com.yfckevin.springkotlinlearning.data.service

import com.yfckevin.springkotlinlearning.data.dao.UserDao
import com.yfckevin.springkotlinlearning.data.dto.UserDto
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
        val userDao: UserDao
): UserService{
    override fun addUser(userDto: UserDto) = userDao.save(userDto.toDo()).toDto()

    override fun queryUserById(id: Long) =
            userDao.findById(id)
                    .map { it.toDto() }
                    .orElseThrow { RuntimeException() }

    override fun queryUserByFirstName(firstName: String) =
        userDao.findByFirstNameOrderById(firstName)
            .map { it.toDto() }

    override fun queryUserByLastName(lastName: String, pageable: Pageable) =
        userDao.findByLastName(lastName, pageable)
            .map { it.toDto() }

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

    @Transactional
    override fun modifyUserAgeById(age: Int, id: Long) =
            userDao.updateUserAgeById(age, id).toDto()

    override fun deleteUserById(id: Long) = userDao.deleteById(id)
}