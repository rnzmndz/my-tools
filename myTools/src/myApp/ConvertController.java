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

import conversion.Converter;
import javafx.event.ActionEvent;

public class ConvertController implements BaseController, Initializable{
	private static List<String> comboBoxContents = new ArrayList<String>();
	private Main main;
	private static String labelname;
	private static Converter unitConverter;
	
	@FXML
	private ComboBox<String> comboBoxUnits1;
	
	@FXML
	private ComboBox<String> comboBoxUnits2;
	
	@FXML
	private TextField textField1;
	
	@FXML
	private TextField textField2;
	
	@FXML
	private Label labelConvert;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		comboBoxUnits1.setValue(comboBoxContents.get(0));
		comboBoxUnits2.setValue(comboBoxContents.get(0));
	}
	
	public void setMain(Main main) {
		this.main = main;
		labelConvert.setText(labelname);
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
		labelname = name;
	}
	
	@FXML
	public void calculateTextField1() {
		 try {
	            validateInputs(textField1);
	            double textFieldValue1 = Double.parseDouble(textField1.getText());
	            String unitToConvert = comboBoxUnits1.getValue();
	            String unitResult = comboBoxUnits2.getValue();
	            double convert = unitConverter.convert(textFieldValue1, unitToConvert, unitResult);
	            textField2.setText(Double.toString(convert));
	        } catch (IllegalArgumentException e) {
	            textField2.setText("Select Units");
	        } catch (Exception e) {
	            e.printStackTrace();
	            textField2.setText("Error occurred");
	        }
	    }
	
	@FXML
	public void calculateTextField2() {
		try {
            validateInputs(textField1);
            double textFieldValue2 = Double.parseDouble(textField2.getText());
    		String unitToConvert = comboBoxUnits2.getValue();
    		String unitResult = comboBoxUnits1.getValue();
    		double convert = unitConverter.convert(textFieldValue2, unitToConvert.toUpperCase(), unitResult.toUpperCase());
    		textField1.setText(Double.toString(convert));
        } catch (IllegalArgumentException e) {
            textField1.setText("Select Units");
        } catch (Exception e) {
            e.printStackTrace();
            textField1.setText("Error occurred");
        }
	}
	
	public void validateInputs(TextField textField) {
		if (comboBoxUnits1.getValue() == null || comboBoxUnits1.getValue().isEmpty())
			throw new IllegalArgumentException("Cb 1 is empty");
		if (comboBoxUnits2.getValue() == null || comboBoxUnits2.getValue().isEmpty())
			throw new IllegalArgumentException("Cb 2 is empty");
	}
	
	public static void setUnitConverter(Converter converter) {
		unitConverter = converter;
	}
}
