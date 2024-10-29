package AIDENhendymeister;

abstract class Zoo{
    private String name;

    public Zoo(String name){
        this.name = name;
    }

    public String GetName(){
        return name;
    }

    public void noise(){
        System.out.println("Boring Sound");
    }

    abstract String habitat();
}