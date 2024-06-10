package myApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import conversion.LengthConverter;
import javafx.event.ActionEvent;

public class ConvertController implements BaseController, Initializable{
	static List<String> comboBoxContents = new ArrayList<String>();
	private Main main;
	
	@FXML
	ComboBox<String> comboBoxUnits1;
	
	@FXML
	ComboBox<String> comboBoxUnits2;
	
	@FXML
	TextField textField1;
	
	@FXML
	TextField textField2;
	
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
	
	@FXML
	public void calculateTextField1() {
		double textFieldValue1 = Double.parseDouble(textField1.getText());
		String unitToConvert = comboBoxUnits1.getValue();
		String unitResult = comboBoxUnits2.getValue();
		double convert = new LengthConverter().convert(textFieldValue1, unitToConvert.toUpperCase(), unitResult.toUpperCase());
		System.out.println(convert);
//		textField2.setPromptText(convert);
	}
}
