package SoftDevAssignment1;

public abstract class AbstractShape {
    private static int numberOfInstances = 0;

    public static int getNumOfInstances(){
        return numberOfInstances;
    }

    //constructor has to increase num of instances
    public AbstractShape(){
        numberOfInstances ++;
    }

    public void decrement(){
        numberOfInstances --;
    }
}
