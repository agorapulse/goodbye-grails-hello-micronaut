package hello.legacy.model

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    Vehicle findByName(String name)

}