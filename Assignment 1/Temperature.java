/* Written by Nir Eizenman on 09/11/2020, Temperature Class
 * The Temperature class will receive an input from the user of a temperature unit type and
 * a temperature itself and will convert the unit to celsius, fahrenheit and kelvin
 */
import java.util.Scanner;
public class Temperature
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);
        System.out.println ("This program converts temperature unit types to celsius, fahrenheit and kelvin ");
        System.out.print ("Please enter the unit of measurement and the temperature");
        String unitType = scan.next(); // receive unit type from the user
        double temperature = scan.nextDouble(); // receive the temperature itself
        char unit = unitType.charAt(0); // convert the unit type into char
        double celsius, fahrenheit, kelvin;
        final double CONVERSION_RATIO = 5/9.0;
        final double CONSTANT_DIFFERENCE = 273.15;
        final double OPPOSED_CONVERSION_RATIO = 9/5.0;
        final double FAHRENHEIT_FREEZE_POINT = 32;

        switch (unit)
        {
            case 'C': // switch case if the measurement unit is celsius
                celsius = temperature;
                fahrenheit = temperature * OPPOSED_CONVERSION_RATIO + FAHRENHEIT_FREEZE_POINT; // convert celsius to fahrenheit
                kelvin = temperature + CONSTANT_DIFFERENCE; // convert celsius to kelvin
                System.out.println(celsius + " C\n" + fahrenheit + " F\n" + kelvin + " K"); // print the results to the user
                break;
            case 'F': // switch case if the measurement unit is fahrenheit
                celsius = (temperature - 32) * CONVERSION_RATIO ; // convert fahrenheit to celsius
                fahrenheit = temperature;
                kelvin = (temperature - FAHRENHEIT_FREEZE_POINT) * CONVERSION_RATIO + CONSTANT_DIFFERENCE;  // convert fahrenheit to kelvin
                System.out.println(celsius + " C\n" + fahrenheit + " F\n" + kelvin + " K"); // print the results to the user
                break;
            case 'K': // switch case if the measurement unit is kelvin
                celsius = temperature - CONSTANT_DIFFERENCE; // convert kelvin to celsius
                fahrenheit = OPPOSED_CONVERSION_RATIO *(temperature - CONSTANT_DIFFERENCE) + FAHRENHEIT_FREEZE_POINT; // convert kelvin to fahrenheit
                kelvin = temperature;
                System.out.println(celsius + " C\n" + fahrenheit + " F\n" + kelvin + " K"); // print the results to the user
                break;
        } // end of switch
    } // end of method main
} //end of class Temperature
