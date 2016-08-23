package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController {
	@FXML
	private Label lbl_Status;

	@FXML
	private TextField txt_Username;

	@FXML
	private TextField txt_Password;

	@FXML
	public void login(ActionEvent event) throws Exception {
		if (txt_Username.getText().equals("") && txt_Password.getText().equals("")) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("Form.fxml"));
				Stage stage = new Stage();
	            stage.initModality(Modality.APPLICATION_MODAL);
	            stage.initStyle(StageStyle.UNDECORATED);
				stage.setTitle("ABC");
				Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
				stage.setMaximized(true);
	            stage.setScene(new Scene(root));  
	            stage.show();
	            
	            Main.primaryStage.hide();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			lbl_Status.setText("Login Failed!");
		}

	}
}
