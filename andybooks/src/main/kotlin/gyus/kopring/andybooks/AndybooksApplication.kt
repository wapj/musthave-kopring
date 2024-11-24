package gyus.kopring.andybooks

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment

@SpringBootApplication
class AndybooksApplication(val environment: Environment) {

	@Bean
	fun init() = CommandLineRunner {
		val appName = environment.getProperty("info.app.name")
		val appVersion = environment.getProperty("info.app.version")
		val appDescription = environment.getProperty("info.app.description")

		print("앱 이름 : $appName\n")
		print("앱 버전 : $appVersion\n")
		print("앱 설명 : $appDescription")
	}
}

fun main(args: Array<String>) {
	runApplication<AndybooksApplication>(*args)
}