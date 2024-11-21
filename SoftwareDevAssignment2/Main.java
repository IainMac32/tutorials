package SoftwareDevAssignment2;

public class Main {
  public static void main(String[] args) {
    try{
    //I will create 10 test cases that will cover all the classes since I just recall
    //some methods inside other methods so there is 10 unique ones.



      // Create two new points
      Point p1_l1 = new Point();
      Point p2_l1 = new Point(4,4);

      // Create a line segment using the two points
      LineSeg l1 = new LineSeg(p1_l1, p2_l1);

      // Create four new points (corners of the rectangle)
      Point p1_r1 = new Point(-4,-4);
      Point p2_r1 = new Point(-4,4);
      Point p3_r1 = new Point(4,-4);
      Point p4_r1 = new Point(4,4);

      // Create a new rectangle using the four points
      Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

      // Check the intersection status between the line segment l1and the rectangle r1 
      // And store the value (true/false) in the variable status
      boolean status_r1_intersects_l1 = l1.intersect(r1); // line rectangle 1/10
      System.out.println(status_r1_intersects_l1);


      Point p1 = new Point(4,4);
      boolean status_l1_intersects_p1 = l1.intersect(p1); // line point 2/10
      System.out.println(status_l1_intersects_p1);


      Point center1 = new Point(1,0);
      Circle c1 = new Circle(center1,4);
      boolean status_l1_intersects_c1 = l1.intersect(c1); // line circle 3/10
      System.out.println(status_l1_intersects_c1);


      Point p1_l2 = new Point(0,4);
      Point p2_l2 = new Point(4,0);
      LineSeg l2 = new LineSeg(p1_l2,p2_l2);
      boolean status_l1_intersects_l2 = l1.intersect(l2); // line line 4/10
      System.out.println(status_l1_intersects_l2);


      Point center2 = new Point(5,5);
      Circle c2 = new Circle(center2, 4);
      boolean status_c2_intersects_r1 = c2.intersect(r1); // circle rect 5/10
      System.out.println(status_c2_intersects_r1);


      Point p2 = new Point(6,6);
      boolean status_c2_intersects_p2 = c2.intersect(p2); // circle point 6/10
      System.out.println(status_c2_intersects_p2);


      boolean status_c2_intersects_c1 = c2.intersect(c1); // circle circle 7/10
      System.out.println(status_c2_intersects_c1);


      Point p3 = new Point(6,6);
      boolean status_p2_intersects_p3 = p2.intersect(p3); // point point 8/10
      System.out.println(status_p2_intersects_p3);


      Point p4 = new Point(0,0);
      boolean status_p4_intersects_r1 = p4.intersect(r1); // point rect 9/10
      System.out.println(status_p4_intersects_r1);

      Point p1_r2 = new Point(0,0);
      Point p2_r2 = new Point(5,0);
      Point p3_r2 = new Point(5,6);
      Point p4_r2 = new Point(0,6);
      Rectangle r2 = new Rectangle(p1_r2,p2_r2,p3_r2,p4_r2);
      boolean status_r2_intersects_r1 = r2.intersect(r1); // rect rect 10/10
      System.out.println(status_r2_intersects_r1);
    } catch (ShapeArgumentException e) {
        System.out.println("Error: " + e.getMessage());
      } 
  }
}