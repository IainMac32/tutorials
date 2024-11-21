package SoftwareDevAssignment2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertFalse;

class A2Test {
    
    // Points
    @Test // 1
    void testPointIntersectPoint() {
        Point p1_1 = new Point(-4, -4);
        Point p1_2 = new Point(-4, -4);
        Point p1_3 = new Point(1, 1);

        // Test 1: Point intersects point
        assertTrue(p1_1.intersect(p1_2), "Points should intersect");

        // Test 2: Point does not intersect point
        assertFalse(p1_1.intersect(p1_3), "Points should not intersect");
    }
//he said that if we create an object without positions like coordinates than it shoudl trhow an error
    @Test // 2
    void testPointIntersectCircle() {
        try{

            Circle c2_1 = new Circle(new Point(5, 5), 5);
            Point p2_1 = new Point(4, 4);
            Point p2_2 = new Point(5, 0);
            Point p2_3 = new Point(10, 0);

            // Test case 3: Point is in circle
            assertTrue(p2_1.intersect(c2_1));

            // Test case 4: Point is on circle's edge
            assertTrue(p2_2.intersect(c2_1));

            // Test case 5: Point is outside circle
            assertFalse(p2_3.intersect(c2_1));
        } catch (ShapeArgumentException e) {
        fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test // 3
    void testPointIntersectLine() {
        try{
            LineSeg l3_1 = new LineSeg(new Point(0, 0), new Point(5, 0));
            Point p3_1 = new Point(2, 0);
            Point p3_2 = new Point(2, 1);

            // Test case 6: Point is on line
            assertTrue(p3_1.intersect(l3_1));

            // Test case 7: Point is not on line
            assertFalse(p3_2.intersect(l3_1));
        } catch (ShapeArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }

    }

    @Test // 4
    void testPointIntersectRectangle() {
        try{
            Rectangle r4_1 = new Rectangle(
                new Point(0, 0),
                new Point(0, 5),
                new Point(5, 0),
                new Point(5, 5)
            ); //bl, tl, br, tr

            Point p4_1 = new Point(3, 3);
            Point p4_2 = new Point(0, 5);
            Point p4_3 = new Point(-1, 0);

            // Test case 8: Point is in rectangle
            assertTrue(p4_1.intersect(r4_1));

            // Test case 9: Point is on rectangle line
            assertTrue(p4_2.intersect(r4_1));

            // Test case 10: Point is outside rectangle
            assertFalse(p4_3.intersect(r4_1));
            } catch (ShapeArgumentException e) {
                fail("Unexpected exception: " + e.getMessage());
            }
    
    }

    // Lines
    @Test // 5
    void testLineIntersectPoint() {
        try{
        LineSeg l5_1 = new LineSeg(new Point(0, 0), new Point(5, 0));

        Point p5_1 = new Point(2, 0);
        Point p5_2 = new Point(2, 1);

        // Test case 11: Point is on line
        assertTrue(l5_1.intersect(p5_1));

        // Test case 12: Point is not on line
        assertFalse(l5_1.intersect(p5_2));
        } catch (ShapeArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }

    }

    @Test // 6
    void testLineIntersectCircle() {
        try{
            LineSeg l6_1 = new LineSeg(new Point(0, 0), new Point(5, 0));
            Circle c6_1 = new Circle(new Point(2, 3), 5);
            Circle c6_2 = new Circle(new Point(2, 3), 3);
            Circle c6_3 = new Circle(new Point(2, 3), 1);
            Circle c6_4 = new Circle(new Point(2, 3), 30);

            // Test case 13: Line intersects circle
            assertTrue(l6_1.intersect(c6_1));

            // Test case 14: Line and circle edge touching
            assertTrue(l6_1.intersect(c6_2));

            // Test case 15: Line and circle do not intersect
            assertFalse(l6_1.intersect(c6_3));

            // Test case 16: Line is completely in circle
            assertTrue(l6_1.intersect(c6_4));
        } catch (ShapeArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test // 7
    void testLineIntersectLine() {
        try{
            LineSeg l7_1 = new LineSeg(new Point(0, 0), new Point(5, 0));
            LineSeg l7_2 = new LineSeg(new Point(2, 0), new Point(-1, 0));
            LineSeg l7_3 = new LineSeg(new Point(0, -1), new Point(1, 1));
            LineSeg l7_4 = new LineSeg(new Point(5, 5), new Point(0, 5));

            // Test case 17: Line intersects with itself
            assertTrue(l7_1.intersect(l7_1));

            // Test case 18: Line intersects multiple times with another line
            assertTrue(l7_1.intersect(l7_2));

            // Test case 19: Line intersects with other line once
            assertTrue(l7_1.intersect(l7_3));

            // Test case 20: Lines do not intersect
            assertFalse(l7_1.intersect(l7_4));
        } catch (ShapeArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test // 8
    void testLineIntersectRectangle() {
        try{
            Rectangle r8_1 = new Rectangle(
                new Point(0, 0),
                new Point(0, 3),
                new Point(3, 0),
                new Point(3, 3)
            ); //bl, tl, br, tr

            LineSeg l8_1 = new LineSeg(new Point(1, 1), new Point(2, 1));
            LineSeg l8_2 = new LineSeg(new Point(1, 1), new Point(-1, 1));
            LineSeg l8_3 = new LineSeg(new Point(3, 1), new Point(5, 1));
            LineSeg l8_4 = new LineSeg(new Point(-1, 1), new Point(2, -1));
            LineSeg l8_5 = new LineSeg(new Point(-1, 1), new Point(-1, 0));

            // Test case 21: Line is completely in rectangle
            assertTrue(l8_1.intersect(r8_1));

            // Test case 22: Line intersects one of rectangle's lines
            assertTrue(l8_2.intersect(r8_1));

            // Test case 23: Line is on one of rectangle's lines
            assertTrue(l8_3.intersect(r8_1));

            // Test case 24: Line intersects two lines from rectangle
            assertTrue(l8_4.intersect(r8_1));

            // Test case 25: Line is not in rectangle
            assertFalse(l8_5.intersect(r8_1));
        } catch (ShapeArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    // Circles
    @Test // 9
    void testCircleIntersectPoint() {
        try{
            Circle c9_1 = new Circle(new Point(5, 5), 5);

            Point p9_1 = new Point(4, 4);
            Point p9_2 = new Point(5, 0);
            Point p9_3 = new Point(10, 0);

            // Test case 26: Point is in circle
            assertTrue(c9_1.intersect(p9_1));

            // Test case 27: Point is on circle's edge
            assertTrue(c9_1.intersect(p9_2));

            // Test case 28: Point is outside circle
            assertFalse(c9_1.intersect(p9_3));
        } catch (ShapeArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test // 10
    void testCircleIntersectCircle() {
        try{
        
            Circle c10_1 = new Circle(new Point(5, 5), 5);
            Circle c10_2 = new Circle(new Point(5, 5), 3);
            Circle c10_3 = new Circle(new Point(12, 5), 3);
            Circle c10_4 = new Circle(new Point(13, 5), 3);
            Circle c10_5 = new Circle(new Point(15, 5), 3);


            // Test case 29: Circle is completely inside another circle
            assertTrue(c10_1.intersect(c10_2));

            // Test case 30: Circle intersects with another circle
            assertTrue(c10_1.intersect(c10_3));

            // Test case 31: Circles edges touch
            assertTrue(c10_1.intersect(c10_4));

            // Test case 32: Circles do not intersect
            assertFalse(c10_1.intersect(c10_5));
        } catch (ShapeArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test // 11
    void testCircleIntersectLine() {
        try{
            LineSeg l11_1 = new LineSeg(new Point(0, 0), new Point(5, 0));
            Circle c11_1 = new Circle(new Point(2, 3), 5);
            Circle c11_2 = new Circle(new Point(2, 3), 3);
            Circle c11_3 = new Circle(new Point(2, 3), 1);
            Circle c11_4 = new Circle(new Point(2, 3), 30);

            // Test case 33: Line intersects circle
            assertTrue(c11_1.intersect(l11_1));

            // Test case 34: Line and circle edge touching
            assertTrue(c11_2.intersect(l11_1));

            // Test case 35: Line and circle do not intersect
            assertFalse(c11_3.intersect(l11_1));

            // Test case 36: Line is completely in circle
            assertTrue(c11_4.intersect(l11_1));
        } catch (ShapeArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test // 12
    void testCircleIntersectRectangle() {
        try{
            Rectangle r12_1 = new Rectangle( 
                new Point(0, 0),
                new Point(0, 3),
                new Point(3, 0),
                new Point(3, 3)
            ); //bl, tl, br, tr

            Circle c12_1 = new Circle(new Point(1.5f, 1.5f), 1);
            Circle c12_2 = new Circle(new Point(1.5f, 1.5f), 10);
            Circle c12_3 = new Circle(new Point(1, 4), 2);
            Circle c12_4 = new Circle(new Point(1, 4), 1);
            Circle c12_5 = new Circle(new Point(1, 10), 1);

            // Test case 37: Circle is in rectangle
            assertTrue(c12_1.intersect(r12_1));

            // Test case 38: Rectangle is in circle
            assertTrue(c12_2.intersect(r12_1));

            // Test case 39: Circle intersects with rectangle
            assertTrue(c12_3.intersect(r12_1));

            // Test case 40: Circle's and rectangle's edge touch
            assertTrue(c12_4.intersect(r12_1));

            // Test case 41: Circle and rectangle do not intersect
            assertFalse(c12_5.intersect(r12_1));
        } catch (ShapeArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test // 13
    void testRectangleIntersectPoint() {
        try{
            Rectangle r13_1 = new Rectangle(
                new Point(0, 0),
                new Point(0, 5),
                new Point(5, 0),
                new Point(5, 5)
            ); 

            Point p13_1 = new Point(3, 3);
            Point p13_2 = new Point(0, 5);
            Point p13_3 = new Point(-1, 0);

            // Test case 42: Point is in rectangle
            assertTrue(r13_1.intersect(p13_1));

            // Test case 43: Point is on rectangle line
            assertTrue(r13_1.intersect(p13_2));

            // Test case 44: Point is outside rectangle
            assertFalse(r13_1.intersect(p13_3));
        } catch (ShapeArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test // 14
    void testRectangleIntersectCircle() {
        try{
            Rectangle r14_1 = new Rectangle(
                new Point(0, 0),
                new Point(0, 3),
                new Point(3, 0),
                new Point(3, 3)
            );

            Circle c14_1 = new Circle(new Point(1.5f, 1.5f), 1);
            Circle c14_2 = new Circle(new Point(1.5f, 1.5f), 10);
            Circle c14_3 = new Circle(new Point(1, 4), 2);
            Circle c14_4 = new Circle(new Point(1, 4), 1);
            Circle c14_5 = new Circle(new Point(1, 10), 1);

            // Test case 45: Circle is in rectangle
            assertTrue(r14_1.intersect(c14_1));

            // Test case 46: Rectangle is in circle
            assertTrue(r14_1.intersect(c14_2));

            // Test case 47: Circle intersects with rectangle
            assertTrue(r14_1.intersect(c14_3));

            // Test case 48: Circle's and rectangle's edge touch
            assertTrue(r14_1.intersect(c14_4));

            // Test case 49: Circle and rectangle do not intersect
            assertFalse(r14_1.intersect(c14_5));
        } catch (ShapeArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test // 15
    void testRectangleIntersectLine() {
        try{
            Rectangle r15_1 = new Rectangle(
                new Point(0, 0),
                new Point(0, 3),
                new Point(3, 0),
                new Point(3, 3)
            );

            LineSeg l15_1 = new LineSeg(new Point(1, 1), new Point(2, 1));
            LineSeg l15_2 = new LineSeg(new Point(1, 1), new Point(-1, 1));
            LineSeg l15_3 = new LineSeg(new Point(3, 1), new Point(5, 1));
            LineSeg l15_4 = new LineSeg(new Point(-1, 1), new Point(2, -1));
            LineSeg l15_5 = new LineSeg(new Point(-1, 1), new Point(-1, 0));

            // Test case 50: Line is completely in rectangle
            assertTrue(r15_1.intersect(l15_1));

            // Test case 51: Line intersects one of rectangle's lines
            assertTrue(r15_1.intersect(l15_2));

            // Test case 52: Line is on one of rectangle's lines
            assertTrue(r15_1.intersect(l15_3));

            // Test case 53: Line intersects two lines from rectangle
            assertTrue(r15_1.intersect(l15_4));

            // Test case 54: Line is not in rectangle
            assertFalse(r15_1.intersect(l15_5));
        } catch (ShapeArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test // 16
    void testRectangleIntersectRectangle() {
        Rectangle r16_1 = null;
        Rectangle r16_2 = null;
        Rectangle r16_3 = null;
        Rectangle r16_4 = null;
        Rectangle r16_5 = null;
        Rectangle r16_6 = null;


        
        try{
            r16_1 = new Rectangle(
                new Point(0, 0),
                new Point(0, 3),
                new Point(3, 0),
                new Point(3, 3)
            );

            r16_2 = new Rectangle(
                new Point(1, 1),
                new Point(1, 2),
                new Point(2, 1),
                new Point(2, 2)
            );

            r16_3 = new Rectangle(
                new Point(2, 0),
                new Point(2, 1),
                new Point(4, 0),
                new Point(4, 1)
            );

            r16_4 = new Rectangle(
                new Point(0, -3),
                new Point(0, 0),
                new Point(3, -3),
                new Point(3, 0)
            );

            r16_5 = new Rectangle(
                new Point(2, -5),
                new Point(0, -1),
                new Point(6, -3),
                new Point(4, 1)
            );

            r16_6 = new Rectangle(
                new Point(5, 0),
                new Point(5, 5),
                new Point(10, 0),
                new Point(10, 5)
            );
        

            // Test case 55: Rectangle is inside rectangle
            assertTrue(r16_1.intersect(r16_2));

            // Test case 56: Rectangle's corner is inside rectangle
            assertTrue(r16_1.intersect(r16_3));

            // Test case 57: Rectangle touching edge with other rectangle
            assertTrue(r16_1.intersect(r16_4));

            // Test case 58: Rectangle's side intersects two sides of other rectangle (slanted rectangle)
            assertTrue(r16_1.intersect(r16_5));

            // Test case 59: Rectangle does not intersect with other rectangle
            assertFalse(r16_1.intersect(r16_6));
        } catch (ShapeArgumentException e) {
            fail("Unexpected exception 6: " + e.getMessage());
        }
    }

}
