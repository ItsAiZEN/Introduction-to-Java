/**
 * Segment1 represents a line using two Points.
 *
 * @author Nir Eizenman
 * @version 19/11/2020
 */
public class Segment1 {
    private final int DEFAULT_VAL = 0;
    private Point _poLeft;
    private Point _poRight;

    /**
     * Constructs a new segment using two Points. If the y coordinates are different,
     * change the y of the right point to be equal to the y of the left point.
     *
     * @param left  The left point of the segment
     * @param right The right point of the segment
     */
    public Segment1(Point left, Point right) {
        if (left.getY() != right.getY())
            right.setY(left.getY());
        _poLeft = new Point(left);
        _poRight = new Point(right);
    }

    /**
     * Constructs a new segment using 4 specified x y coordinates: Two coordinates for
     * the left point and two coordinates for the right point. If the y coordinates are
     * different, change the y of the right point to be equal to the y of the left point.
     *
     * @param leftX  X value of left point
     * @param leftY  Y value of left point
     * @param rightX X value of right point
     * @param rightY Y value of right point
     */
    public Segment1(double leftX, double leftY, double rightX, double rightY) {
        if (leftY != rightY)
            rightY = leftY;
        _poLeft = new Point(leftX, leftY);
        _poRight = new Point(rightX, rightY);
    }

    /**
     * Copy Constructor. Construct a segment using a reference segment.
     *
     * @param other The reference segment
     */
    public Segment1(Segment1 other) {
        _poLeft = new Point(other._poLeft);
        _poRight = new Point(other._poRight);
    }

    /**
     * Returns the left point of the segment.
     *
     * @return The left point of the segment
     */
    public Point getPoLeft() {
        return _poLeft;
    }

    /**
     * Returns the right point of the segment.
     *
     * @return The right point of the segment
     */
    public Point getPoRight() {
        return _poRight;
    }

    /**
     * Returns the segment length.
     *
     * @return The segment length
     */
    public double getLength() {
        return _poLeft.distance(_poRight);
    }

    /**
     * Return a string representation of this segment in the format (3.0,4.0)---(3.0,6.0).
     *
     * @return String representation of this segment
     */
    public String toString() {
        return _poLeft + "---" + _poRight;
    }

    /**
     * Check if the reference segment is equal to this segment.
     *
     * @param other the reference segment
     * @return True if the reference segment is equal to this segment
     */
    public boolean equals(Segment1 other) {
        return _poLeft.equals(other._poLeft) && _poRight.equals(other._poRight);
    }

    /**
     * Check if this segment is above a reference segment.
     *
     * @param other the reference segment
     * @return True if this segment is above the reference segment
     */
    public boolean isAbove(Segment1 other) {
        return other._poLeft.getY() < this._poLeft.getY();
    }

    /**
     * Check if this segment is under a reference segment.
     *
     * @param other the reference segment
     * @return True if this segment is under the reference segment
     */
    public boolean isUnder(Segment1 other) {
        return other.isAbove(this);
    }

    /**
     * Check if this segment is left of a received segment.
     *
     * @param other the reference segment
     * @return True if this segment is left to the reference segment
     */
    public boolean isLeft(Segment1 other) {
        return this._poRight.getX() < other._poLeft.getX();
    }

    /**
     * Check if this segment is right of a received segment.
     *
     * @param other the reference segment
     * @return True if this segment is right to the reference segment
     */
    public boolean isRight(Segment1 other) {
        return other.isLeft(this);
    }

    /**
     * Move the segment horizontally by delta.
     * if the movement moves the segment outside of the first quadrant then the
     * point will remain at the same place.
     *
     * @param delta - the displacement size
     */
    public void moveHorizontal(double delta) {
        if ((this._poLeft.getX() + delta) >= DEFAULT_VAL) {
            this._poLeft.setX(this._poLeft.getX() + delta);
            this._poRight.setX(this._poRight.getX() + delta);
        }
    }

    /**
     * Move the segment vertically by delta.
     * if the movement moves the segment outside of the first quadrant then the
     * point will remain at the same place.
     *
     * @param delta - the displacement size
     */
    public void moveVertical(double delta) {
        if ((this._poLeft.getY() + delta) >= DEFAULT_VAL) {
            this._poLeft.setY(this._poLeft.getY() + delta);
            this._poRight.setY(this._poRight.getY() + delta);
        }
    }

    /**
     * Change the segment size by moving the right point by delta.
     * Will be implemented only for a valid delta: only if the new right point remains the right point.
     *
     * @param delta - the length change
     */
    public void changeSize(double delta) {
        if ((this._poRight.getX() + delta) >= this._poLeft.getX()) {
            this._poRight.setX(this._poRight.getX() + delta);
        }
    }

    /**
     * Check if a point is located on the segment.
     *
     * @param p a point to be checked
     * @return True if p is on this segment
     */
    public boolean pointOnSegment(Point p) {
        return ((p.getY() == this._poLeft.getY()) && (this._poLeft.getX() <= p.getX()) && (p.getX() <= this._poRight.getX()));
    }

    /**
     * Check if this segment is bigger than a reference segment.
     *
     * @param other the reference segment
     * @return True if this segment is bigger than the reference segment
     */
    public boolean isBigger(Segment1 other) {
        return (other._poRight.getX() - other._poLeft.getX()) < (this._poRight.getX() - this._poLeft.getX());
    }

    /**
     * Returns the overlap size of this segment and a reference segment.
     *
     * @param other the reference segment
     * @return The overlap size
     */
    public double overlap(Segment1 other) {
        double sum = Math.min(this._poRight.getX(), other._poRight.getX()) - Math.max(this._poLeft.getX(), other._poLeft.getX());
        if (0 < sum)
            return sum;
        else
            return 0;
    }

    /**
     * Compute the trapeze perimeter, which is constructed by this segment and a reference segment.
     *
     * @param other the reference segment
     * @return The trapeze perimeter
     */
    public double trapezePerimeter(Segment1 other) {
        return this._poRight.distance(this._poLeft) + this._poLeft.distance(other._poLeft) + other._poLeft.distance(other._poRight) + other._poRight.distance(this._poRight);
    }
} //end of class Segment1
