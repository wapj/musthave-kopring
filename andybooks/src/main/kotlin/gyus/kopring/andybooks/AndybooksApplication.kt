package gyus.kopring.andybooks

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@Profile("!prod")
@RestController
class Hello() {
	@RequestMapping("/")
	fun home():String {
		return "스프링 부트 재밌죠? "
	}
}

@Profile("prod")
@RestController
class ProdHello() {
	@RequestMapping("/")
	fun home():String {
		return "운영환경입니다."
	}
}


@SpringBootApplication
class AndybooksApplication(val environment: Environment) {

	@Bean
	fun init() = CommandLineRunner {
		val appName = environment.getProperty("info.app.name")
		val appVersion = environment.getProperty("info.app.version")
		val appDescription = environment.getProperty("info.app.description")

		print("앱 이름 : $appName\n")
		print("앱 버전 : $appVersion\n")
		print("앱 설명 : $appDescription\n")
		print("현재 활성화 된 프로파일 : ${environment.activeProfiles.joinToString()}\n")
	}
}

fun main(args: Array<String>) {
	runApplication<AndybooksApplication>(*args)
}