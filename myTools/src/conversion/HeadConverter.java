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
			return value * 0.43341651888774657;
		case "meter":
			return value *  1.421970206324652;
		case "bar":
			return value * 14.5038;
		case "pascal":
			return value * 0.000145038;
		case "megapascal":
			return value / 0.00689476;
		default:
            throw new IllegalArgumentException("Unsupported unit: " + unit);
		}
	}

}
