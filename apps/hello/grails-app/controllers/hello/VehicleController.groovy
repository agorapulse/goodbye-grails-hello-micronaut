package hello

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.transform.CompileStatic
import hello.legacy.Vehicle
import hello.legacy.VehicleDataService

import javax.inject.Inject

@CompileStatic
class VehicleController {

    @Inject ObjectMapper objectMapper
    @Inject VehicleService vehicleService
    @Inject VehicleDataService vehicleDataService

    Object show(Long id) {
        Vehicle vehicle = vehicleDataService.findById(id)
        if (!vehicle) {
            throw new NoSuchElementException("No vehicle found for id: $id")
        }
        render contentType: 'application/json', text: objectMapper.writeValueAsString(
                new VehicleResponse(
                        id: vehicle.id,
                        name: vehicle.name,
                        make: vehicle.make,
                        model: vehicle.model
                )
        )
    }

    Object noSuchElement(NoSuchElementException e) {
        render status: 404
    }

}
