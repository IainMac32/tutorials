package A3;
import java.lang.Math;


public class Point extends AbstractShape implements CollisionDetector {
    private float x;
    private float y;
    private static int numberOfInstances;

    public Point()  {
        System.out.println("cannot make point");
    }

    public Point(float x, float y){
        super();
        numberOfInstances ++;
        this.x = x;
        this.y = y;
    }

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }

    public static int getNumOfInstances(){
        return numberOfInstances;
    }

    //add this so when we create points to make other functions easier it doesn't add to the total count of points
    public void decrement(){
        numberOfInstances --;
        super.decrement();
    }

    public boolean intersect(CompShape s){
        return s.intersect(this);
    }

    public boolean intersect(Point s){
        //check if point and point intersect
        if (s.getX() == this.x && s.getY() == this.y){
            return true;
        }
        return false;
    }

    public boolean intersect(LineSeg s){
        //check in point and lineseg intersect
        Point p1 = s.getEnd();
        Point p2 = s.getBegin();

        double y2 = p1.getY();
        double y1 = p2.getY();

        double x2 = p1.getX();
        double x1 = p2.getX();

        double y = this.y;
        double x = this.x;

        //vertical line!
        if (x1 == x2) {
            return x == x1 && (Math.min(y1, y2) <= y && y <= Math.max(y1, y2));
        }

        //get slope of line
        double slope = (y2 - y1) / (x2 - x1);


        //check if the point is on the line
        if ((y - y1) == (slope * (x - x1))){
            //make sure the point is in the bounds of the line points
            return (Math.min(x1, x2) <= x && x <= Math.max(x1, x2)) && (Math.min(y1, y2) <= y && y <= Math.max(y1, y2));
        }
        return false;
    }

    public boolean intersect(Rectangle s){
        //check if point and rectangle intersect

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


        //basically want to make a vector from top left to top right and top left to bottom left
        //we then take a vector from top left to the point
        //we then project the top left to point onto the other two vectors 
        // if both are between 0 and 1 that means the point is in the rectangle
        double TopLeftx = TopLeft.getX();
        double TopLefty = TopLeft.getY();

        double TopRightx = TopRight.getX();
        double TopRighty = TopRight.getY();

        double BottomLeftx = BottomLeft.getX();
        double BottomLefty = BottomLeft.getY();

        double[] TopLeftTopRight = {TopRightx - TopLeftx,TopRighty - TopLefty};
        double[] TopLeftBottomLeft = {BottomLeftx - TopLeftx,BottomLefty - TopLefty};

        double[] TopLeftPoint = {this.x - TopLeftx, this.y - TopLefty};

        double TLPontoTLTR = (TopLeftPoint[0] * TopLeftTopRight[0] + TopLeftPoint[1] * TopLeftTopRight[1]) / (TopLeftTopRight[0] * TopLeftTopRight[0] + TopLeftTopRight[1] * TopLeftTopRight[1]);
        double TLPontoTLBL = (TopLeftPoint[0] * TopLeftBottomLeft[0] + TopLeftPoint[1] * TopLeftBottomLeft[1]) / (TopLeftBottomLeft[0] * TopLeftBottomLeft[0] + TopLeftBottomLeft[1] * TopLeftBottomLeft[1]);

        if ((TLPontoTLBL >= 0 && TLPontoTLBL <= 1) && (TLPontoTLTR >= 0 && TLPontoTLTR <= 1)){
            return true;
        }
        return false;
    }

    public boolean intersect(Circle s){
        //check if point and circle intersect
        Point center = s.getCenter();
        double radius = s.getRadius();
        
        //find distance from point to center
        double distancePointCenter = Math.sqrt(Math.pow(this.x - center.getX(),2) + Math.pow(this.y - center.getY(),2));

        //see if the radius is larger or equal to distance from center to point
        if (distancePointCenter <= radius){
            return true;
        }
        return false;
    }
}