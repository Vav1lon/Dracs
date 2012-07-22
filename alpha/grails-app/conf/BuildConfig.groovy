grails.servlet.version = "3.0"
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.7
grails.project.source.level = 1.7
grails.tomcat.jvmArgs = ["-Xmx1G", "-XX:MaxPermSize=256m"]

grails.project.dependency.resolution = {

    inherits("global") {
        excludes "grails-plugin-log4j", "log4j", "xercesImpl"
    }
    log "debug" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true

    repositories {
        inherits false
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()
    }

    dependencies {
        compile "org.apache.poi:poi:3.8"
        compile "postgresql:postgresql:9.1-901.jdbc4"

        runtime "ch.qos.logback:logback-classic:1.0.6"
        runtime "org.slf4j:slf4j-api:1.6.6"
        runtime "org.slf4j:jul-to-slf4j:1.6.6"
        runtime "org.slf4j:jcl-over-slf4j:1.6.6"
        runtime "org.slf4j:log4j-over-slf4j:1.6.6"
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.7.1"
        runtime ":resources:1.1.6"
        build ":tomcat:$grailsVersion"
    }
}
