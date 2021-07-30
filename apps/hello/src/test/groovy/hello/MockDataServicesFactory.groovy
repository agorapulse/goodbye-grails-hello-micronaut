package hello

import groovy.transform.CompileStatic
import hello.legacy.VehicleDataService
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import spock.mock.DetachedMockFactory

import javax.inject.Singleton

@Factory
@CompileStatic
class MockDataServicesFactory {

    @Bean
    @Singleton
    VehicleDataService vehicleDataService() {
        return new DetachedMockFactory().Mock(VehicleDataService)
    }

}
