package SoftDevAssignment1;
import java.lang.Math;

public class LineSeg extends AbstractShape implements CollisionDetector {
    private Point begin;
    private Point end;

    private static int numberOfInstances;

    public LineSeg(){
        super();
        numberOfInstances ++;
        this.begin = new Point(0, 0);
        this.begin.decrement();
        this.end = new Point (0, 1);
        this.end.decrement();
    }

    public LineSeg(Point b, Point e){
        super();
        numberOfInstances ++;
        this.begin = b;
        this.end = e;
    }

    public Point getBegin(){
        return this.begin;
    }

    public Point getEnd(){
        return this.end;
    }

    public static int getNumOfInstances(){
        return numberOfInstances;
    }

    public void decrement(){
        numberOfInstances --;
        super.decrement();
    }

    public boolean intersect(Point s){
        //check if LineSeg and point intersect
        Point p1 = this.end;
        Point p2 = this.begin;

        double y2 = p1.getY();
        double y1 = p2.getY();

        double x2 = p1.getX();
        double x1 = p2.getX();

        double y = s.getY();
        double x = s.getX();

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

    public boolean intersect(LineSeg s){
        //check in LineSeg and lineseg intersect
        Point l1p1 = this.begin;
        double l1p1x = l1p1.getX();
        double l1p1y = l1p1.getY();

        Point l1p2 = this.end;
        double l1p2x = l1p2.getX();
        double l1p2y = l1p2.getY();

        Point l2p1 = s.getBegin();
        double l2p1x = l2p1.getX();
        double l2p1y = l2p1.getY();

        Point l2p2 = s.getEnd();
        double l2p2x = l2p2.getX();
        double l2p2y = l2p2.getY();

        // double[] l1V = {l1p1x - l1p2x, l1p1y - l1p2y};
        // double[] l2V = {l2p1x - l2p2x, l2p1y - l2p2y};

        //any point on line 1 can be represented as 
        //l1p1 + (a * l1V) where a in [0,1]
        //same for line 2
        //l2p1 + (b * l2V where b in [0,1])

        double aNumerator = (l2p2x - l2p1x) * (l2p1y - l1p1y) - (l2p2y - l2p1y) * (l2p1x - l1p1x);
        double abDenominator = (l2p2x - l2p1x) * (l1p2y - l1p1y) - (l2p2y - l2p1y) * (l1p2x - l1p1x);

        //if collinear and one of the points is on the other line its true
        //else they are just collinear but not touching
        if (abDenominator == 0 && aNumerator == 0){
            if (s.intersect(l1p1) || s.intersect(l1p2)){
                return true;
            }
            return false;
        }

        if (abDenominator == 0){
            if (s.intersect(l1p1) || s.intersect(l1p2)){
                return true;
            }
            return false;
        }

        double a = aNumerator / abDenominator;

        double bNumerator = (l1p2x - l1p1x) * (l2p1y - l1p1y) - (l1p2y - l1p1y) * (l2p1x - l1p1x);

        double b = bNumerator / abDenominator;

        if ((a >= 0 && a <= 1) && (b >= 0 && b <= 1)){
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


        //check if LineSeg and rectangle intersect
        LineSeg leftLine = new LineSeg(TopLeft,BottomLeft);
        leftLine.decrement();
        LineSeg bottomLine = new LineSeg(BottomLeft,BottomRight);
        bottomLine.decrement();
        LineSeg rightLine = new LineSeg(BottomRight,TopRight);
        rightLine.decrement();
        LineSeg topLine = new LineSeg(TopRight,TopLeft);
        topLine.decrement();

        LineSeg thisLine = new LineSeg(this.begin, this.end);
        thisLine.decrement();

        //first check if the points of the line are in the rectangle
        if (thisLine.getBegin().intersect(s) || thisLine.getEnd().intersect(s)){
            return true;
        }
        
        //check if the lines of rectangle intersect with line
        if (leftLine.intersect(thisLine) || bottomLine.intersect(thisLine) || rightLine.intersect(thisLine) || topLine.intersect(thisLine)){
            return true;
        }
        return false;
    }

    public boolean intersect(Circle s){
        //check if LineSeg and circle intersect
        Point center = s.getCenter();
        double cx = center.getX();
        double cy = center.getY();

        Point p1 = this.begin;
        Point p2 = this.end;

        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();

        double[] lineV = {x2 - x1, y2 - y1};
        double[] p1centerV = {cx - x1, cy - y1};

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

        double PCdistance = Math.sqrt(Math.pow(px - cx,2) + Math.pow(py - cy,2));

        //for if a float gets cut off 
        //0.0000001 is 1e-7
        if (PCdistance - s.getRadius() < 1e-7){
            return true;
        }
        return false;
    }
}