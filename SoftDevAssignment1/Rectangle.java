package SoftDevAssignment1;

public class Rectangle extends AbstractShape implements CollisionDetector {
    private Point left;
    private Point right;
    private Point top;
    private Point bottom;

    private static int numberOfInstances;

    public Rectangle(){
        super();
        numberOfInstances++;
        this.left = new Point(0, 0);
        this.left.decrement();
        this.right = new Point(1, 1);
        this.right.decrement();
        this.bottom = new Point(1, 0); //bottom left
        this.bottom.decrement();
        this.top = new Point(0, 1); //top right
        this.top.decrement();
    }

    public Rectangle(Point l, Point r, Point t, Point b){
        super();
        numberOfInstances++;
        this.left = l;
        this.right = r;
        this.bottom = b; //bottom left
        this.top = t; //top right
    }

    public Point getLeft(){
        return this.left;
    }

    public Point getRight(){
        return this.right;
    }

    public Point getTop(){
        return this.top;
    }

    public Point getBottom(){
        return this.bottom;
    }

    public static int getNumOfInstances(){
        return numberOfInstances;
    }

    public void decrement(){
        numberOfInstances --;
        super.decrement();
    }

    public boolean intersect(Point s){
        //check if rectangle and point intersect
        return s.intersect(this);
    }


    public boolean intersect(LineSeg s){
        //check in rectangle and lineseg intersect

        //find the the top left,right and bottom left,right
        Point[] points = {this.bottom,this.left,this.right,this.top};

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

        //deconstruct the rectangle into 4 lines
        LineSeg leftLine = new LineSeg(TopLeft,BottomLeft);
        leftLine.decrement();
        LineSeg bottomLine = new LineSeg(BottomLeft,BottomRight);
        bottomLine.decrement();
        LineSeg rightLine = new LineSeg(BottomRight,TopRight);
        rightLine.decrement();
        LineSeg topLine = new LineSeg(TopRight,TopLeft);
        topLine.decrement();

        //get the line we are working with. I know I don't need this but its better for readability
        LineSeg thisLine = new LineSeg(s.getBegin(), s.getEnd());
        thisLine.decrement();

        Rectangle thisRect = new Rectangle(this.right,this.left,this.top,this.bottom);
        thisRect.decrement();

        //first check if the points of the line are in the rectangle
        if (thisLine.getBegin().intersect(thisRect) || thisLine.getEnd().intersect(thisRect)){
            return true;
        }
        
        //check if the lines of rectangle intersect with line
        if (leftLine.intersect(thisLine) || bottomLine.intersect(thisLine) || rightLine.intersect(thisLine) || topLine.intersect(thisLine)){
            return true;
        }
        return false;
    }




    public boolean intersect(Rectangle s){
        //check if rectangle and rectangle intersect

        //find left right top bottom
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

        //deconstruct one of the rectangles
        LineSeg leftLine = new LineSeg(TopLeft,BottomLeft);
        leftLine.decrement();
        LineSeg bottomLine = new LineSeg(BottomLeft,BottomRight);
        bottomLine.decrement();
        LineSeg rightLine = new LineSeg(BottomRight,TopRight);
        rightLine.decrement();
        LineSeg topLine = new LineSeg(TopRight,TopLeft);
        topLine.decrement();

        //get the rectangle we are working with
        Rectangle thisRect = new Rectangle(this.left,this.right,this.top,this.bottom);
        thisRect.decrement();

        //check if any of the lines of one rectangle intersect with the other rectangle
        //this will also check if the rectangle is completely in the other rectangle
        if (thisRect.intersect(leftLine) || thisRect.intersect(bottomLine) || thisRect.intersect(rightLine) || thisRect.intersect(topLine)){
            return true;
        }
        return false;
        // Rectangle(Point l, Point r, Point t, Point b)
    }





    public boolean intersect(Circle s){
        //check if rectangle and circle intersect

        //get the top left and right and bottom left and right
        Point[] points = {this.bottom,this.left,this.right,this.top};

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
            TopLeft = left1;  // Top left
            BottomLeft = left2;  // Bottom left
        } else {
            TopLeft = left2;  // Top-left
            BottomLeft = left1;  // Bottom left
        }

        // Determine top right and bottom right
        if (right1.getY() > right2.getY()) {
            TopRight = right1;  // Top right
            BottomRight = right2;  // Bottom right
        } else {
            TopRight = right2;  // Top right
            BottomRight = right1;  // Bottom right
        }




        //deconstruct rectangle
        LineSeg leftLine = new LineSeg(TopLeft,BottomLeft);
        leftLine.decrement();
        LineSeg bottomLine = new LineSeg(BottomLeft,BottomRight);
        bottomLine.decrement();
        LineSeg rightLine = new LineSeg(BottomRight,TopRight);
        rightLine.decrement();
        LineSeg topLine = new LineSeg(TopRight,TopLeft);
        topLine.decrement();

        //create our rectangle
        Rectangle thisRect = new Rectangle(this.left,this.right,this.top,this.bottom);
        thisRect.decrement();

        Point center = s.getCenter();

        //the circle could be completely in the rectangle so we check if the center is in the rectangle
        if (center.intersect(thisRect)){
            return true;
        }

        // the circle intersects with one of the lines
        if (leftLine.intersect(s) || bottomLine.intersect(s) || rightLine.intersect(s) || topLine.intersect(s)){
            return true;
        }
        return false;
    }

}
