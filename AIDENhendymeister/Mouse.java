package AIDENhendymeister;

public class Mouse extends Zoo{
    
    public Mouse(String name){
        super(name);
    }

    @Override
    public void noise(){
        System.out.println("Peep");
    }

    public String habitat(){
        return "House";
    }

}
