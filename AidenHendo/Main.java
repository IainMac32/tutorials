package AidenHendo;

public class Main {
    public static void main(String[] args) {
        Motor myMotor = new Motor("John");
        Car myCar = new Car("Carson");



        System.out.println(myCar.off());

        System.out.println(myCar.getName());
        
        System.out.println(myMotor.off());

        System.out.println(myMotor.getName());

        myCar.noise();
        myMotor.noise();

    }
}
