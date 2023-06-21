package com.yfckevin.springkotlinlearning.dao

import com.yfckevin.springkotlinlearning.data.entity.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserDao: JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    fun findByFirstNameOrderById(firstName: String): List<User>

    fun findUserByLastName(lastName: String, pageable: Pageable): Page<User>

    @Modifying
    @Query("UPDATE User u SET u.age = :age WHERE u.id = :id")
    fun updateUserAgeById(age: Int, id: Long): User
}