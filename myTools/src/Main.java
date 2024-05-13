import conversion.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	Converter converter;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("UNITS:"
        		+ "\n1. Length"
        		+ "\n2. Head"
        		+ "\nSelect unit to convert:");
        converterSelector(scanner.nextInt());
        
        System.out.print("Enter value: ");
        double value = scanner.nextDouble();

        System.out.print("Enter unit to convert " + Arrays.toString(unit.units).toUpperCase() + ": ");
        String fromUnit = scanner.next().toUpperCase();

        System.out.print("Enter target unit "+ Arrays.toString(unit.units).toUpperCase() +": ");
        String toUnit = scanner.next().toUpperCase();

        double result = unit.convert(value, fromUnit, toUnit);
        System.out.println("Result: " + result + " " + toUnit);
    }
    
    public static Converter converterSelector(int num) {
    	switch (num) {
		case 1: {
			return Converter unit = new LengthConverter();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + num);
		}
    }
}