package hello.api

import groovy.transform.CompileStatic
import hello.legacy.model.Vehicle
import hello.legacy.model.VehicleRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Error
import io.micronaut.http.annotation.Get

@CompileStatic
@Controller('/vehicle')
class VehicleController {

    private final VehicleRepository vehicleRepository

    VehicleController(VehicleRepository vehicleDataService) {
        this.vehicleRepository = vehicleDataService
    }

    @Get('/{id}')
    VehicleResponse show(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElse(null)
        if (!vehicle) {
            throw new NoSuchElementException("No vehicle found for id: $id")
        }
        return new VehicleResponse(
                id: vehicle.id,
                name: vehicle.name,
                make: vehicle.make,
                model: vehicle.model
        )
    }

    @Error(exception = NoSuchElementException)
    HttpResponse<?> noSuchElement(NoSuchElementException e) {
        return HttpResponse.notFound()
    }

}
