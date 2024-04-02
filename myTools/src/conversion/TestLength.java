package conversion;

import java.util.Scanner;

public class TestLength {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter value: ");
        double value = scanner.nextDouble();

        System.out.print("Enter unit to convert (METER, KILOMETER, CENTIMETER, INCH, FOOT): ");
        String fromUnit = scanner.next().toUpperCase();

        System.out.print("Enter target unit (METER, KILOMETER, CENTIMETER, INCH, FOOT): ");
        String toUnit = scanner.next().toUpperCase();

        double result = LengthConverter.convert(value, fromUnit, toUnit);
        System.out.println("Result: " + result + " " + toUnit);
    }
}

