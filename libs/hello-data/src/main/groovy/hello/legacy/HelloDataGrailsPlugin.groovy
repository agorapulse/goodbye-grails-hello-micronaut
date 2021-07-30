package hello.legacy

import groovy.transform.CompileStatic;

@CompileStatic
class HelloDataGrailsPlugin {

    String grailsVersion = '3.3.0 > *'

    String title = 'GORM Hello Data'
    String author = 'Vladimir Orany'
    String authorEmail = 'vlad@agorapulse.com'
    String description = 'Mimicking Grails Plugin'

}