package hello

import groovy.transform.CompileStatic
import hello.legacy.Vehicle
import io.micronaut.runtime.Micronaut

@CompileStatic
class Application {

    static void main(String[] args) {
        Micronaut.build(args)
                 .mainClass(Application)
                 .packages(Vehicle.package.name)
                 .start()
    }

}