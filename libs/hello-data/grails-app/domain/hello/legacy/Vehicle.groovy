package hello.legacy

import grails.gorm.annotation.Entity

@Entity
class Vehicle {

    String name

    String make
    String model

    static Closure constraints = {
        name maxSize: 255
        make inList: ['Ford', 'Chevrolet', 'Nissan', 'Citroen']
        model nullable: true
    }

}
