package myApp;

import java.net.URL;
import java.util.ResourceBundle;

import conversion.LengthConverter;
import conversion.flowRateConverter;
import conversion.velocityConverter;
import formula.FluidVelocity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FluidVelocityController implements BaseController, Initializable{
	private Main main;
	private String choice = "Circle";
	private Double velocity;
	
	flowRateConverter flowConvert = new flowRateConverter();
	LengthConverter lengthConvert = new LengthConverter();
	velocityConverter velocityConvert = new velocityConverter();
	
	
	@FXML
	ComboBox<String> comboBoxShape;
	
	@FXML
	ComboBox<String> comboBoxFlowrateUnit;
	
	@FXML
	ComboBox<String> comboBoxDiameterUnit;
	
	@FXML
	ComboBox<String> comboBoxHeightUnit;
	
	@FXML
	ComboBox<String> comboBoxVelocityUnit;
	
	@FXML
	TextField textFieldFlowRate;
	
	@FXML
	TextField textFieldDiameter;
	
	@FXML
	TextField textFieldHeight;
	
	@FXML
	Label labelHeight;
	
	@FXML
	Label textLabelVelocityAnswer;
	
	public void setMain(Main main) {
		this.main = main;
		comboBoxShape.getItems().addAll("Circle","Square");
		comboBoxShape.setValue(choice);
		comboBoxFlowrateUnit.getItems().addAll(flowConvert.units);
		comboBoxFlowrateUnit.setValue("cu. m/sec");
		comboBoxDiameterUnit.getItems().addAll(lengthConvert.units);
		comboBoxDiameterUnit.setValue("meter");
		comboBoxHeightUnit.getItems().addAll(lengthConvert.units);
		comboBoxHeightUnit.setValue("meter");
		comboBoxVelocityUnit.getItems().addAll(velocityConvert.units);
		comboBoxVelocityUnit.setValue("m/s");
		chooseShape();
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
	
	@FXML
	public void chooseShape() {
		try {
			this.choice = comboBoxShape.getValue();
			
			switch (choice) {
			case "Circle": {
				comboBoxHeightUnit.setVisible(false);
				textFieldHeight.setVisible(false);
				labelHeight.setVisible(false);
				break;
			}
			case "Square": {
				comboBoxHeightUnit.setVisible(true);
				textFieldHeight.setVisible(true);
				labelHeight.setVisible(true);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@FXML
	public void calculate() {
		try {
			double flowrate = Double.parseDouble(textFieldFlowRate.getText());
			double convertedFlowRate = flowConvert.convert(flowrate, comboBoxFlowrateUnit.getValue(), "cu. m/sec");
			double diameter = Double.parseDouble(textFieldDiameter.getText());
			double convertedDiameter = lengthConvert.convert(diameter, comboBoxDiameterUnit.getValue(), "meter");
			
			switch (choice) {
			case "Circle": {
				FluidVelocity getVelocity = new FluidVelocity(convertedFlowRate, convertedDiameter, choice);
				velocity = getVelocity.getVelocity();
				break;
			}
			
			case "Square": {
				double height = Double.parseDouble(textFieldHeight.getText());
				double convertedHeight = lengthConvert.convert(height, comboBoxHeightUnit.getValue(), "meter");
				FluidVelocity getVelocity = new FluidVelocity(convertedFlowRate, convertedDiameter, convertedHeight, choice);
				velocity = getVelocity.getVelocity();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
			
			Double convertedVelocity = velocityConvert.convert(velocity, comboBoxVelocityUnit.getValue(), "m/s");
			textLabelVelocityAnswer.setText(Double.toString(convertedVelocity));
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
