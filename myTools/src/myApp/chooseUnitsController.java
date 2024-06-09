package myApp;

import javafx.fxml.FXML;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.event.ActionEvent;

public class chooseUnitsController implements BaseController{
	private Main main;
	private List<String> comboBoxContents = new ArrayList<String>();
	
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
		main.showScene("Convert.fxml", "Length", ConvertController.class);
		comboBoxContents.clear();
		Collections.addAll(comboBoxContents, units);
		ConvertController.set
	}
}
