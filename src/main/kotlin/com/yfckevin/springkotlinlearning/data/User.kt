package com.yfckevin.springkotlinlearning.data

import com.yfckevin.springkotlinlearning.data.dto.UserDto
import com.yfckevin.springkotlinlearning.data.enu.Gender
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "_user")
data class User (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,

        @Column
        var firstName: String,

        @Column
        var lastName: String,

        @Column
        var age: Int,

        @Column
        @Enumerated(EnumType.STRING)
        var gender: Gender,

        @Column
        var createTime: LocalDateTime,

        ){
    fun toDto() = UserDto(
            id = id,
            name = "$firstName, $lastName",
            age = age,
            gender = gender,
            createTime = createTime
    )
}