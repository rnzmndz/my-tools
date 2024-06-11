package myApp;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

public class chooseUnitsController implements BaseController{
	private Main main;
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML
	private void switchMain(ActionEvent event) {
		main.showScene("Main.fxml", "My Tools", mainController.class);
	}
	
	@FXML
	private void switchLength(ActionEvent event) {
		String[] units = {"meter", "kilometer", "centimeter", "millimeter", "micrometer", "nanometer", "inch", "foot", "yard", "miles", "nautical_miles"};
		ConvertController.setComboBoxContent(units);
		ConvertController.changeLabel("Length");
		main.showScene("Convert.fxml", "Length", ConvertController.class);
	}
}
