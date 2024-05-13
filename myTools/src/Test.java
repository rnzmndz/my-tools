import formula.PumpSize;

public class Test {

	public static void main(String[] args) {
	var obj = new PumpSize(750, 72, 1);
	System.out.println(obj.getMotorSize());
	obj.setPumpEfficiency(.80);;
	System.out.println(obj.getMotorSize());
	
	}

}
