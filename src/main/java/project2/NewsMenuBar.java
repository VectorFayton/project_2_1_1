package project2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NewsMenuBar {
    @FXML
    Label user_avatar_label;
    @FXML
    Button technology_button;
    @FXML
    Button sports_button;
    @FXML
    Button business_button;
    @FXML
    Button economy_button;
    @FXML
    ImageView exit_image_button;

    @FXML
    protected void onExitButtonClick(){
        user_avatar_label.getScene().getWindow().hide();
        LoginMenu.OpenScene("LoginMenu");
    }
    @FXML
    void initialize(String label) {
        user_avatar_label.setText(label);
    }
    public NewsMenuBar() {
    }



}
