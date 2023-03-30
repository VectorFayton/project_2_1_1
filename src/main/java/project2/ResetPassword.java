package project2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ResetPassword {
    @FXML
    private Button safe_changes_button;
    @FXML
    private TextField username_text_field;
    @FXML
    private PasswordField password_field;
    @FXML
    private Label password_error_message_label;
    @FXML
    private Label username_error_message_label;
    @FXML
    private Label sign_in_label;
    private int max_length = 9;

    @FXML
    protected void onSafeChangesButtonClick() throws IOException {
        FileCreate file_create = new FileCreate();
        file_create.setUsername(username_text_field.getText());
        if (username_text_field.getText().equals("")) {
            username_error_message_label.setText("username is empty");
        } else if (password_field.getText().equals("")) {
            password_error_message_label.setText("password is empty");
        } else if (password_field.getText().equals(username_text_field.getText()) || username_text_field.equals(password_field.getText())) {
            username_error_message_label.setText("username and password is same");
            password_error_message_label.setText("username and password is same");
        } else if(!file_create.checkData(username_text_field.getText(), "", 1, "Users")) {
            username_error_message_label.setText("username is not exist");
        } else{
            FileCreate.resetPassword(username_text_field.getText(), password_field.getText(), "Users");
            safe_changes_button.getScene().getWindow().hide();
            LoginMenu.OpenScene("LoginMenu");
        }
    }
    @FXML
    protected void onSignInButtonLabelClick(){
        password_field.getScene().getWindow().hide();
        LoginMenu.OpenScene("LoginMenu");
    }
    @FXML
    protected void onUsernameTextFieldAction(){
        if (username_text_field.getText().length() > max_length){
            String limitation = username_text_field.getText().substring(0, max_length);
            username_text_field.setText(limitation);
        }
    }
    @FXML
    protected void onPasswordFieldAction(){
        if (password_field.getText().length() > max_length){
            String limitation = password_field.getText().substring(0, max_length);
            password_field.setText(limitation);
        }
    }
    public void setLabel(String text){
        username_error_message_label.setText(text);
    }

    public ResetPassword(){
    }
}
