plugins {
	java
	id("org.springframework.boot") version "3.2.7"
	id("io.spring.dependency-management") version "1.1.5"
}

group = "com.adalbertofjr"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("mysql:mysql-connector-java:8.0.33")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springdoc:springdoc-openapi-starter-common:2.6.0")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
//	implementation("io.springfox:springfox-swagger2:2.5.0")
//	implementation("io.springfox:springfox-swagger-ui:2.5.0")
	implementation("org.springframework.boot:spring-boot-starter-validation:3.3.1")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
