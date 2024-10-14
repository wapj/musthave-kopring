plugins {
    kotlin("jvm") version "2.0.20" // ① 코틀린 JVM 컴파일러 플러그인
    kotlin("plugin.spring") version "2.0.20"  // ② 코틀린의 스프링 지원 플러그인
    id("org.springframework.boot") version "3.2.5" // ③ 스프링 부트 플러그인
    id("io.spring.dependency-management") version "1.1.4" // ④ 스프링 의존성 관리 플러그인
}

group = "gyus.spring.kotlin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
}
