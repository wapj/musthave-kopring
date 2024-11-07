
package gyus.kopring.example.config

import org.springframework.beans.factory.InitializingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

// ① application.yml의 설정값을 객체로 매핑하는 프로퍼티 클래스
@ConfigurationProperties(prefix = "example.message")
data class MessageProperties(
    var text: String = "Default Message",
    var prefix: String = ">>>"
)

// ② 실제 메시지 출력을 담당하는 컴포넌트
class MessagePrinter(
    private val properties: MessageProperties
) {
    fun printMessage() {
        println("${properties.prefix} ${properties.text}")
    }
}

// ③ 자동 구성을 담당하는 설정 클래스
@Configuration
@EnableConfigurationProperties(MessageProperties::class)
class MessageAutoConfiguration {

    // ④ MessagePrinter 빈이 없을 경우 자동으로 생성
    @Bean
    @ConditionalOnMissingBean
    fun messagePrinter(properties: MessageProperties): MessagePrinter {
        return MessagePrinter(properties)
    }

    // ⑤ 스프링 컨테이너 초기화 완료 시 메시지 출력
    @Bean
    fun initializingBean(messagePrinter: MessagePrinter): InitializingBean {
        return InitializingBean { messagePrinter.printMessage() }
    }
}
