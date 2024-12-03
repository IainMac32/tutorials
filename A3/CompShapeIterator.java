package A3;

public class CompShapeIterator {
    private CompShape compShape;
    private int index;
    //we need this index for the first and next 

    public CompShapeIterator(CompShape shape){
        this.compShape = shape;
        this.index = 0;
    }

    public void first() {
        index = 0; // reset
    }

    public void next() {
        if (isDone() == false) {
            index++; // move to next ind
        }
    }

    public boolean isDone() {
        return index >= compShape.size();
    }

    public AbstractShape getCurrentShape() {
        if (isDone() == false) {
            return compShape.get(index);
            //get current
        }
        return null;
    }


}
