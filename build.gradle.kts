plugins {
    java
}

repositories {
    maven("https://maven.aliyun.com/nexus/content/groups/public/")
}

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}
