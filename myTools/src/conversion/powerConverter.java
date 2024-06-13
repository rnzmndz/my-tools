package conversion;

public class powerConverter extends Converter{
	
	public powerConverter() {
		super();
		units = new String[] {"hp", "watt", "kilowatt", "metric hp", "fl-lbf/s",
				"BTU/h", "cal/s", "kcal/s", "erg/s", "J/s", "megawatt", "kVA"};
	}
	
	@Override
	public double convert(double value, String fromUnit, String toUnit) {
		double fromPsi = toHp(value, fromUnit);
		return fromPsi / toHp(1, toUnit);
	}
	
	private static double toHp(double value, String unit) {
		switch(unit) {
		case "hp":
			return value;
		case "watt":
			return value * 745.69987158227022;
		case "kilowatt":
			return value * 0.74569987158227022;
		case "metric hp":
			return value * 1.0138696789;
		case "fl-lbf/s":
			return value * 550;
		case "BTU/h":
			return value * 2544.43358;
		case "cal/s":
			return value * 178.107193;
		case "kcal/s":
			return value * 641.18647;
		case "erg/s":
			return value * 7.457e9;
		case "J/s":
			return value * 745.69987158227022;
		case "megawatt":
			return value * 0.00074569987158227022;
		case "kVA":
			return value * 0.74569987158227022;
		default:
            throw new IllegalArgumentException("Unsupported unit: " + unit);
		}
	}

}
