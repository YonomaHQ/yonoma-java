plugins {
    `java-library`
    id("maven-publish")  // Enables publishing to Maven
    id("signing")  // Enables signing for secure deployment
}

group = "io.yonoma"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.test {
    useJUnitPlatform()
}

// Configure publishing like Resend SDK
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = "io.yonoma"
            artifactId = "yonoma-java"
            version = "1.0.0"
        }
    }
}
