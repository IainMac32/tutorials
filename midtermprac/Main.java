package midtermprac;


//All classes are in the same file so you don't need public infront of it
class Dog{
    //cannot be accessed 
    private String name;

    public Dog(String name){
        this.name = name;
    }


    public Dog(){
        this.name = "Default";
    }
}



public class Main {
    public static void main(String[] args){
        //new is the keyword that is instatiating it
        // Dog dog = new Dog("jerry");
        // Dog Defaultdog = new Dog();

        // System.out.println(Defaultdog.name);

        Animal snake = new Snake();

        snake.sleep();
        snake.talk();

    }
}


class Snake extends Zoo{
    public Snake(){
        super();
        System.out.println("hiss");
    }

    public void sleep(){
        System.out.println("ZzzzZzzzzZ");
    }

    public void talk(){
        System.out.println("hiss");
    }

}