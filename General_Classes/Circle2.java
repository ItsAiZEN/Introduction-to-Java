package General_Classes;

/**
 * this class creates a circle object using a General_Classes.Maman12.Point object
 *
 * @author Nir Eizenman
 * @version 16/11/2020
 */

public class Circle2 {
    private final int DEFAULT_RADIUS = 1;
    private final int DEFAULT_VAL = 0;
    private double _radius;
    private Point _center;

    /**
     * Constructs a point
     *
     * @param x The x coordinate of the point
     * @param y The y coordinate of the point
     * @param radius The radius of the circle
     */
    public Circle2(int x, int y, double radius) {
        _center = new Point(x, y);
        _radius = radius;
        if (_radius < DEFAULT_VAL)
            _radius = DEFAULT_RADIUS;
    }

    /**
     * Constructs a point
     *
     * @param center General_Classes.Maman12.Point object that is the center of the circle
     * @param radius The radius of the circle
     */
    public Circle2(Point center, double radius) {
        _center = new Point(center);
        _radius = radius;
        if (_radius < DEFAULT_VAL)
            _radius = DEFAULT_RADIUS;
    }

    /**
     * copies a circle
     *
     * @param other The circle we want to copy
     */
    public Circle2(Circle2 other) {
        _center = new Point(other._center);
        _radius = other._radius;
    }
    public Point getCenter(){
        return new Point(_center);
    }
    public double getRadius(){
        return _radius;
    }
    public void setCenter(Point center){
        _center = new Point(center);
    }
    public void setRadius(double radius){
        if (radius>DEFAULT_RADIUS)
            _radius = radius;
    }
} //end of class point
