package myApp;

import javafx.fxml.FXML;
import conversion.Converter;
import conversion.HeadConverter;
import conversion.LengthConverter;
import javafx.event.ActionEvent;

public class chooseUnitsController implements BaseController{
	private Main main;
	private String[] units;
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML
	private void switchMain(ActionEvent event) {
		main.showScene("Main.fxml", "My Tools", mainController.class);
	}
	
	@FXML
	private void switchLength(ActionEvent event) {
		Converter unitToConvert = new LengthConverter();
		units = unitToConvert.units;
		ConvertController.setUnitConverter(new LengthConverter());
		ConvertController.setComboBoxContent(units);
		ConvertController.changeLabel("Length");
		main.showScene("Convert.fxml", "Length", ConvertController.class);
	}
	
	@FXML
	private void switchHead(ActionEvent event) {
		Converter unitToConvert = new HeadConverter();
		units = unitToConvert.units;
		ConvertController.setUnitConverter(new HeadConverter());
		ConvertController.setComboBoxContent(units);
		ConvertController.changeLabel("Head");
		main.showScene("Convert.fxml", "Head", ConvertController.class);
	}
}
