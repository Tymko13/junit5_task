plugins {
    id("java")
//    id("checkstyle")
}

//checkstyle {
//    toolVersion = "8.32"
//    configDirectory = file("$/config")
//}

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