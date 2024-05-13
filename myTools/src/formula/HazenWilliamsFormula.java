package formula;

public class HazenWilliamsFormula {
//	Total friction loss in pipe(psi)
	private double totalFrictionloss;
//	Total flow in pipe (gpm)
	private double totalFlow;
//	Length in pipe (feet)
	private double pipeLength;
//	Coefficient factor of pipe (from NFPA-13 Table)
	private int pipeCoefficient;
//	Diameter of pipe (inches)
	private double pipeDiameter;

	public HazenWilliamsFormula(double totalFlow, double pipeLength, int pipeCoefficient, double pipeDiameter) {
		this.totalFlow = totalFlow;
		this.pipeLength = pipeLength;
		this.pipeCoefficient = pipeCoefficient;
		this.pipeDiameter = pipeDiameter;
		calculateTotalFrictionLoss();
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
	
	public int getPipeCoefficient() {
		return pipeCoefficient;
	}
	
	public double getPipeDiameter() {
		return pipeDiameter;
	}
	
	public void calculateTotalFrictionLoss() {
		this.totalFrictionloss = (4.52*Math.pow(this.totalFlow, 1.85)*this.pipeLength)/
				(Math.pow(this.pipeCoefficient, 1.85)*Math.pow(this.pipeDiameter, 4.87));
	}

}
