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
            case "meter":
                return value;
            case "kilometer":
                return value * 1000;
            case "centimeter":
                return value / 100;
            case "millimeter":
            	return value / 1_000;
            case "micrometer":
            	return value / 1_000_000;
            case "nanometer":
            	return value / 1_000_000_000;
            case "inch":
                return value * 0.0254;
            case "foot":
                return value * 0.3048;
            case "yard":
            	return value * 1.093613;
            case "mile":
            	return value * 0.000621;
            case "nautical_miles":
            	return value * 0.00054;
            default:
                throw new IllegalArgumentException("Unsupported unit: " + unit);
        }
    }
}
