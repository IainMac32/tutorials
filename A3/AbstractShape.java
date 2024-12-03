package A3;

public abstract class AbstractShape {
    private static int numberOfInstances = 0;

    public static int getNumOfInstances(){
        return numberOfInstances;
    }

    //constructor has to increase num of instances
    public AbstractShape(){
        numberOfInstances ++;
    }

    //we need this to decrement when we make a shape in a method to allow reusing methods
    public void decrement(){
        numberOfInstances --;
    }
}