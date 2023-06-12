package com.yfckevin.springkotlinlearning.data

import com.yfckevin.springkotlinlearning.data.dto.UserDto
import com.yfckevin.springkotlinlearning.data.enu.Gender
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "member")
data class User (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,

        @Column
        var firstname: String,

        @Column
        var lastname: String,

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
            name = "$firstname, $lastname",
            age = age,
            gender = gender,
            createTime = createTime
    )
}