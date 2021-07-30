package hello.legacy

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
