package formula;

public class HazenWilliamsFormula {
//	Total friction loss in pipe(psi)
	private double totalFrictionloss;
//	Total flow in pipe (gpm)
	private double totalFlow;
//	Length in pipe (feet)
	private double pipeLength;
//	Coefficient factor of pipe (from NFPA-13 Table)
	private short pipeCoefficient;
//	Diameter of pipe (inches)
	private float pipeDiameter;
//	Choose what to find
	private String missing;
	public HazenWilliamsFormula(double totalFrictionloss, double totalFlow, double pipeLength, short pipeCoefficient = 120, float pipeDiameter, String missing) {
		this.totalFrictionloss = totalFrictionloss;
		this.totalFlow = totalFlow;
		this.pipeLength = pipeLength;
		this.pipeCoefficient = pipeCoefficient;
		this.pipeDiameter = pipeDiameter;
		this.missing = missing;
		
		switch (this.missing) {
		case "TFL": {
			this.totalFrictionloss = (4.52*Math.pow(this.totalFlow, 1.85)*this.pipeLength)/
									(Math.pow(this.pipeCoefficient, 1.85)*Math.pow(this.pipeDiameter, 1.85));
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.missing);
		}
	}
	
	public double getTotalFrictionLoss() {
		return totalFrictionloss;
	}
	
	public double getTotalFlow(){
		return totalFlow;
	}
	
	public double getPipeLength() {
		return pipeLength;
	}
	
	public short getPipeCoefficient() {
		return pipeCoefficient;
	}
	
	public float getPipeDiameter() {
		return pipeDiameter;
	}

}
