package hello

import groovy.transform.CompileStatic
import hello.legacy.model.Vehicle
import hello.legacy.model.VehicleRepository
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.runtime.event.ApplicationStartupEvent

import javax.inject.Singleton

@Singleton
@CompileStatic
class VehicleLoader implements ApplicationEventListener<ApplicationStartupEvent> {

    private final VehicleRepository vehicleRepository

    VehicleLoader(VehicleRepository vehicleDataService) {
        this.vehicleRepository = vehicleDataService
    }

    @Override
    void onApplicationEvent(ApplicationStartupEvent event) {
        Optional<Vehicle> existing = vehicleRepository.findById(1L)
        if (!existing.isPresent()) {
            Vehicle vehicle = new Vehicle(
                    name: 'The Box',
                    make: 'Citroen',
                    model: 'Berlingo'
            )
            vehicleRepository.save(vehicle)
        }
    }
}
