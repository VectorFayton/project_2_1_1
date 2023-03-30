package project2;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegistrationMenu {

    @FXML
    private Button sign_up_button;
    @FXML
    private TextField username_text_field;

    @FXML
    private PasswordField new_password_field;

    @FXML
    private RadioButton male_radio_button;
    @FXML
    private RadioButton female_radio_button;
    @FXML
    private RadioButton other_radio_button;
    @FXML
    private TextField email_text_field;
    @FXML
    private Label username_error_message_label;
    @FXML
    private Label password_error_message_label;
    @FXML
    private Label gender_error_message_label;
    @FXML
    private Label email_error_message_label;
    private static int max_length = 9;

    @FXML
    protected void onSignUpButtonClick(){
        FileCreate file_create = new FileCreate();
        file_create.setUsername(username_text_field.getText());
        if (username_text_field.getText().equals("")) {
            username_error_message_label.setText("username is empty");
        } else if(new_password_field.getText().equals("")) {
            password_error_message_label.setText("password is empty");
        } else if(!(male_radio_button.isSelected() || female_radio_button.isSelected() || other_radio_button.isSelected())) {
            gender_error_message_label.setText("choose one from the list");
        } else if(email_text_field.getText().equals("")){
            email_error_message_label.setText("email is empty");
        } else if(new_password_field.getText().equals(username_text_field.getText()) || username_error_message_label.equals(new_password_field.getText())){
            username_error_message_label.setText("username and password is same");
            password_error_message_label.setText("username and password is same");
        } else if(file_create.checkData(username_text_field.getText(),"", 1)) {
            username_error_message_label.setText("account with this username has created");
        } else {
            FileCreate.addData(username_text_field.getText(), new_password_field.getText(), email_text_field.getText(), "Users");
            email_text_field.getScene().getWindow().hide();
            LoginMenu.OpenScene("NewsMenuBar");
        }
    }
    //
    @FXML
    protected void onLoginLabelButtonClick(){
        sign_up_button.getScene().getWindow().hide();
        LoginMenu.OpenScene("LoginMenu");
    }
    @FXML
    protected void onFemaleRadioButtonClick(){
        Genders();
    }

    @FXML
    protected void onMaleRadioButtonClick(){
        Genders();
    }
    @FXML
    protected void onOtherRadioButtonClick(){
        Genders();
    }

    @FXML
    protected void onUsernameTextFieldAction(){
        if (username_text_field.getText().length() > max_length){
            String limitation = username_text_field.getText().substring(0, max_length);
            username_text_field.setText(limitation);
        }
    }
    @FXML
    protected void onPasswordFieldAction() {
        if (new_password_field.getText().length() > max_length) {
            String limitation = new_password_field.getText().substring(0, max_length);
            new_password_field.setText(limitation);
        }
    }

    private void Genders(){
        ToggleGroup gender_toggle_group = new ToggleGroup();
        female_radio_button.setToggleGroup(gender_toggle_group);
        male_radio_button.setToggleGroup(gender_toggle_group);
        other_radio_button.setToggleGroup(gender_toggle_group);
    }
}
