package General_Classes;
//***************************************************************
//General_Classes.FirstClass.java
//This is my first class, i will learn to use java in this class
//***************************************************************
import java.util.Scanner;
public class FirstClass
{
    public static void main(String[]args)
    {
        Scanner scan = new Scanner(System.in);
        Point p1 = new Point(1,2);
        System.out.println(p1);
        p1.move(0,3);
        System.out.println(p1);
    }
}