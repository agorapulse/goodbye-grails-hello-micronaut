package hello

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.transform.CompileStatic
import hello.legacy.Vehicle
import hello.legacy.VehicleDataService

import javax.inject.Inject

@CompileStatic
class VehicleController {

    @Inject ObjectMapper objectMapper

    VehicleDataService vehicleDataService

    Object show(Long id) {
        Vehicle vehicle = vehicleDataService.findById(id)
        if (!vehicle) {
            render status: 404
            return
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

}
