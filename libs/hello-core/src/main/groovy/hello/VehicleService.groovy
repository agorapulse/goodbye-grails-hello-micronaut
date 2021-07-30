package hello

import groovy.transform.CompileStatic
import hello.legacy.VehicleDataService

import javax.inject.Singleton

@Singleton
@CompileStatic
class VehicleService {

    private final VehicleDataService vehicleDataService

    VehicleService(VehicleDataService vehicleDataService) {
        this.vehicleDataService = vehicleDataService
    }

    // methods

}
