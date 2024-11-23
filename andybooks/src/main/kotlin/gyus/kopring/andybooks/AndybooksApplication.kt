package gyus.kopring.andybooks

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class AndybooksApplication: CommandLineRunner {
	@Value("\${info.app.name}")
	lateinit var appName: String

	@Value("\${info.app.version}")
	lateinit var appVersion: String

	@Value("\${info.app.description}")
	lateinit var appDescription: String

	override fun run(vararg args: String?) {
		println("이름 : $appName")
		println("버전 : $appVersion")
		println("설명 : $appDescription")
	}

	// 빈 등록을 사용하는 예제. CommandLineRunner 인터페이스 구현과 동일한 동작
	@Bean
	fun printAppInfo() = CommandLineRunner {
		println("[빈등록] 이름 : $appName")
		println("[빈등록] 버전 : $appVersion")
		println("[빈등록] 설명 : $appDescription")
	}
}

fun main(args: Array<String>) {
	runApplication<AndybooksApplication>(*args)
}