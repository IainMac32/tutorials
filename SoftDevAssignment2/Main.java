package SoftDevAssignment2;

import A3.AbstractShape;
import A3.Circle;
import A3.CompShape;
import A3.CompShapeIterator;
import A3.Drawing;
import A3.LineSeg;
import A3.Point;
import A3.Rectangle;

public class Main {
  public static void main(String[] args) {
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

      CompShape comp1 = new CompShape();
      comp1.addShape(p1_r2); //0,0
      comp1.addShape(p2_r2);
      comp1.addShape(new Circle(new Point(100,100),5));

      System.out.println("this is comp shapes:");
      System.out.println(new Point(0,0).intersect(comp1));
      System.out.println(new Point(5,0).intersect(comp1));
      System.out.println(new Point(100,105).intersect(comp1));
      System.out.println(comp1.intersect(new Point(100,105)));
      System.out.println(new Point(100,106).intersect(comp1));









      LineSeg l = new LineSeg(new Point(2,2), new Point(1,1));
      Circle c = new Circle(new Point(7.1f, 0.4f), 3.3f);
      Rectangle r = new Rectangle(new Point(0,0),new Point(0,1),new Point(1,0),new Point(1,1));
      CompShape s = new CompShape();
      s.addShape(l);
      s.addShape(c);
      s.addShape(r);
      CompShape s2 = new CompShape();
      s.removeShape(r);
      s2.addShape(r);
      s2.addShape(s);
      //intersect
      System.out.println("first");
      System.out.println(s2.intersect(l));

      System.out.println("second");
      System.out.println(s2.intersect(c));

      System.out.println("third");
      System.out.println(s2.intersect(r));

      System.out.println("forth");
      System.out.println(s2.intersect(s));

      //access components
      CompShapeIterator it = new CompShapeIterator(s2);
      it.first();
      while(it.isDone())
      {
        AbstractShape shape = it.getCurrentShape();
        System.out.println(shape);
        it.next();
      }
      //singleton Drawing
      Drawing dwg = Drawing.getInstance();
      dwg.setShape(s2);
      AbstractShape ds = dwg.getShape();


  }
}