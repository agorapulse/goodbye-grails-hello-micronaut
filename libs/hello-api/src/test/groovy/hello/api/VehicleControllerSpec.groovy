package hello.api

import com.agorapulse.dru.Dru
import com.agorapulse.gru.Gru
import hello.HelloDataSets
import io.micronaut.context.ApplicationContext
import io.micronaut.context.ApplicationContextProvider
import io.micronaut.test.annotation.MicronautTest
import spock.lang.AutoCleanup
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class VehicleControllerSpec extends Specification implements ApplicationContextProvider {

    @AutoCleanup
    Dru dru = Dru.create {
        include HelloDataSets.VEHICLES
    }

    @Inject
    Gru gru

    @Inject
    ApplicationContext applicationContext

    void 'render with gru'() {
        given:
            dru.load()

        when:
            gru.test {
                get '/vehicle/1'
                expect {
                    json 'vehicle.json'
                }
            }

        then:
            gru.verify()
    }

}
