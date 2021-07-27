/**
 * Segment2 represents a line (parallel to the x-axis) using a center point and length.
 *
 * @author Nir Eizenman
 * @version 19/11/2020
 */
public class Segment2 {
    private final int DEFAULT_VAL = 0;
    private Point _poCenter;
    private double _length;

    /**
     * Constructs a new segment using two Points. If the y coordinates are different,
     * change the y of the right point to be equal to the y of the left point.
     *
     * @param left  The left point of the segment
     * @param right The right point of the segment
     */
    public Segment2(Point left, Point right) {
        if (left.getY() != right.getY())
            right.setY(left.getY());
        _length = right.getX() - left.getX();
        _poCenter = new Point((right.getX() - (_length / 2)), left.getY());
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
    public Segment2(double leftX, double leftY, double rightX, double rightY) {
        if (leftY != rightY)
            rightY = leftY;
        _length = rightX - leftX;

        _poCenter = new Point((rightX - (_length / 2)), leftY);
    }

    /**
     * Copy Constructor. Construct a segment using a reference segment.
     *
     * @param other The reference segment
     */
    public Segment2(Segment2 other) {
        _poCenter = new Point(other._poCenter);
        _length = other._length;
    }

    /**
     * Constructs a new segment using a center point and the segment length.
     *
     * @param poCenter the Center Point
     * @param length   the segment length
     */
    public Segment2(Point poCenter, double length) {
        _poCenter = new Point(poCenter);
        _length = length;
    }

    /**
     * Returns the left point of the segment.
     *
     * @return The left point of the segment
     */
    public Point getPoLeft() {
        return new Point(this._poCenter.getX() - (_length / 2), _poCenter.getY());
    }

    /**
     * Returns the right point of the segment.
     *
     * @return The right point of the segment
     */
    public Point getPoRight() {
        return new Point(this._poCenter.getX() + (_length / 2), _poCenter.getY());
    }

    /**
     * Returns the segment length.
     *
     * @return The segment length
     */
    public double getLength() {
        return _length;
    }

    /**
     * Return a string representation of this segment in the format (3.0,4.0)---(3.0,6.0).
     *
     * @return String representation of this segment
     */
    public String toString() {
        return this.getPoLeft() + "---" + this.getPoRight();
    }

    /**
     * Check if the reference segment is equal to this segment.
     *
     * @param other the reference segment
     * @return True if the reference segment is equal to this segment
     */
    public boolean equals(Segment2 other) {
        return _poCenter.equals(other._poCenter) && _length == other._length;
    }

    /**
     * Check if this segment is above a reference segment.
     *
     * @param other the reference segment
     * @return True if this segment is above the reference segment
     */
    public boolean isAbove(Segment2 other) {
        return other._poCenter.getY() < this._poCenter.getY();
    }

    /**
     * Check if this segment is under a reference segment.
     *
     * @param other the reference segment
     * @return True if this segment is under the reference segment
     */
    public boolean isUnder(Segment2 other) {
        return other.isAbove(this);
    }

    /**
     * Check if this segment is left of a received segment.
     *
     * @param other the reference segment
     * @return True if this segment is left to the reference segment
     */
    public boolean isLeft(Segment2 other) {
        return this.getPoRight().getX() < other.getPoLeft().getX();
    }

    /**
     * Check if this segment is right of a received segment.
     *
     * @param other the reference segment
     * @return True if this segment is right to the reference segment
     */
    public boolean isRight(Segment2 other) {
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
        if ((this.getPoLeft().getX() + delta) >= DEFAULT_VAL) {
            this._poCenter.setX(_poCenter.getX() + delta);
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
        if ((this._poCenter.getY() + delta) >= DEFAULT_VAL)
            this._poCenter.setY(this._poCenter.getY() + delta);
    }

    /**
     * Change the segment size by moving the right point by delta.
     * Will be implemented only for a valid delta: only if the new right point remains the right point.
     *
     * @param delta - the length change
     */
    public void changeSize(double delta) {
        if ((this.getPoRight().getX() + delta) >= this.getPoLeft().getX()) {
            _poCenter.setX(this.getPoRight().getX() + (delta / 2));
            _length += delta;
        }
    }

    /**
     * Check if a point is located on the segment.
     *
     * @param p a point to be checked
     * @return True if p is on this segment
     */
    public boolean pointOnSegment(Point p) {
        return ((p.getY() == this._poCenter.getY()) && (this.getPoLeft().getX() <= p.getX()) && (p.getX() <= this.getPoRight().getX()));
    }

    /**
     * Check if this segment is bigger than a reference segment.
     *
     * @param other the reference segment
     * @return True if this segment is bigger than the reference segment
     */
    public boolean isBigger(Segment2 other) {
        return other._length < this._length;
    }

    /**
     * Returns the overlap size of this segment and a reference segment.
     *
     * @param other the reference segment
     * @return The overlap size
     */
    public double overlap(Segment2 other) {
        double sum = Math.min(this.getPoRight().getX(), other.getPoRight().getX()) - Math.max(this.getPoLeft().getX(), other.getPoLeft().getX());
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
    public double trapezePerimeter(Segment2 other) {
        return this._length + this.getPoLeft().distance(other.getPoLeft()) + other._length + other.getPoRight().distance(this.getPoRight());
    }
} //end of class Segment2

