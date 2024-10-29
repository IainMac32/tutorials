package AidenHendo;

public class Car extends Vehicle{
    public Car(String name){
        super(name);
    }

    @Override
    public void noise(){
        System.out.println("Honk!");
    }



}
