plugins {
    id("java")
    id("org.flywaydb.flyway") version "9.21.2"
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
    implementation("org.postgresql:postgresql:42.6.0")
}
tasks.test {
    useJUnitPlatform()
}
tasks.flywayMigrate{runTask()}
tasks.flywayInfo{runTask()}

