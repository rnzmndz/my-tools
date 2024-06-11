package myApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import conversion.LengthConverter;
import javafx.event.ActionEvent;

public class ConvertController implements BaseController, Initializable{
	private static List<String> comboBoxContents = new ArrayList<String>();
	private Main main;
	
	@FXML
	ComboBox<String> comboBoxUnits1;
	
	@FXML
	ComboBox<String> comboBoxUnits2;
	
	@FXML
	TextField textField1;
	
	@FXML
	TextField textField2;
	
	@FXML
	static
	Label labelConvert;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		comboBoxUnits1.getItems().addAll("Initial Item 1", "Initial Item 2", "Initial Item 3");
		comboBoxUnits2.getItems().addAll("Initial Item 1", "Initial Item 2", "Initial Item 3");
	}
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML
	private void switchMain(ActionEvent event) {
		main.showScene("Main.fxml", "My Tools", mainController.class);
	}
	
	@FXML
	private void switchConversion(ActionEvent event) {
		main.showScene("ChooseUnits.fxml", "Conversion", chooseUnitsController.class);
	}
	
	@FXML
	public void changeComboBoxContent1() {
		comboBoxUnits1.getItems().clear();
		comboBoxUnits1.getItems().addAll(ConvertController.comboBoxContents);
	}
	
	@FXML
	public void changeComboBoxContent2() {
		comboBoxUnits2.getItems().clear();
		comboBoxUnits2.getItems().addAll(ConvertController.comboBoxContents);
	}
	
	public static void setComboBoxContent(String[] content) {
		comboBoxContents.clear();
		Collections.addAll(comboBoxContents, content);
	}
	
	public static void changeLabel(String name) {
		labelConvert.setText(name);
	}
	
	@FXML
	public void calculateTextField1() {
		double textFieldValue1 = Double.parseDouble(textField1.getText());
		String unitToConvert = comboBoxUnits1.getValue();
		String unitResult = comboBoxUnits2.getValue();
		double convert = new LengthConverter().convert(textFieldValue1, unitToConvert.toUpperCase(), unitResult.toUpperCase());
		textField2.setText(Double.toString(convert));
	}
	
	@FXML
	public void calculateTextField2() {
		double textFieldValue2 = Double.parseDouble(textField2.getText());
		String unitToConvert = comboBoxUnits2.getValue();
		String unitResult = comboBoxUnits1.getValue();
		double convert = new LengthConverter().convert(textFieldValue2, unitToConvert.toUpperCase(), unitResult.toUpperCase());
		textField1.setText(Double.toString(convert));
	}
}
