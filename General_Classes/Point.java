package General_Classes;

/**
 * this class creates a point object and methods such as set, get,
 * distance and so forth..
 *
 * @author Nir Eizenman
 * @version 16/11/2020
 */
public class Point {
    private final int DEFAULT_VAL = 0;
    private int _x;
    private int _y;

    /**
     * Constructs a point
     * If one of the parameters is negative then is should be
     * initialized to zero.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public Point(int x, int y) {
        if (x < DEFAULT_VAL)
            _x = DEFAULT_VAL;
        else
            _x = x;
        if (y < DEFAULT_VAL)
            _y = DEFAULT_VAL;
        else
            _y = y;
    }

    /**
     * Copy constructor for General_Classes.Maman12.Point
     * Construct a point with the same coordinates as other point
     *
     * @param other The point object from which to construct the new point
     */
    public Point(Point other) {
        if (other != null) { //checks if the object is initialized
            // (important to check if the input of correct
            _x = other._x;
            _y = other._y;
        }
    }

    /**
     * Returns the x coordinate of the point
     *
     * @return The x coordinate of the point
     */
    public int getX() {
        return _x;
    }

    /**
     * Sets the x coordinate of the point
     * if a negative number is received then the x coordinate does
     * not change.
     *
     * @param x The new x coordinate
     */
    public void setX(int x) {
        if (x >= DEFAULT_VAL)
            _x = DEFAULT_VAL;
    }

    /**
     * Returns the y coordinate of the point
     *
     * @return The y coordinate of the point
     */
    public int getY() {
        return _y;
    }

    /**
     * Sets the y coordinate of the point
     * if a negative number is received then the y coordinate does
     * not change.
     *
     * @param y The new x coordinate
     */
    public void setY(int y) {
        if (y >= DEFAULT_VAL)
            _y = DEFAULT_VAL;
    }

    /**
     * Returns a string representation of this point
     *
     * @return String representation of this point
     */
    public String toString() {
        return "(" + _x + "," + _y + ")";
    }

    /**
     * Check if this point equals other point
     *
     * @param other The point to be compared with this point
     * @return ture if this point equals other point
     */
    public boolean equals(Point other) {
        return (other._x == _x && other._y == _y);
    }

    /**
     * Check if this point is to the above of other point
     *
     * @param other The point to check if this point is above of
     * @return ture if this point is to the above of other point
     */
    public boolean isAbove(Point other) {
        return other._y < _y;
    }

    /**
     * Check if this point is to the under of other point
     *
     * @param other The point to check if this point is under of
     * @return ture if this point is to the under of other point
     */
    public boolean isUnder(Point other) {
        return other.isAbove(this);
    }

    /**
     * Check if this point is to the left of other point
     *
     * @param other The point to check if this point is left of
     * @return ture if this point is to the left of other point
     */
    public boolean isLeft(Point other) {
        return _x < other._x;
    }

    /**
     * Check if this point is to the right of other point
     *
     * @param other The point to check if this point is right of
     * @return ture if this point is to the right of other point
     */
    public boolean isRight(Point other) {
        return other.isLeft(this);
    }

    /**
     * Calculate the distance between this point and other point
     *
     * @param p The point to calculate the distance from
     * @return The distance between this and p points
     */
    public double distance(Point p) {
        return Math.sqrt(Math.pow((_x - p._x), 2) + Math.pow((_y - p._y), 2));
    }

    /**
     * Moves the x coordinate by dX and the y coordinate by dY.
     * if the movement moves the point outside first quadrant then the
     * point will remain at the same place and not move.
     *
     * @param dX The amount to move in the x direction
     * @param dY The amount to move in the y direction
     */
    public void move(int dX, int dY) {
        if ((_x += dX) >= DEFAULT_VAL && (_y + dY) >= DEFAULT_VAL) {
            _x += dX;
            _y += dY;
        }
    }
} //end of class point
