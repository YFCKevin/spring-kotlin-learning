import com.yfckevin.springkotlinlearning.data.dto.UserDto
import com.yfckevin.springkotlinlearning.data.enu.Gender
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import java.time.LocalDateTime


class UserControllerTest {

    private val logger = LoggerFactory.getLogger(javaClass)

    private val webClient = WebClient.builder().build()

    @Test
    internal fun testAddUser(){

        val addUser = webClient.post()
            .uri("http://localhost:8080/api-doc/users")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(UserDto(null, "May, Chen", 19, Gender.MALE, LocalDateTime.now()))
            .retrieve()
            .bodyToMono(UserDto::class.java)
            .block()

        logger.info("{}", addUser)
    }

    @Test
    internal fun testQueryUserById(){
        val queryUserById = webClient.get()
            .uri("http://localhost:8080/api-doc/users/1")
            .retrieve()
            .bodyToMono(UserDto::class.java)
            .block()

        logger.info("{}", queryUserById)
    }


}