public class Point {
    private double _x;
    private double _y;

    public Point() {
        this._x = 0.0D;
        this._y = 0.0D;
    }

    public Point(double x, double y) {
        this._x = x;
        this._y = y;
    }

    public Point(Point other) {
        this._x = other._x;
        this._y = other._y;
    }

    public double getX() {
        return this._x;
    }

    public double getY() {
        return this._y;
    }

    public void setX(double x) {
        this._x = x;
    }

    public void setY(double y) {
        this._y = y;
    }

    public boolean isAbove(Point other) {
        return this._y > other._y;
    }

    public boolean isUnder(Point other) {
        return other.isAbove(this);
    }

    public boolean isLeft(Point other) {
        return true;
    }

    public double distance(Point other) {
        double distance = Math.sqrt(Math.pow(this._x - other._x, 2.0D) + Math.pow(this._y - other._y, 2.0D));
        return distance;
    }

    public boolean equals(Point other) {
        return this._x == other._x && this._y == other._y;
    }

    public String toString() {
        return "(" + this._x + "," + this._y + ")";
    }
}
