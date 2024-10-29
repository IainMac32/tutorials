package AIDENhendymeister;

public class Main {
    public static void main(String[] args) {
        Lion myLion = new Lion("Jeff");
        Mouse myMouse = new Mouse("Henry");

        myLion.noise();
        myMouse.noise();

        System.out.println(myLion.GetName());
        System.out.println(myMouse.GetName());

        System.out.println(myLion.habitat());
        System.out.println(myMouse.habitat());
    }

}
