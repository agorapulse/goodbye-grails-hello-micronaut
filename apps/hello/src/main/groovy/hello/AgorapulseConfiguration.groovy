package hello

import groovy.transform.CompileStatic
import io.micronaut.context.annotation.ConfigurationProperties

@CompileStatic
@ConfigurationProperties('agorapulse')
class AgorapulseConfiguration {

    String foo
    String bar

}