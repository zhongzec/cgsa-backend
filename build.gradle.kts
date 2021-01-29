plugins {
  `java-library`
  `maven-publish`
  id("org.springframework.boot").version("2.2.2.RELEASE").apply(false)
  id("io.spring.dependency-management").version("1.0.8.RELEASE")
}

val sourcesJar by tasks.creating(Jar::class) {
  group = JavaBasePlugin.DOCUMENTATION_GROUP
  from(sourceSets["main"].allSource)
  archiveClassifier.set("sources")
}

val javadocJar by tasks.creating(Jar::class) {
  group = JavaBasePlugin.DOCUMENTATION_GROUP
  from(tasks["javadoc"])
  archiveClassifier.set("javadoc")
}

publishing {
  publications {
    create<MavenPublication>("default") {
      from(components["java"])
      artifact(sourcesJar)
      artifact(javadocJar)
    }
  }
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<Test> {
  useJUnitPlatform()
}

tasks.getByName<Jar>("jar") {
  enabled = true
}

subprojects {

  apply {
    plugin("java-library")
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
  }

  group = "edu.usc"
  version = "0.0.1"

  repositories {
    mavenLocal()
    mavenCentral()
  }

  // common configuration: exclude logging module from spring framework
  configurations {
    compile.get().exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
  }

  dependencies {

    // common spring modules
    implementation("org.springframework.boot:spring-boot-starter-log4j2")
    implementation("io.springfox:springfox-swagger2:2.7.0")
    implementation("io.springfox:springfox-swagger-ui:2.7.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
      exclude(module = "junit")
      exclude(module = "mockito-core")
    }

    // common junit test lib
    testImplementation(kotlin("test-junit5")) // need jupiter engine
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.2")
  }

  dependencyManagement {
    dependencies {
      // lombok
      dependency("org.projectlombok:lombok:1.18.12")

      // db driver
      dependency("mysql:mysql-connector-java:8.0.16")

      // spring-mybatis
      dependency("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.2")

    }
  }

}
