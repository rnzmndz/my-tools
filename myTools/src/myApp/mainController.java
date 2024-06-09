package myApp;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

public class mainController implements BaseController{
	private Main main;
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML
	private void switchConversion(ActionEvent event) {
		main.showScene("ChooseUnits.fxml", "Conversion", chooseUnitsController.class);
	}
}
