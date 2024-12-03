package A3;

import java.util.ArrayList;

public class CompShape extends AbstractShape implements CollisionDetector {
    private ArrayList<AbstractShape> compShape;
    //list of shapes ^

    public CompShape() {
        super(); 
        this.compShape = new ArrayList<>(); // create list
    }

    public void addShape(AbstractShape s) {
        if (s instanceof CompShape) {
            // cast to CompShape
            CompShape compShapeToAdd = (CompShape) s;
                        
            // add each shape from compShape
            for (int i = 0; i < compShapeToAdd.size(); i++) {
                this.compShape.add(compShapeToAdd.get(i));
            }
        } else {
            // if single shape just add it
            this.compShape.add(s);
        }
    }
        
    public void removeShape(AbstractShape s) {
        if (s instanceof CompShape) {
            // cast to CompShape
            CompShape compShapeToRemove = (CompShape) s;
                        
            // remove each shape from compShape
            for (int i = 0; i < compShapeToRemove.size(); i++) {
                this.compShape.remove(compShapeToRemove.get(i));
            }
        } else {
            // if single shape just remove it
            this.compShape.remove(s);
        }
    }

    public int size() {
        return this.compShape.size();
    }

    public AbstractShape get(int i) {
        return this.compShape.get(i);
    }


    public boolean intersect(Point s){
        for (int i = 0; i < this.compShape.size(); i++) {
            if (this.compShape.get(i) instanceof Point) {
                // object is a Point
                Point CompPoint = (Point) this.compShape.get(i); // cast to Point
                if (s.intersect(CompPoint)){
                    return true;
                }
            }
            else if (this.compShape.get(i) instanceof LineSeg) {
                // object is a Line
                LineSeg CompLine = (LineSeg) this.compShape.get(i); // cast to Line
                if(s.intersect(CompLine)){
                    return true;
                }
            }
            else if (this.compShape.get(i) instanceof Circle) {
                // object is a Circle
                Circle CompCircle = (Circle) this.compShape.get(i); // cast to Circle
                if (s.intersect(CompCircle)){
                    return true;
                }
            }
            else if (this.compShape.get(i) instanceof Rectangle) {
                // object is a Rect
                Rectangle CompRectangle = (Rectangle) this.compShape.get(i); // cast to Rect
                if (s.intersect(CompRectangle)){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean intersect(LineSeg s){
        for (int i = 0; i < this.compShape.size(); i++) {
            if (this.compShape.get(i) instanceof Point) {
                // object is a Point
                Point CompPoint = (Point) this.compShape.get(i); // cast to Point
                if (s.intersect(CompPoint)){
                    return true;
                }
            }
            else if (this.compShape.get(i) instanceof LineSeg) {
                // object is a Line
                LineSeg CompLine = (LineSeg) this.compShape.get(i); // cast to Line
                if(s.intersect(CompLine)){
                    return true;
                }
            }
            else if (this.compShape.get(i) instanceof Circle) {
                // object is a Circle
                Circle CompCircle = (Circle) this.compShape.get(i); // cast to Circle
                if (s.intersect(CompCircle)){
                    return true;
                }
            }
            else if (this.compShape.get(i) instanceof Rectangle) {
                // object is a Rect
                Rectangle CompRectangle = (Rectangle) this.compShape.get(i); // cast to Rect
                if (s.intersect(CompRectangle)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean intersect(Circle s){
        for (int i = 0; i < this.compShape.size(); i++) {
            if (this.compShape.get(i) instanceof Point) {
                // object is a Point
                Point CompPoint = (Point) this.compShape.get(i); // cast to Point
                if (s.intersect(CompPoint)){
                    return true;
                }
            }
            else if (this.compShape.get(i) instanceof LineSeg) {
                // object is a Line
                LineSeg CompLine = (LineSeg) this.compShape.get(i); // cast to Line
                if(s.intersect(CompLine)){
                    return true;
                }
            }
            else if (this.compShape.get(i) instanceof Circle) {
                // object is a Circle
                Circle CompCircle = (Circle) this.compShape.get(i); // cast to Circle
                if (s.intersect(CompCircle)){
                    return true;
                }
            }
            else if (this.compShape.get(i) instanceof Rectangle) {
                // object is a Rect
                Rectangle CompRectangle = (Rectangle) this.compShape.get(i); // cast to Rect
                if (s.intersect(CompRectangle)){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean intersect(Rectangle s){
        for (int i = 0; i < this.compShape.size(); i++) {
            if (this.compShape.get(i) instanceof Point) {
                // object is a Point
                Point CompPoint = (Point) this.compShape.get(i); // cast to Point
                if (s.intersect(CompPoint)){
                    return true;
                }
            }
            else if (this.compShape.get(i) instanceof LineSeg) {
                // object is a Line
                LineSeg CompLine = (LineSeg) this.compShape.get(i); // cast to Line
                if(s.intersect(CompLine)){
                    return true;
                }
            }
            else if (this.compShape.get(i) instanceof Circle) {
                // object is a Circle
                Circle CompCircle = (Circle) this.compShape.get(i); // cast to Circle
                if (s.intersect(CompCircle)){
                    return true;
                }
            }
            else if (this.compShape.get(i) instanceof Rectangle) {
                // object is a Rect
                Rectangle CompRectangle = (Rectangle) this.compShape.get(i); // cast to Rect
                if (s.intersect(CompRectangle)){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean intersect(CompShape s){
        for (int i = 0; i < this.compShape.size(); i++) {
            if (this.compShape.get(i) instanceof Point) {
                // object is a Point
                Point CompPoint = (Point) this.compShape.get(i); // cast to Point
                if (s.intersect(CompPoint)){
                    return true;
                }
            }
            else if (this.compShape.get(i) instanceof LineSeg) {
                // object is a Line
                LineSeg CompLine = (LineSeg) this.compShape.get(i); // cast to Line
                if(s.intersect(CompLine)){
                    return true;
                }
            }
            else if (this.compShape.get(i) instanceof Circle) {
                // object is a Circle
                Circle CompCircle = (Circle) this.compShape.get(i); // cast to Circle
                if (s.intersect(CompCircle)){
                    return true;
                }
            }
            else if (this.compShape.get(i) instanceof Rectangle) {
                // object is a Rect
                Rectangle CompRectangle = (Rectangle) this.compShape.get(i); // cast to Rect
                if (s.intersect(CompRectangle)){
                    return true;
                }
            }
        }
        return false;
    }



}