package General_Classes;

public class Testing1 extends Point1 { // uses the point object to create a segment, (adds length)

    private double _length;

    public Testing1(){
        this(1.0, 1.0, 1.0); // uses the constructor below
    }

    public Testing1(double x, double y, double len){
        super(x, y); // uses the constructor of the "father" class (Point)
        _length = len;
    }
    public String toString() {
        return super.toString() + "length: " + _length;

        // with "protected" like "private" in inheritance you can use variables from the super class
    }
}
