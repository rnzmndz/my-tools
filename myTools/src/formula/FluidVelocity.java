package formula;

public class FluidVelocity {
	private double fluidVelocity;
	private double flowRate;
	private double diameter;
	private double side1;
	private double side2;
	private double area;
	private String shape;
	
	public FluidVelocity(double flowRate, double diameter, String shape) {
		this.flowRate = flowRate;
		this.diameter = diameter;
		this.shape = shape;
		calculate();
	}
	
	public FluidVelocity(double flowRate, double side1, double side2, String shape) {
		this.flowRate = flowRate;
		this.side1 = side1;
		this.side2 = side2;
		this.shape = shape;
		calculate();
	}
	
	public void chooseShape() {
		switch (shape.toLowerCase()) {
		case "square" : 
			area = side1 * side2;
			break;
		case "circle":
			area = Math.PI*Math.pow(diameter/2, 2);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + shape);
		}
	}
	
	public void calculate() {
		chooseShape();
		fluidVelocity = flowRate/area;
	}
	
	public double getVelocity() {
		return fluidVelocity;
	}

}
