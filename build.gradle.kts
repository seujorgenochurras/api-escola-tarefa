plugins {
    id("java")
    id ("org.springframework.boot") version ("3.1.2")
    id ("io.spring.dependency-management") version("1.1.2")
}
repositories {
    mavenCentral()
}
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    //implementation ("org.springframework.boot:spring-boot-starter-security")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    runtimeOnly ("com.mysql:mysql-connector-j")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    //testImplementation ("org.springframework.security:spring-security-test")
implementation ("org.springframework.boot:spring-boot-starter-validation:3.1.2")
implementation ("org.modelmapper:modelmapper:3.1.1")
}
tasks.test {
    useJUnitPlatform()
}
