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
	
	public PumpSize(double flowrate, double totalDynamicHead, double specificGravity) {
		this.flowrate = flowrate;
		this.TDH = totalDynamicHead;
		this.SPGR = specificGravity;
		
		calculateMotorSize();
	}

	public double getMotorSize() {
		return HP;
	}
	
	public void setPumpEfficiency(double Efficiency) {
		this.pumpEff = Efficiency;
		calculateMotorSize();
	}
	
	public void setMotorEfficiency(double Efficiency) {
		this.motorEff = Efficiency;
		calculateMotorSize();
	}
	public void calculateMotorSize() {
		this.HP = (this.flowrate*this.TDH*2.31*this.SPGR)/(3960*this.pumpEff*this.motorEff);
	}
}
