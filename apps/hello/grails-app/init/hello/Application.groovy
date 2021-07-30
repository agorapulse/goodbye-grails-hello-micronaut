package hello

import com.agorapulse.micronaut.grails.MicronautGrailsApp
import com.agorapulse.micronaut.grails.MicronautGrailsAutoConfiguration

import groovy.transform.CompileStatic
import hello.legacy.Vehicle

@CompileStatic
class Application extends MicronautGrailsAutoConfiguration {

    final Collection<Package> packages = [
            Vehicle.package,
    ]

    static void main(String[] args) {
        MicronautGrailsApp.run(Application, args)
    }

}