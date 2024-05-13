package conversion;

public class HeadConverter extends Converter{
	
	public HeadConverter() {
		super();
		units = new String[] {"psi","feet","meter","bar","pascal","megapascal"};
	}
	
	@Override
	public double convert(double value, String fromUnit, String toUnit) {
		double fromPsi = toPsi(value, fromUnit);
		return fromPsi / toPsi(1, toUnit);
	}
	
	private static double toPsi(double value, String unit) {
		switch(unit) {
		case "psi":
			return value;
		case "feet":
			return value * 2.31;
		case "meter":
			return value *  0.70324961490205;
		case "bar":
			return value * 0.0689476;
		case "pascal":
			return value * 6894.76;
		case "megapascal":
			return value * 0.00689476;
		default:
            throw new IllegalArgumentException("Unsupported unit: " + unit);
		}
	}

}
