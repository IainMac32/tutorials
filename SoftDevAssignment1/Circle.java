package SoftDevAssignment1;

public class Circle extends AbstractShape implements CollisionDetector {
    private Point center;
    private float radius;
    private static int numberOfInstances;

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

    public void decrement(){
        numberOfInstances --;
        super.decrement();
    }

    public boolean intersect(Point s){
        //check if circle and point intersect
        Point center = this.center;
        double radius = this.radius;
        
        double distancePointCenter = Math.sqrt(Math.pow(s.getX() - center.getX(),2) + Math.pow(s.getY() - center.getY(),2));

        if (distancePointCenter <= radius){
            return true;
        }
        return false;
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

        double p1centerOntoLine = (lineV[0] * p1centerV[0] + lineV[1] * p1centerV[1]) / (lineV[0] * lineV[0] + lineV[0] * lineV[0]);
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

        double PCdistance = Math.sqrt(Math.pow(px - cx,2) + Math.pow(py - cy,2));

        //for if a float gets cut off 
        //0.0000001 is 1e-7
        if (PCdistance - this.radius < 1e-7){
            return true;
        }
        return false;
    }

    public boolean intersect(Rectangle s){

        //find the top left bottom left top right bottom right
        Point[] points = {s.getBottom(),s.getLeft(),s.getRight(),s.getTop()};

        Point left1 = points[0];
        Point left2 = null;
        Point right1 = points[0];
        Point right2 = null;

        // Loop to find the two leftmost and two rightmost points
        for (int i = 1; i < points.length; i++) {
            Point p = points[i];

            // Find two leftmost points
            if (p.getX() < left1.getX()) {
                left2 = left1;
                left1 = p;
            } else if (left2 == null || p.getX() < left2.getX()) {
                left2 = p;
            }

            // Find two rightmost points
            if (p.getX() > right1.getX()) {
                right2 = right1;
                right1 = p;
            } else if (right2 == null || p.getX() > right2.getX()) {
                right2 = p;
            }
        }

        Point TopLeft;
        Point TopRight;
        Point BottomLeft;
        Point BottomRight;

        if (left1.getY() > left2.getY()) {
            TopLeft = left1;  // Top-left
            BottomLeft = left2;  // Bottom-left
        } else {
            TopLeft = left2;  // Top-left
            BottomLeft = left1;  // Bottom-left
        }

        // Determine top-right and bottom-right
        if (right1.getY() > right2.getY()) {
            TopRight = right1;  // Top-right
            BottomRight = right2;  // Bottom-right
        } else {
            TopRight = right2;  // Top-right
            BottomRight = right1;  // Bottom-right
        }


        //check if circle and rectangle intersect
        LineSeg leftLine = new LineSeg(TopLeft,BottomLeft);
        leftLine.decrement();
        LineSeg bottomLine = new LineSeg(BottomLeft,BottomRight);
        bottomLine.decrement();
        LineSeg rightLine = new LineSeg(BottomRight,TopRight);
        rightLine.decrement();
        LineSeg topLine = new LineSeg(TopRight,TopLeft);
        topLine.decrement();

        Rectangle thisRect = new Rectangle(s.getLeft(),s.getRight(),s.getTop(),s.getBottom());
        thisRect.decrement();

        Point center = this.center;
        Circle thisCircle = new Circle(this.center,this.radius);
        thisCircle.decrement();

        //the circle could be completely in the rectangle so we check if the center is in the rectangle
        if (center.intersect(thisRect)){
            return true;
        }

        // the circle intersects with one of the lines
        if (leftLine.intersect(thisCircle) || bottomLine.intersect(thisCircle) || rightLine.intersect(thisCircle) || topLine.intersect(thisCircle)){
            return true;
        }
        return false;
    }



    public boolean intersect(Circle s){
        //check if circle and circle intersect
        Point center1 = this.center;
        Point center2 = s.getCenter();

        double radius1 = this.radius;
        double radius2 = s.getRadius();

        double distanceCircle12 = Math.sqrt(Math.pow(center1.getX() - center2.getX(),2) + Math.pow(center1.getY() - center2.getY(),2));

        if (distanceCircle12 <= (radius1 + radius2)){
            return true;
        }
        return false;        
    }


}
