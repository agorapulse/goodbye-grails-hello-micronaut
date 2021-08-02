package hello.api

import groovy.transform.CompileStatic
import hello.legacy.Vehicle
import hello.legacy.VehicleDataService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Error
import io.micronaut.http.annotation.Get

@CompileStatic
@Controller('/vehicle')
class VehicleController {

    private final VehicleDataService vehicleDataService

    VehicleController(VehicleDataService vehicleDataService) {
        this.vehicleDataService = vehicleDataService
    }

    @Get('/{id}')
    VehicleResponse show(Long id) {
        Vehicle vehicle = vehicleDataService.findById(id)
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
