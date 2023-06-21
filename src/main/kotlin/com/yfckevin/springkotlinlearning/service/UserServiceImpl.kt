package com.yfckevin.springkotlinlearning.service

import com.yfckevin.springkotlinlearning.dao.OrderDao
import com.yfckevin.springkotlinlearning.dao.UserDao
import com.yfckevin.springkotlinlearning.data.dto.UserDto
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    val userDao: UserDao,
    val orderDao: OrderDao
): UserService {

    @CachePut(cacheNames = ["UserService"], key = "#result.id")
    override fun addUser(userDto: UserDto) = userDao.save(userDto.toDo()).toDto()

    @Cacheable(cacheNames = ["UserService"], key = "#id")
    override fun queryUserById(id: Long): UserDto =
            userDao.findById(id)
                    .map { it.toDto() }
                    .orElseThrow { RuntimeException() }

    @Cacheable(cacheNames = ["UserService"], key = "#firstName")
    override fun queryUserByFirstName(firstName: String) =
        userDao.findByFirstNameOrderById(firstName)
            .map { it.toDto() }

    @Cacheable(cacheNames = ["UserService"], key = "#lastName")
    override fun queryUserByLastName(lastName: String, pageable: Pageable) =
        userDao.findUserByLastName(lastName, pageable)
            .map { it.toDto() }

    @CachePut(cacheNames = ["UserService"], key = "#result.id")
    override fun modifyUser(userDto: UserDto) =
            userDao.findById(userDto.id!!)
                    .orElseThrow { RuntimeException() }
                    .apply {
                        this.firstName = userDto.name.split(",")[0].trim()
                        this.lastName = userDto.name.split(",")[1].trim()
                        this.age = userDto.age
                    }
                    .run {
                        userDao.save(this).toDto()
                    }

    @CachePut(cacheNames = ["UserService"], key = "#result.id")
    @Transactional
    override fun modifyUserAgeById(age: Int, id: Long) =
            userDao.updateUserAgeById(age, id).toDto()

    @CacheEvict(cacheNames = ["UserService"], key = "#result.id")
    override fun deleteUserById(id: Long) = userDao.deleteById(id)
}