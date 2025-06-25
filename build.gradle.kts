plugins {
    id("java")
    id("checkstyle")
}

checkstyle {
    toolVersion = "10.3"
    configDirectory = file("${rootDir}/config/checkstyle")
}

group = "com"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform() {
        excludeTags("Long")
    }
}