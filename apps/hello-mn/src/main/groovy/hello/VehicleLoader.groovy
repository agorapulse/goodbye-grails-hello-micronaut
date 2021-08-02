package hello

import groovy.transform.CompileStatic
import hello.legacy.Vehicle
import hello.legacy.VehicleDataService
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.runtime.event.ApplicationStartupEvent

import javax.inject.Singleton

@Singleton
@CompileStatic
class VehicleLoader implements ApplicationEventListener<ApplicationStartupEvent> {

    private final VehicleDataService vehicleDataService

    VehicleLoader(VehicleDataService vehicleDataService) {
        this.vehicleDataService = vehicleDataService
    }

    @Override
    void onApplicationEvent(ApplicationStartupEvent event) {
        if (vehicleDataService.findById(1) == null) {
            Vehicle vehicle = new Vehicle(
                    name: 'The Box',
                    make: 'Citroen',
                    model: 'Berlingo'
            )
            vehicleDataService.save(vehicle)
        }
    }
}
