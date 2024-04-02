package conversion;

public interface Converter {
	String[] units;
	
	double convert(double value, String fromUnit, String toUnit) {	
	}
}
