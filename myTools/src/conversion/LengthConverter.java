package conversion;  

public class LengthConverter extends Converter{

	public LengthConverter() {
		super();
		units = new String[]{"meter", "kilometer", "centimeter", "millimeter", "micrometer", "nanometer", "inch", "foot", "yard", "miles", "nautical_miles"};
	}
	@Override
	public double convert(double value, String fromUnit, String toUnit) {
        double fromMeters = toMeters(value, fromUnit);
        return fromMeters / toMeters(1, toUnit);
    }

    private static double toMeters(double value, String unit) {
        switch (unit) {
            case "METER":
                return value;
            case "KILOMETER":
                return value * 1000;
            case "CENTIMETER":
                return value / 100;
            case "MILLIMETER":
            	return value / 1_000;
            case "MICROMETER":
            	return value / 1_000_000;
            case "NANOMETER":
            	return value / 1_000_000_000;
            case "INCH":
                return value * 0.0254;
            case "FOOT":
                return value * 0.3048;
            case "YARD":
            	return value * 1.093613;
            case "MILES":
            	return value * 0.000621;
            case "NAUTICAL_MILE":
            	return value * 0.00054;
            default:
                throw new IllegalArgumentException("Unsupported unit: " + unit);
        }
    }
}
