plugins {
    `java-library`
    id("maven-publish")  // Enables publishing to Maven
    id("signing")  // Enables artifact signing
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

// Configure publishing to Maven Central
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = "io.yonoma"
            artifactId = "yonoma-java"
            version = "1.0.0"

            pom {
                name.set("Yonoma Java SDK")
                description.set("SDK for Yonoma services.")
                url.set("https://github.com/YonomaHQ/yonoma-java")
                licenses {
                    license {
                        name.set("Apache License 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.html")
                    }
                }
                developers {
                    developer {
                        id.set("YonomaHQ")
                        name.set("Yonoma")
                        email.set("support@yonoma.io")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/YonomaHQ/yonoma-java.git")
                    developerConnection.set("scm:git:ssh://github.com/YonomaHQ/yonoma-java.git")
                    url.set("https://github.com/YonomaHQ/yonoma-java")
                }
            }
        }
    }
}

signing {
    useGpgCmd()
    sign(publishing.publications["mavenJava"])
}
