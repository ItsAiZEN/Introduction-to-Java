package General_Classes;

import java.util.Scanner;

public class Testing {

    public static int factorial(int num){
        int result;
        if (num == 1)
            result = 1;
        else
            result = num * factorial(num-1);
        return result;
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println(factorial(6));

        }
}
