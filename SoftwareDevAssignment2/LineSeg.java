package SoftwareDevAssignment2;

public class LineSeg extends AbstractShape implements CollisionDetector {
    private Point begin;
    private Point end;

    private static int numberOfInstances;

    //default line segment is just 0,0 to 0,1
    public LineSeg() throws ShapeArgumentException {
        throw new ShapeArgumentException("ShapeArgumentException in constructing LineSeg");
    }

    public LineSeg(Point b, Point e) throws ShapeArgumentException{
        super();
        if (b.equals(e)){
            throw new ShapeArgumentException("ShapeArgumentException in constructing LineSeg");
        }
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
        return s.intersect(this);
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

        //this is to see if they are parralel
        if (abDenominator == 0){
            if (s.intersect(l1p1) || s.intersect(l1p2)){
                return true;
            }
            return false;
        }

        double a = aNumerator / abDenominator;

        double bNumerator = (l1p2x - l1p1x) * (l2p1y - l1p1y) - (l1p2y - l1p1y) * (l2p1x - l1p1x);

        double b = bNumerator / abDenominator;

        //so if the a and b are between 0 and 1 it means the intersection point is on both the 
        //lines meaning there is an intersection
        if ((a >= 0 && a <= 1) && (b >= 0 && b <= 1)){
            return true;
        }
        return false;
    }

    public boolean intersect(Rectangle s){
        //find if they intersect 
        return s.intersect(this);
    }

    public boolean intersect(Circle s){
        //check if LineSeg and circle intersect
        return s.intersect(this);
    }
}