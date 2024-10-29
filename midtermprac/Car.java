package midtermprac;


class Vehicle {
    //can only be accessed by subclasses because of protected
    protected String brand = "ford";

    public void honk(){
        System.out.println("toot toot");
    }

    public void transport(){

    }

    public Vehicle(){

    }

}

//car has everything in vehicle and whats in itself
//this is inheritance
public class Car extends Vehicle{

    public static void Main(String[] args){
        Car car = new Car();
    }

    private String modelName = "mustang";

    //this is a constructor
    public Car(){
        super();
        System.out.println("I am a car");
    }
}




class Motorcycle extends Vehicle {
    private String modelName = "Bike";
    private int numberOfWheels = 2;

    //Constructor
    public Motorcycle(){

    }
}