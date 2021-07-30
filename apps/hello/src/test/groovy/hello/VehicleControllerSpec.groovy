package hello

import com.agorapulse.dru.Dru
import com.agorapulse.gru.Gru
import com.agorapulse.gru.grails.Grails
import com.fasterxml.jackson.databind.ObjectMapper
import grails.testing.gorm.DataTest
import grails.testing.spring.AutowiredTest
import grails.testing.web.controllers.ControllerUnitTest
import hello.legacy.Vehicle
import hello.legacy.VehicleDataService
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.AutoCleanup
import spock.lang.Specification
import spock.mock.AutoAttach


class VehicleControllerSpec extends Specification implements ControllerUnitTest<VehicleController>, DataTest, AutowiredTest{

    @AutoCleanup Dru dru = Dru.create {
        include HelloDataSets.VEHICLES
    }

    @AutoCleanup Gru gru = Gru.create(Grails.create(this)).prepare {
        include UrlMappings
    }

    @Autowired @AutoAttach VehicleDataService vehicleDataService

    @Override
    Closure doWithSpring() {
        return {
            objectMapper(ObjectMapper)
        }
    }

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

            1 * vehicleDataService.findById(1) >> dru.findByType(Vehicle)
    }

}