package hello.api

import com.agorapulse.dru.Dru
import com.agorapulse.gru.Gru
import hello.HelloDataSets
import hello.legacy.Vehicle
import hello.legacy.VehicleDataService
import io.micronaut.test.annotation.MicronautTest
import spock.lang.AutoCleanup
import spock.lang.Specification
import spock.mock.AutoAttach

import javax.inject.Inject

@MicronautTest
class VehicleControllerSpec extends Specification {

    @AutoCleanup
    Dru dru = Dru.create {
        include HelloDataSets.VEHICLES
    }

    @Inject
    Gru gru

    @Inject
    @AutoAttach
    VehicleDataService vehicleDataService

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

            1 * vehicleDataService.findById(1) >> dru.findByType(Vehicle).tap { id = 1 }
    }

}
