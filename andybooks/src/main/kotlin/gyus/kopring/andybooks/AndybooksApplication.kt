package gyus.kopring.andybooks

import gyus.kopring.example.config.ConfigImportExample
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@Import(ConfigImportExample::class)
@SpringBootApplication
class AndybooksApplication

fun main(args: Array<String>) {
	runApplication<AndybooksApplication>(*args)
}
