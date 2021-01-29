dependencies {

  // spring modules
  implementation("org.springframework.boot:spring-boot-starter")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-security")
  implementation("org.springframework.security:spring-security-jwt:1.0.10.RELEASE")
  implementation("org.springframework.security.oauth:spring-security-oauth2:2.3.6.RELEASE")
  implementation("org.springframework.boot:spring-boot-starter-log4j2")
  implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter")

  // db
  runtimeOnly("mysql:mysql-connector-java")

  // lombok
  compileOnly("org.projectlombok:lombok")
  annotationProcessor("org.projectlombok:lombok")
  testCompileOnly("org.projectlombok:lombok")
  testAnnotationProcessor("org.projectlombok:lombok")

}
