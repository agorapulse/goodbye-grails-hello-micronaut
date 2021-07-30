package hello.legacy

import grails.gorm.services.Service
import groovy.transform.CompileStatic

@Service(Vehicle)
@CompileStatic
interface VehicleDataService {

    Vehicle findById(Long id)

}
