package myApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

public class ConvertController implements BaseController, Initializable{
	static List<String> comboBoxContents = new ArrayList<String>();
	private Main main;
	
	@FXML
	ComboBox<String> comboBoxUnits1;
	
	@FXML
	ComboBox<String> comboBoxUnits2;
	
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
	public void changeComboBoxContent() {
		comboBoxUnits1.getItems().clear();
		comboBoxUnits1.getItems().addAll(ConvertController.comboBoxContents);
		comboBoxUnits2.getItems().clear();
		comboBoxUnits2.getItems().addAll(ConvertController.comboBoxContents);
	}
	
	public static void setComboBoxContent(String[] content) {
		comboBoxContents.clear();
		Collections.addAll(comboBoxContents, content);
	}
}
