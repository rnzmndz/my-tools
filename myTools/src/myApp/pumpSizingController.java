package myApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import conversion.HeadConverter;
import conversion.flowRateConverter;
import conversion.powerConverter;
import formula.*;

public class pumpSizingController implements BaseController, Initializable{
	private Main main;
	
	HeadConverter headConvert = new HeadConverter();
	flowRateConverter flowConvert = new flowRateConverter();
	powerConverter powerConvert = new powerConverter();
	
	@FXML
	TextField textFieldFlowRate;
	
	@FXML
	TextField textFieldHead;
	
	@FXML
	TextField textFieldFluidDensity;
	
	@FXML
	TextField textFieldPumpEfficiency;
	
	@FXML
	TextField textFieldMotorEfficiency;
	
	@FXML
	Label labelAnswer;
	
	@FXML
	ComboBox<String> comboBoxFlowRateUnit;
	
	@FXML
	ComboBox<String> comboBoxHeadUnit;
	
	@FXML
	ComboBox<String> comboBoxPowerUnits;
	
	public void setMain(Main main) {
		this.main = main;
		textFieldMotorEfficiency.setText("0.9");
		textFieldPumpEfficiency.setText("0.7");
		textFieldFluidDensity.setText("1");
		comboBoxFlowRateUnit.getItems().addAll(flowConvert.units);
		comboBoxFlowRateUnit.setValue("gpm");
		comboBoxHeadUnit.getItems().addAll(headConvert.units);
		comboBoxHeadUnit.setValue("psi");
		comboBoxPowerUnits.getItems().addAll(powerConvert.units);
		comboBoxPowerUnits.setValue("hp");
	}
	
	@FXML
	private void switchMain(ActionEvent event) {
		main.showScene("Main.fxml", "My Tools", mainController.class);
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
	
	@FXML
	private void calculate() {
		try {
			validateInput();
			double flowRate = Double.parseDouble(textFieldFlowRate.getText().toString());
			double convertedFlowRate = flowConvert.convert(flowRate, comboBoxFlowRateUnit.getValue(), "gpm");
			double head = Double.parseDouble(textFieldHead.getText().toString());
			double convertedHead = headConvert.convert(head, comboBoxHeadUnit.getValue(), "psi");
			double fluidDensity = Double.parseDouble(textFieldFluidDensity.getText().toString());
			double pumpEfficiency = Double.parseDouble(textFieldPumpEfficiency.getText().toString());
			double motorEfficiency = Double.parseDouble(textFieldMotorEfficiency.getText().toString());
			
			PumpSize size = new PumpSize(convertedFlowRate, convertedHead, fluidDensity, pumpEfficiency, motorEfficiency);
			double motorSize = size.getMotorSize();
			double convertedMotorSize = powerConvert.convert(motorSize, comboBoxPowerUnits.getValue(), "hp");
			
			labelAnswer.setText(Double.toString(Math.round(convertedMotorSize * 100.0)/100.0));
			
		} catch (Exception e) {
			
		}
	}
	
	private void validateInput() {
		if (textFieldFlowRate.getText() == null || textFieldFlowRate.getText().isEmpty())
			throw new IllegalArgumentException();
		if (textFieldHead.getText() == null || textFieldHead.getText().isEmpty())
			throw new IllegalArgumentException();
	}
	
}
