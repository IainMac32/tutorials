package AIDENhendymeister;

public class Lion extends Zoo{

    public Lion(String name){
        super(name);
    }

    @Override
    public void noise(){
        System.out.println("Rawrr");
    }

    public String habitat(){
        return "Ground";
    }
}
