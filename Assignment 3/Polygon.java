package Maman13;

/**
 * Represents a polygon using a Maman13.Point objects array as the vertices
 *
 * @author Nir Eizenman
 * @version 2/12/2020
 */
public class Polygon {
    private final int MAX_POINTS = 10;
    private Point[] _vertices;
    private int _noOfVertices;

    /**
     * Constructs an array of Points (to its maximum size) to represent a polygon
     * sets the amount of vertices to 0
     */
    public Polygon() {
        _vertices = new Point[MAX_POINTS];
        _noOfVertices = 0;
    }

    /**
     * Inserts a point into the Maman13.Point array (polygon) using x and y coordinates
     *
     * @param x X value of the point
     * @param y Y value of the point
     * @return Returns true if it was able to insert the point, false if it wasn't able to
     */
    public boolean addVertex(double x, double y) {
        if (_noOfVertices == MAX_POINTS)
            return false;

        _vertices[_noOfVertices] = new Point(x, y);
        _noOfVertices++;
        return true;
    }

    /**
     * Checks which vertex in the array (polygon) is the highest and returns it
     *
     * @return Returns a copy of the highest vertex of the polygon, if there are no vertices it returns null
     */
    public Point highestVertex() {
        if (_noOfVertices == 0)
            return null;
        Point highest = _vertices[0];
        for (int i = 1; i < _noOfVertices; i++) {
            if (_vertices[i].isAbove(highest))  // Checks if the current point of higher than the point before it
                highest = _vertices[i];
        }
        return new Point(highest);
    }

    /**
     * Return a string representation of the polygon by returning the amount of vertices and their coordinates
     *
     * @return String representation the polygon
     */
    public String toString() {
        if (_noOfVertices == 0)
            return "The polygon has 0 vertices.";
        else {
            String vertexList = "The polygon has " + _noOfVertices + " vertices:\n" + "(" + _vertices[0];
            for (int i = 1; i < _noOfVertices; i++)
                vertexList = vertexList + "," + _vertices[i]; // Appends to the string all the points in the Maman13.Point array
            vertexList = vertexList + ")";
            return vertexList;
        }
    }

    /**
     * Calculates the perimeter of the polygon, if the polygon has less than 2 vertices it will return 0,
     * if it has 2 vertices it returns the length of the segment between those points
     *
     * @return Returns the perimeter of the polygon
     */
    public double calcPerimeter() {
        if (_noOfVertices < 2)
            return 0;
        if (_noOfVertices == 2)
            return _vertices[0].distance(_vertices[1]);
        else {
            double sum = 0;
            for (int i = 0; i < _noOfVertices - 1; i++)
                sum += _vertices[i].distance(_vertices[i + 1]); // Calculates the sum of all the segments which construct the polygon
            sum += _vertices[_noOfVertices - 1].distance(_vertices[0]); // Adds to the sum the segment between the last point and the first point
            return sum;
        }
    }

    /**
     * Calculates the area of a triangle created by 3 Maman13.Point objects.
     *
     * @param p  The first point
     * @param p1 The second point
     * @param p2 The third point
     * @return Returns the area of the triangle
     */
    private double triangleArea(Point p, Point p1, Point p2) {
        double half_perimeter = ((p.distance(p1) + p1.distance(p2) + p2.distance(p)) / 2.0);
        return Math.sqrt(half_perimeter * (half_perimeter - p.distance(p1)) * (half_perimeter - p1.distance(p2))
                * (half_perimeter - p2.distance(p))); // Calculates the area of the triangle using Heron's formula
    }

    /**
     * Calculates the area of the polygon by calculating the perimeters of the triangles that create the polygon,
     * if the polygon has less than 3 vertices it returns 0
     *
     * @return Returns the area of the polygon
     */
    public double calcArea() {
        if (_noOfVertices < 3)
            return 0;
        else {
            double area = 0;
            for (int i = 1, j = 2; j < _noOfVertices; i++, j++) {
                area += triangleArea(_vertices[0], _vertices[i], _vertices[j]); // Calculates the sum of the areas of the triangles which construct the polygon
            }
            return area;
        }
    }

    /**
     * Checks if the area of this polygon is bigger than the area of a given polygon
     *
     * @param other The other polygon
     * @return Returns true if this polygon's area is bigger than the other polygon's area, if not it returns false
     */
    public boolean isBigger(Polygon other) {
        return this.calcArea() > other.calcArea();
    }

    /**
     * Check if the point (vertex) given exists within the polygon (Maman13.Point array) if so it returns the location of the
     * location of the point (vertex) in the polygon (Maman13.Point array)
     *
     * @param p The point given to check its location in the polygon
     * @return Returns the location of the point in the polygon if found, if not returns -1
     */
    public int findVertex(Point p) {
        for (int i = 0; i < _noOfVertices; i++) {
            if (p.equals(_vertices[i]))
                return i;
        }
        return -1;
    }

    /**
     * Checks if a given point is in the polygon (Maman13.Point array) and returns the next point in the polygon (array),
     * if the point is not found it returns null, if the point is the last point of the polygon (array), it returns the first point
     *
     * @param p The point given in order to check the next one
     * @return Returns the next point after the point given in the polygon, if the point is not found returns null,
     * if the given point is the last point, it returns the first point
     */
    public Point getNextVertex(Point p) {
        if (findVertex(p) == -1)
            return null;
        else if (findVertex(p) == _noOfVertices - 1)
            return new Point(_vertices[0]);
        else
            return new Point(_vertices[findVertex(p) + 1]);

    }

    /**
     * Creates a new polygon that if the bounding box for this polygon, if this polygon has less than 3 vertices it returns null
     *
     * @return Returns the bounding box of this polygon, it this polygon has less that 3 vertices it returns null
     */
    public Polygon getBoundingBox() {
        if (_noOfVertices < 3)
            return null;
        else {
            Polygon po = new Polygon();
            double lowest = _vertices[0].getY();
            double highest = _vertices[0].getY();
            double leftmost = _vertices[0].getX();
            double rightmost = _vertices[0].getX();
            for (int i = 1; i < _noOfVertices; i++) {
                if (_vertices[i].getY() < lowest)
                    lowest = _vertices[i].getY(); // Checks the lowest Y of the array
                if (_vertices[i].getY() > highest)
                    highest = _vertices[i].getY(); // Checks the highest Y of the array
                if (_vertices[i].getX() < leftmost)
                    leftmost = _vertices[i].getX(); // Checks the leftmost X of the array
                if (_vertices[i].getX() > rightmost)
                    rightmost = _vertices[i].getX(); // Checks the rightmost X of the array
            }
            po.addVertex(leftmost, lowest); // Creates the bottom-left vertex
            po.addVertex(rightmost, lowest); // Creates the bottom-right vertex
            po.addVertex(rightmost, highest); // Creates the upper-right vertex
            po.addVertex(leftmost, highest); // Creates the upper-left vertex
            return po;
        }
    }
} //end of class Maman13.Polygon
