import conversion.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter unit = null;
        
        System.out.print("1. Length\nSelect unit to convert:");
        converterSelector(scanner.nextInt());

        System.out.print("Enter value: ");
        double value = scanner.nextDouble();

        System.out.print("Enter unit to convert (METER, KILOMETER, CENTIMETER, INCH, FOOT): ");
        String fromUnit = scanner.next().toUpperCase();

        System.out.print("Enter target unit (METER, KILOMETER, CENTIMETER, INCH, FOOT): ");
        String toUnit = scanner.next().toUpperCase();

        double result = unit.convert(value, fromUnit, toUnit);
        System.out.println("Result: " + result + " " + toUnit);
    }
    
    public static void converterSelector(int num) {
    	switch (num) {
		case 1: {
			LengthConverter unit = new LengthConverter();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + num);
		}
    }
}