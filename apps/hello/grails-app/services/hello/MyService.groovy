package hello

import groovy.transform.CompileStatic

import javax.inject.Inject

@CompileStatic
class MyService {

    @Inject AgorapulseConfiguration configuration

    String returnFoo() {
        return configuration.foo
    }

    String returnBar() {
        return configuration.bar
    }

}
