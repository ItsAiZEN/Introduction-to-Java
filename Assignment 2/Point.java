/**
 * Represents two-dimensional points.
 *
 * @author Nir Eizenman
 * @version 18/11/2020
 */
public class Point {
    private final int DEFAULT_VAL = 0;
    private final double RAD_DEGREE_CONV = (180 / Math.PI);
    private double _radius;
    private double _alpha;

    /**
     * Constructs a point with a specified x, y coordinates
     * If one of a parameter is negative then is will be set to zero
     *
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public Point(double x, double y) {
        if (x < DEFAULT_VAL) {
            x = DEFAULT_VAL;
            _alpha = 90;
        }
        if (y < DEFAULT_VAL)
            y = DEFAULT_VAL;
        if ((x == DEFAULT_VAL) && (y == DEFAULT_VAL))
            _alpha = 90;
        _radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        if (_alpha != 90)
            _alpha = (Math.atan(y / x)) * RAD_DEGREE_CONV;
    }

    /**
     * Copy constructor using an other Point object
     * Construct a point with the same coordinates as other point
     *
     * @param other The point object from which to construct the new point
     */
    public Point(Point other) {
        _radius = other._radius;
        _alpha = other._alpha;
    }
//

    /**
     * Returns the x coordinate of the point
     *
     * @return The x coordinate of the point
     */
    public double getX() {
        return Math.cos(_alpha / RAD_DEGREE_CONV) * _radius;
    }
    //

    /**
     * Sets the x coordinate of the point
     * if a negative number is received then the x coordinate doesn't change.
     *
     * @param num The new x coordinate
     */
    public void setX(double num) {
        if (num >= DEFAULT_VAL) {
            double rad = Math.sqrt(Math.pow(num, 2) + Math.pow(this.getY(), 2)); //temporary value holder, makes sure to not impact the calculations
            double alp = Math.atan(this.getY() / num) * RAD_DEGREE_CONV; //temporary value holder, makes sure to not impact the calculations
            _radius = rad;
            _alpha = alp;
        }
    }

    /**
     * Returns the y coordinate of the point
     *
     * @return The y coordinate of the point
     */
    public double getY() {
        return Math.sin(_alpha / RAD_DEGREE_CONV) * _radius;
    }

    /**
     * Sets the y coordinate of the point
     * if a negative number is received then the y coordinate doesn't change.
     *
     * @param num The new y coordinate
     */
    public void setY(double num) {
        if (num >= DEFAULT_VAL) {
            double rad = Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(num, 2)); //temporary value holder, makes sure to not impact the calculations
            double alp = Math.atan(num / this.getX()) * RAD_DEGREE_CONV; //temporary value holder, makes sure to not impact the calculations
            _radius = rad;
            _alpha = alp;
        }
    }

    /**
     * Returns a string representation of this point formatted as: (X,Y)
     *
     * @return String representation of this point
     */
    public String toString() {
        return "(" + (Math.round(this.getX() * 10000)) / (double) 10000 + "," + (Math.round(this.getY() * 10000)) / (double) 10000 + ")";
    } //this method rounds the numbers before returning it to the user

    /**
     * Check if this point equals an other point
     *
     * @param other The point to be compared with this point
     * @return True if this point equals the other point
     */
    public boolean equals(Point other) {
        return (other._radius == _radius && other._alpha == _alpha);
    }

    /**
     * Check if this point is above of an other point
     *
     * @param other The point to check if this point is above of
     * @return true if this point is above of the other point
     */
    public boolean isAbove(Point other) {
        return other.getY() < this.getY();
    }

    /**
     * Check if this point is under an other point
     *
     * @param other The point to check if this point is under to
     * @return true if this point is under the other point
     */
    public boolean isUnder(Point other) {
        return other.isAbove(this);
    }

    /**
     * Check if this point is to the left of an other point
     *
     * @param other The point to check if this point is left of
     * @return true if this point is to the left of the other point
     */
    public boolean isLeft(Point other) {
        return this.getX() < other.getX();
    }

    /**
     * Check if this point is to the right of an other point
     *
     * @param other The point to check if this point is right of
     * @return true if this point is to the right of the other point
     */
    public boolean isRight(Point other) {
        return other.isLeft(this);
    }

    /**
     * Calculate the distance between this point and an other point
     *
     * @param p The point to calculate the distance from
     * @return The distance between this point and the other point
     */
    public double distance(Point p) {
        return Math.sqrt(Math.pow((this.getX() - p.getX()), 2) + Math.pow((this.getY() - p.getY()), 2));
    }

    /**
     * Moves the x and y coordinates by a given amount.
     * if the movement moves the point outside of the first quadrant then the
     * point will remain at the same place.
     *
     * @param dx The amount to move in the x direction
     * @param dy The amount to move in the y direction
     */
    public void move(double dx, double dy) {
        if ((this.getX() + dx) >= DEFAULT_VAL && (this.getY() + dy) >= DEFAULT_VAL) {
            this.setX(this.getX() + dx);
            this.setY(this.getY() + dy);
        }
    }
} //end of class Point
