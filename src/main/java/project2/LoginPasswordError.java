package project2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LoginPasswordError {

    @FXML
    private Button close_button;

    @FXML
    private static Label error_message_label;

    @FXML
    protected void onCloseButtonClick(){
        close_button.getScene().getWindow().hide();
    }

//    public static void errorMessage(String message){
//        error_message_label.setText(message);
//    }

}
