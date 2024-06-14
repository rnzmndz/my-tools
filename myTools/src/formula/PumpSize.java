package formula;

public class PumpSize {
//	Horsepower
	private double HP;
//	Flow rate in gpm
	private double flowrate;
//	Total Dynamic Head (psi)
	private double TDH;
//	Specific Gravity (Water)
	private double SPGR;
//	Pump Efficiency
	private double pumpEff = 0.7;
//	Motor Efficiency
	private double motorEff = 0.9;
	
	public PumpSize(double flowrate, double totalDynamicHead, double specificGravity, double pumpEfficiency, double motorEfficiency) {
		this.flowrate = flowrate;
		this.TDH = totalDynamicHead;
		this.SPGR = specificGravity;
		this.pumpEff = pumpEfficiency;
		this.motorEff = motorEfficiency;
		
		calculateMotorSize();
	}

	public double getMotorSize() {
		return HP;
	}
	
	public void calculateMotorSize() {
		HP = (this.flowrate*this.TDH*2.31*this.SPGR)/(3960*this.pumpEff*this.motorEff);
	}
}
