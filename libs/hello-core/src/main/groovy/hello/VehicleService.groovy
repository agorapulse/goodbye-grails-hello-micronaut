package hello

import groovy.transform.CompileStatic
import hello.legacy.model.VehicleRepository
import javax.inject.Singleton

@Singleton
@CompileStatic
class VehicleService {

    private final VehicleRepository vehicleRepository

    VehicleService(VehicleRepository vehicleDataService) {
        this.vehicleRepository = vehicleDataService
    }

    // methods

}
