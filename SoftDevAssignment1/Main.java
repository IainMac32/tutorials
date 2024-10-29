package SoftDevAssignment1;

public class Main {







    static int testCasesRun = 0;
    static void testCase(CollisionDetector a, Point b, Boolean answer)
    {
      testCasesRun++;
      if (a.intersect(b) == answer)
        return;
      System.out.println("Wrong output for test " + testCasesRun + "\nExpected: " + answer);
    }
    static void testCase(CollisionDetector a, LineSeg b, Boolean answer)
    {
      testCasesRun++;
      if (a.intersect(b) == answer)
        return;
      System.out.println("Wrong output for test " + testCasesRun + "\nExpected: " + answer);
    }
    static void testCase(CollisionDetector a, Rectangle b, Boolean answer)
    {
      testCasesRun++;
      if (a.intersect(b) == answer)
        return;
      System.out.println("Wrong output for test " + testCasesRun + "\nExpected: " + answer);
    }
    static void testCase(CollisionDetector a, Circle b, Boolean answer)
    {
      testCasesRun++;
      if (a.intersect(b) == answer)
        return;
      System.out.println("Wrong output for test " + testCasesRun + "\nExpected: " + answer);
    }
     // Write your own test cases for testing intersections
    static void testCollisions(){
      Rectangle rect1 = new Rectangle(new Point(0,0), new Point(0,3), new Point(3, 3), new Point(3,0));
      Rectangle rect2 = new Rectangle(new Point(1,1), new Point(1,4), new Point(4, 1), new Point(4, 4));
      Rectangle rect3 = new Rectangle(new Point(4,4), new Point(4,5), new Point(5, 4), new Point(5, 5));
      Rectangle rect4 = new Rectangle(new Point(0,3), new Point(0,6), new Point(3, 3), new Point(3, 6));
      Rectangle rect5 = new Rectangle(new Point(3,3), new Point(3,4), new Point(4, 4), new Point(4, 3));
      Rectangle rect6 = new Rectangle(new Point(1,1), new Point(1,2), new Point(2, 1), new Point(2, 2));
      
      //Tests grouped in 5s
      // Point-to-Shape
      //1
      testCase(new Point(0,0), new Point(0,1), false); //points separated by y
      testCase(new Point(0,0), new Point(1,0), false); //points separated by x
      testCase(new Point(0,0), new Point(0,0), true); //point on itself
      testCase(new Point(1, 2), new LineSeg(new Point(0, 0), new Point(3, 3)), false); // point not on line
      testCase(new Point(5, 5), new LineSeg(new Point(0, 0), new Point(3, 3)), false); // point not on line
      //6
      testCase(new Point(1, 1), new LineSeg(new Point(0, 0), new Point(3, 3)), true); // point on line
      testCase(new Point(2, 2), rect1, true); // point in rectangle
      testCase(new Point(4, 4), rect1, false); // point outside rectangle
      testCase(new Point(0, 0), rect1, true); // point on corner of rectangle
      testCase(new Point(1,0), rect1, true); // point on edge of rectangle
      //11
      testCase(new Point(2, 2), new Circle(new Point(1, 1), 2), true); // point in circle
      testCase(new Point(1, 1), new Circle(new Point(1, 1), 2), true); // point in circle at center
      testCase(new Point(1, 3), new Circle(new Point(1, 1), 2), true); // point on the outer edge of the circle
      testCase(new Point(4, 4), new Circle(new Point(1, 1), 2), false); // point outside of the circle
      
      // LineSeg-to-Shape
      testCase(new LineSeg(new Point(0, 0), new Point(3, 3)), new LineSeg(new Point(1, 1), new Point(4, 4)), true); // line intersects line
      //16
      testCase(new LineSeg(new Point(0, 0), new Point(3, 3)), new LineSeg(new Point(4, 4), new Point(5, 5)), false); // parallel line that don't intersect
      testCase(new LineSeg(new Point(0, 0), new Point(3, 3)), new LineSeg(new Point(3, 3), new Point(5, 5)), true); // parallel line that don't intersect but touch at the ends
      testCase(new LineSeg(new Point(0, 0), new Point(3, 3)), new LineSeg(new Point(1, 0), new Point(1, 5)), true); // line just touching on end
      testCase(new LineSeg(new Point(1, 1), new Point(2, 2)), rect1, true); // line entirely in rectangle
      testCase(new LineSeg(new Point(4, 4), new Point(5, 5)), rect1, false); // line entirely outside rectangle
      //21
      testCase(new LineSeg(new Point(0, 0), new Point(5, 5)), rect1, true); // line intersecting rectangle
      testCase(new LineSeg(new Point(0, 3), new Point(5, 3)), rect1, true); // line intersecting rectangle just at top
      testCase(new LineSeg(new Point(1, 1), new Point(2, 2)), new Circle(new Point(1, 1), 2), true); // line entirely in circle
      testCase(new LineSeg(new Point(4, 4), new Point(5, 5)), new Circle(new Point(1, 1), 2), false); // line line entirely outside circle
      testCase(new LineSeg(new Point(0, 0), new Point(5, 5)), new Circle(new Point(1, 1), 2), true); // going all the way through the circle
      //26
      testCase(new LineSeg(new Point(0, 3), new Point(5, 3)), new Circle(new Point(1, 1), 2), true); // just touching the edge of the circle
      testCase(new LineSeg(new Point(1,5), new Point(5,1)), rect1, true); //Line intersecting a rectangle only on the corner at 45 degrees
      
      // Rectangle-to-Shape
      // These are the same as calling from a lineSeg since rectangle just calls intersect from lineSeg
      testCase(rect1, new LineSeg(new Point(1, 1), new Point(4, 4)), true); // rectangle with line entirely in it
      testCase(rect1, new LineSeg(new Point(4, 4), new Point(5, 5)), false); // rectangle with line entirely out of it
      // ----------------------------------------------------------------------------------------------
      testCase(rect1, rect2, true); // rectangle intersecting rectangle
      //31
      testCase(rect1, rect3, false); // rectangle completely outside rectangle
      testCase(rect1, rect4, true); // rectangle just touching side of rectangle
      testCase(rect1, rect5, true); //rectangles just touching on one corner
      testCase(rect1, rect6, true); //rectangle completely surrounding another rectangle
      testCase(rect1, new Circle(new Point(1, 1), 2), true); // circle intersecting rectangle
      //36
      testCase(rect1, new Circle(new Point(4, 4), 1), false); // circle just touching rectangle
      testCase(rect1, new Circle(new Point(5, 5), 1), false); // circle outside rectangle
      // Circle-to-Shape   
      testCase(new Circle(new Point(1, 1), 2), new LineSeg(new Point(1, 1), new Point(4, 4)), true); // circle with a line intersecting
      testCase(new Circle(new Point(1, 1), 2), new LineSeg(new Point(4, 4), new Point(5, 5)), false); // circle with line entirely outside it
      testCase(new Circle(new Point(1, 1), 2), rect1, true); // circle entirely in rectangle
      //41
      testCase(new Circle(new Point(1, 1), 2), rect3, false); // circle with rectangle not intersecting
      testCase(new Circle(new Point(1, 1), 2), new Circle(new Point(2, 2), 1), true); // circle with another circle intersecting
      testCase(new Circle(new Point(1, 1), 2), new Circle(new Point(1, 1), 1), true); // circle exactly on another circle
      testCase(new Circle(new Point(1, 1), 2), new Circle(new Point(0,0), 0.5f), true ); //circle completely surrounding another circle
      testCase(new Circle(new Point(1, 1), 2), new Circle(new Point(4, 4), 1), false); // circle with another circle not intersecting
      //46
      testCase(new Circle(new Point(1, 1), 2), new Circle(new Point(4, 1), 1), true); // circle with another circle just touching
      testCase(rect1, new Circle(new Point(4,4), (float)Math.sqrt(2)), true); //Circle just touching corner of rectangle (warning might cause issues due to float rounding errors)
      testCase(new LineSeg(new Point (4,8), new Point (4,0)), new Circle(new Point(4,4), 2), true); //Vertical line straight through center of circle
      testCase(new LineSeg(new Point (0,4), new Point (8,4)), new Circle(new Point(4,4), 2), true); //Horizontal line straight through center of circle
    }
  
    static void printCounts()
    {
      System.out.println("Points: " + Point.getNumOfInstances());
      System.out.println("Lines: " + LineSeg.getNumOfInstances());
      System.out.println("Circles: " + Circle.getNumOfInstances());
      System.out.println("Rects: " + Rectangle.getNumOfInstances());
      System.out.println("Abstract Shapes: " + AbstractShape.getNumOfInstances());
      System.out.println("Sum of all: " + (Point.getNumOfInstances() + LineSeg.getNumOfInstances() + Circle.getNumOfInstances() + Rectangle.getNumOfInstances()));
    }






















    public static void main(String[] args) {
    // Create two new points
        testCollisions();
        printCounts();
    }
}