package gyus.kopring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class HelloSpringbootApplication {
    @RequestMapping("/")
    fun home():String {
        return "안녕 스프링 부트"
    }
}

fun main(args: Array<String>) {
    runApplication<HelloSpringbootApplication>(*args)
}