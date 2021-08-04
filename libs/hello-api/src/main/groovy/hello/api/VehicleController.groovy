package hello.api

import groovy.transform.CompileStatic
import hello.legacy.model.Vehicle
import hello.legacy.model.VehicleRepository
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@CompileStatic
@Controller('/vehicle')
class VehicleController {

    private final VehicleRepository vehicleRepository

    VehicleController(VehicleRepository vehicleDataService) {
        this.vehicleRepository = vehicleDataService
    }

    @Get('/{id}')
    Optional<VehicleResponse> show(Long id) {
        return vehicleRepository
            .findById(id)
            .map { vehicle -> toResponse(vehicle) }
    }

    private static VehicleResponse toResponse(Vehicle vehicle) {
        return new VehicleResponse(
            id: vehicle.id,
            name: vehicle.name,
            make: vehicle.make,
            model: vehicle.model
        )
    }
}
