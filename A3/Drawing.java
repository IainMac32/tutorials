package A3;

public class Drawing {
    private static Drawing instance;
    //must be static so same instance is accessible across all code
    private AbstractShape shape;

    private Drawing() {
        this.shape = null;
    }

    //must be static so same instance is accessible across all code
    public static Drawing getInstance() {
        if (instance == null) {
            instance = new Drawing();
        }
        return instance;
    }

    public AbstractShape getShape() {
        return shape;
    }

    public void setShape(AbstractShape s) {
        this.shape = s;
    }
}
