package AidenHendo;

public class Vehicle {
    public String name;

    public Vehicle(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void noise(){
        System.out.println("generic noise!");
    }

    public String off(){
        return (name + " is turned off");
    }
}
