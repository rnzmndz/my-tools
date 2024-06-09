package myApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage currentStage;
	
	@Override
	public void start(Stage currentStage) {
		this.currentStage = currentStage;
		showScene("Main.fxml", "My Tools", mainController.class);
	}
 
	public <T> void showScene(String fxmlFile, String title, Class<T> controllerClass) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            T controller = loader.getController();
            if (controller instanceof BaseController) {
                ((BaseController) controller).setMain(this);
            }

            currentStage.setScene(scene);
            currentStage.setTitle(title);
            currentStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
