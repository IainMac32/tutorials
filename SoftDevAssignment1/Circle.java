package SoftDevAssignment1;

public class Circle extends AbstractShape implements CollisionDetector {
    private Point center;
    private float radius;
    private static int numberOfInstances;

    //circle default to 0,0
    public Circle (){
        super();
        numberOfInstances ++;
        this.center = new Point(0,0); //is this right?
        this.center.decrement();
        this.radius = 1;
    }

    public Circle(Point center, float radius){
        super();
        numberOfInstances++;
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter(){
        return this.center;
    }

    public float getRadius(){
        return this.radius;
    }

    public static int getNumOfInstances(){
        return numberOfInstances;
    }

    //we need this decrement since we make circles to allow recalling methods
    public void decrement(){
        numberOfInstances --;
        super.decrement();
    }

    public boolean intersect(Point s){
        //check if circle and point intersect
        return s.intersect(this);
    }

    public boolean intersect(LineSeg s){
        //check in circle and lineseg intersect
        Point center = this.center;
        double cx = center.getX();
        double cy = center.getY();

        Point p1 = s.getBegin();
        Point p2 = s.getEnd();

        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();

        double[] lineV = {x2 - x1, y2 - y1};
        double[] p1centerV = {cx - x1, cy - y1};

        //trying to find the closest point on the line to the circle
        double p1centerOntoLine = (lineV[0] * p1centerV[0] + lineV[1] * p1centerV[1]) / (lineV[0] * lineV[0] + lineV[1] * lineV[1]);
        //if < 0 p1 is closest
        //if > 1 p2 is closest
        //if in between the closest point is somewhere between the line end points

        double px;
        double py;
        if (p1centerOntoLine < 0){
            px = x1;
            py = y1;
        } else if (p1centerOntoLine > 1){
            px = x2;
            py = y2;
        }else{
            px = x1 + p1centerOntoLine * (x2 - x1);
            py = y1 + p1centerOntoLine * (y2 - y1);
        }

        //find distance between closest point on line and circle center
        double PCdistance = Math.sqrt(Math.pow(px - cx,2) + Math.pow(py - cy,2));

        //for if a float gets cut off 
        //0.0000001 is 1e-7
        if (PCdistance - this.radius < 1e-7){
            return true;
        }
        return false;
    }

    public boolean intersect(Rectangle s){
        //find if they intersect
        return s.intersect(this);
    }



    public boolean intersect(Circle s){
        //check if circle and circle intersect
        Point center1 = this.center;
        Point center2 = s.getCenter();

        double radius1 = this.radius;
        double radius2 = s.getRadius();

        //get distance between centers
        double distanceCircle12 = Math.sqrt(Math.pow(center1.getX() - center2.getX(),2) + Math.pow(center1.getY() - center2.getY(),2));

        //if the radius added up are greater than distance they intersect
        if (distanceCircle12 <= (radius1 + radius2)){
            return true;
        }
        return false;        
    }


}
