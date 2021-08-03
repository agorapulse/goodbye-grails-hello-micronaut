package hello

import com.agorapulse.dru.Dru
import hello.legacy.model.Vehicle
import hello.legacy.model.VehicleRepository
import io.micronaut.context.ApplicationContext
import io.micronaut.context.ApplicationContextProvider
import io.micronaut.test.annotation.MicronautTest
import spock.lang.AutoCleanup
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class HelloDataSetsSpec extends Specification implements ApplicationContextProvider {

    @AutoCleanup Dru dru = Dru.create(this)

    @Inject ApplicationContext applicationContext
    @Inject VehicleRepository vehicleRepository

    void 'vehicles are loaded'() {
        given:
            dru.load(HelloDataSets.VEHICLES)
        when:
            Vehicle box = vehicleRepository.findByName('The Box')
        then:
            box
            box.name == 'The Box'
            box.make == 'Citroen'
            box.model == 'Berlingo'
    }

}
