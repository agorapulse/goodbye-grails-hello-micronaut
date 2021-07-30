package hello

import com.agorapulse.dru.Dru
import grails.testing.gorm.DataTest
import hello.legacy.Vehicle
import spock.lang.AutoCleanup
import spock.lang.Specification

class HelloDataSetsSpec extends Specification implements DataTest {

    @AutoCleanup Dru dru = Dru.create(this)

    void 'vehicles are loaded'() {
        given:
            dru.load(HelloDataSets.VEHICLES)
        when:
            Vehicle box = Vehicle.findByName('The Box')
        then:
            box
            box.name == 'The Box'
            box.make == 'Citroen'
            box.model == 'Berlingo'
    }

}
