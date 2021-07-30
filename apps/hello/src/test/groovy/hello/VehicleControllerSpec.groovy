package hello

import com.agorapulse.dru.Dru
import com.agorapulse.gru.Gru
import com.agorapulse.gru.grails.Grails
import com.fasterxml.jackson.databind.ObjectMapper
import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import hello.legacy.Vehicle
import hello.legacy.VehicleDataService
import spock.lang.AutoCleanup
import spock.lang.Specification

class VehicleControllerSpec extends Specification implements ControllerUnitTest<VehicleController>, DataTest {

    @AutoCleanup Dru dru = Dru.create {
        include HelloDataSets.VEHICLES
    }

    @AutoCleanup Gru gru = Gru.create(Grails.create(this)).prepare {
        include UrlMappings
    }

    @Override
    Closure doWithSpring() {
        return {
            objectMapper(ObjectMapper)
        }
    }

    void 'render with gru'() {
        given:
            dru.load()

            controller.vehicleDataService = Mock(VehicleDataService) {
                findById(1) >> dru.findByType(Vehicle)
            }

        expect:
            gru.test {
                get '/vehicle/1'
                expect {
                    json 'vehicle.json'
                }
            }
    }

}
