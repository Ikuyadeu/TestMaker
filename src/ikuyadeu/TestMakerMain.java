package ikuyadeu;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class TestMakerMain extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("window.fxml"));
		Scene scene = new Scene(root,750,750);
		stage.setScene(scene);
		stage.setTitle("てすとめーかー");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
