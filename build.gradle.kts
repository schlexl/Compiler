plugins {
    java
    antlr
    idea
}

repositories {
    mavenCentral()
    maven {  setUrl("https://clojars.org/repo") }
}

dependencies {
    testImplementation("junit:junit:4.12")
    antlr("org.antlr:antlr4:4.7.2")
    compile("jasmin:jasmin:2.4")
}

tasks.generateGrammarSource {
    arguments = arguments + listOf("-visitor", "-long-messages")
}

task("printTree", JavaExec::class) {
    main = "org.antlr.v4.runtime.misc.TestRig"

    var param = if(project.hasProperty("fileName")) project.property("fileName").toString() else ""
    param = "D:\\Documents\\GIT\\compiler_construction\\src\\test\\resources\\public\\input\\lexer\\ternary_test.jova";

    args = listOf("at.tugraz.ist.cc.Jova", "program" , param, "-gui")
    classpath = sourceSets["main"].runtimeClasspath
}

tasks.register("jasminAll") {
    doFirst {
        mkdir("build/generated-src/jasmin")
        mkdir("out/jasmin")
    }
    doLast {
        fileTree("build/generated-src/jasmin/*.j").forEach{file: File ->
            run {
                javaexec {
                    main = "Jasmin"
                    args = listOf("-d out/jasmin", file.absolutePath)
                }
            }
        }
    }
}

tasks.register("jasmin"){
    doFirst {
        mkdir("build/generated-src/jasmin")
        mkdir("out/jasmin")
    }
    doLast{
        var file = File(project.property("fileName").toString())

        javaexec {
            main = "Jasmin"
            args = listOf("-d out/jasmin", file.absolutePath)
        }
    }
}



tasks.register<Zip>("packageSrc") {
    archiveFileName.set("framework19.zip")
    destinationDirectory.set(file("$buildDir/dist"))

    from(".") {
        include("src/", "docs/",  "build.gradle.kts", "settings.gradle.kts", "readme.txt", "gradlew", "gradlew.bat", "gradle/wrapper/gradle-wrapper.jar","gradle/wrapper/gradle-wrapper.properties" )
    }
}

idea.module {
    generatedSourceDirs.add(file("build/generated-src/antlr/main"))
}



java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
