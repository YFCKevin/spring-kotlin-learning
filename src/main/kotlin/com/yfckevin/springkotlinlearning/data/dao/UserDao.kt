package com.yfckevin.springkotlinlearning.data.dao

import com.yfckevin.springkotlinlearning.data.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface UserDao: JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}