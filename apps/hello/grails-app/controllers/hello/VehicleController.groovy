package hello

import grails.converters.JSON
import groovy.transform.CompileStatic

@CompileStatic
class VehicleController {

    VehicleDataService vehicleDataService

    Object show(Long id) {
        Vehicle vehicle = vehicleDataService.findById(id)
        if (!vehicle) {
            render status: 404
            return
        }
        render vehicle as JSON
    }

}
