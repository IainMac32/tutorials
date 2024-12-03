package A3;

public interface CollisionDetector{
    boolean intersect(Point s);
    boolean intersect(LineSeg s);
    boolean intersect(Rectangle s);
    boolean intersect(Circle s);
    boolean intersect(CompShape s);

}