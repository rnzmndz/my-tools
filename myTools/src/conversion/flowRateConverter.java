package conversion;

public class flowRateConverter extends Converter{
	
	public flowRateConverter() {
		super();
		units = new String[] {"gpm","gph","gpd","cu. m/sec","cu. m/min","cu. m/hr",
				"cu. m/day", "liter/sec", "liter/min", "liter/hr"};
	}
	
	@Override
	public double convert(double value, String fromUnit, String toUnit) {
		double fromPsi = toGpm(value, fromUnit);
		return fromPsi / toGpm(1, toUnit);
	}
	
	private static double toGpm(double value, String unit) {
		switch(unit) {
		case "gpm":
			return value;
		case "gph":
			return value/60;
		case "gpd":
			return value/1440;
		case "cu. m/sec":
			return value * 15850.3231;
		case "cu. m/min":
			return value * 264.172;
		case "cu. m/hr":
			return value * 4.4028;
		case "cu. m/day":
			return value * 0.1835;
		case "liter/sec":
			return value * 15.8503;
		case "liter/min":
			return value * 0.2642;
		case "liter/hr":
			return value * 0.004403;
		default:
            throw new IllegalArgumentException("Unsupported unit: " + unit);
		}
	}

}
