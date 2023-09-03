import com.bmuschko.gradle.tomcat.embedded.TomcatUser

plugins {
    id("java")
    id("org.flywaydb.flyway") version "9.21.2"
    id("war")
    id("com.bmuschko.tomcat") version "2.7.0"
}
group = "by.test"
version = "1.0-SNAPSHOT"
repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    compileOnly("org.projectlombok:lombok:1.18.28")
    annotationProcessor ("org.projectlombok:lombok:1.18.28")
    testCompileOnly ("org.projectlombok:lombok:1.18.28")
    testAnnotationProcessor ("org.projectlombok:lombok:1.18.28")
    implementation("org.postgresql:postgresql:42.6.0")
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")
    tomcat ("org.apache.tomcat.embed:tomcat-embed-core:9.0.73")
    tomcat ("org.apache.tomcat.embed:tomcat-embed-logging-juli:9.0.0.M6")
    tomcat ("org.apache.tomcat.embed:tomcat-embed-jasper:9.0.73")
    implementation("com.zaxxer:HikariCP:5.0.1")
    implementation("org.apache.pdfbox:pdfbox:3.0.0")
}
tomcat {
    httpProtocol = "org.apache.coyote.http11.Http11Nio2Protocol"
    ajpProtocol  = "org.apache.coyote.http11.Http11Nio2Protocol"
    httpPort = 8090
    httpsPort = 8091
    ajpPort = 8092
    contextPath = "sample-app"
    users.add(TomcatUser("user1", "123456", arrayListOf("developers", "admin")))
    users.add(TomcatUser("user2", "abcdef", arrayListOf("manager")))
    daemon = false
}

tasks.test {
    useJUnitPlatform()
}


tasks.flywayMigrate{runTask()}
tasks.flywayInfo{runTask()}

