package Maman11;
/* Written by Nir Eizenman on 09/11/2020, Circle Class
 * The Circle class will receive an input from the user of two points in order to draw a rectangle
 * the program will calculate the radius of the inner and outer circle that are enclosed inside or
 * outside the rectangle and also will calculate the area and perimeter of both of them
 */
import java.util.Scanner;
public class Circle
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);
        final double PI = Math.PI;
        System.out.println ("This program calculates the areas " +
                "and the perimeters of the excircle and the incircle " +
                "of a given rectangle ");
        System.out.print ("Please enter the two coordinates of the " +
                "left-upper point of the rectangle");
        int leftUpX = scan.nextInt(); // receive x of the upper-left point from the user
        int leftUpY = scan.nextInt(); // receive y of the upper-left point from the user
        System.out.print ("Please enter the two coordinates of the " +
                "down-right point of the rectangle");
        int downRightX = scan.nextInt(); // receive x of the low-right point from the user
        int downRightY = scan.nextInt();// receive y of the low-right point from the user
        double exRadius = Math.sqrt(Math.pow((leftUpX - downRightX), 2) + (Math.pow((leftUpY - downRightY), 2))) / 2.0; // calculate the radius of the outer circle
        double exArea = PI * (Math.pow((exRadius),2)); // calculate the area of the outer circle
        double exPerimeter = 2 * PI * exRadius; // calculate the perimeter of the outer circle
        double inRadius = (leftUpY - downRightY) / 2.0; // calculate the radius of the inner circle
        double inArea = PI * (Math.pow((inRadius),2)); // calculate the area of the inner circle
        double inPerimeter = 2 * PI * inRadius; // calculate the perimeter of the inner circle
        System.out.println("Incircle: radius = "+ inRadius + ", area = " + inArea + ", perimeter = " + inPerimeter +"\n" +
                                "Excircle: "+ exRadius + ", area = " + exArea + ", perimeter = " + exPerimeter); // print the results to the user
    } // end of method main
} //end of class Circle
