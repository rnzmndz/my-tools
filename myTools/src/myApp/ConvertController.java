package myApp;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.util.List;

import javafx.event.ActionEvent;

public class ConvertController implements BaseController{
	private Main main;
	
	@FXML
	ComboBox<String> comboBoxUnits1;
	
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
	public void setComboBoxContent(List<String> content) {
		comboBoxUnits1.getItems().addAll(content);
	}
}
