package conversion;

public class velocityConverter extends Converter{
	
	public velocityConverter() {
		super();
		units = new String[] {"m/s", "km/h", "mph", "ft/s", "knots", 
				"cm/s", "in/s", "km/s", "mach", "yd/s", "c"};
	}
	
	@Override
	public double convert(double value, String fromUnit, String toUnit) {
		double fromPsi = tometerpersecond(value, fromUnit);
		return fromPsi / tometerpersecond(1, toUnit);
	}
	
	private static double tometerpersecond(double value, String unit) {
		switch (unit) {
		case "m/s":
			return value;
		case "km/h":
			return value * 3.6;
		case "mph":
			return value * 2.23694;
		case "ft/s":
			return value * 3.28084;
		case "knots":
			return value * 1.94384;
		case "cm/s":
			return value * 100;
		case "in/s":
			return value * 39.3701;
		case "km/s":
			return value * 0.001;
		case "mach":
			return value *  0.00294;
		case "yd/s":
			return value * 1.09361;
		case "c":
			return value * 3.33564e-9;
		default:
			throw new IllegalArgumentException("Unexpected value: " + unit);
		}
	}
}
