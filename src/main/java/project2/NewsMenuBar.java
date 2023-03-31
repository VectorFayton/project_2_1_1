package project2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Effect;
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
    Label username_avatar_label;
    @FXML
    ImageView first_image;
    @FXML
    ImageView second_image;
    @FXML
    ImageView third_image;
    @FXML
    ImageView fourth_image;
    Image image;

    @FXML
    protected void onExitButtonClick(){
        user_avatar_label.getScene().getWindow().hide();
        LoginMenu.OpenScene("LoginMenu");
    }

    @FXML
    protected void onTechnologyButtonClick(){
        toggleButtonGroup(technology_button, sports_button, business_button, economy_button, 1);
        first_image.setImage(image = new Image("D:\\Работа\\Проект\\project_2_1\\src\\main\\resources\\project2\\Technology\\image1.jpg"));
        second_image.setImage(image = new Image("D:\\Работа\\Проект\\project_2_1\\src\\main\\resources\\project2\\Technology\\image2.jpg"));
        third_image.setImage(image = new Image("D:\\Работа\\Проект\\project_2_1\\src\\main\\resources\\project2\\Technology\\image3.jpg"));
        fourth_image.setImage(image = new Image("D:\\Работа\\Проект\\project_2_1\\src\\main\\resources\\project2\\Technology\\image4.jpg"));
    }
    @FXML
    protected void onSpotsButtonClick(){
        toggleButtonGroup(technology_button, sports_button, business_button, economy_button, 2);
        first_image.setImage(image = new Image("D:\\Работа\\Проект\\project_2_1\\src\\main\\resources\\project2\\Sports\\image1.jpg"));
        second_image.setImage(image = new Image("D:\\Работа\\Проект\\project_2_1\\src\\main\\resources\\project2\\Sports\\image2.jpg"));
        third_image.setImage(image = new Image("D:\\Работа\\Проект\\project_2_1\\src\\main\\resources\\project2\\Sports\\image3.jpeg"));
        fourth_image.setImage(image = new Image("D:\\Работа\\Проект\\project_2_1\\src\\main\\resources\\project2\\Sports\\image4.jpg"));
    }
    @FXML
    protected void onBusinessButtonClick(){
        toggleButtonGroup(technology_button, sports_button, business_button, economy_button, 3);
        first_image.setImage(image = new Image("D:\\Работа\\Проект\\project_2_1\\src\\main\\resources\\project2\\Business\\image1.jpg"));
        second_image.setImage(image = new Image("D:\\Работа\\Проект\\project_2_1\\src\\main\\resources\\project2\\Business\\image2.jpg"));
        third_image.setImage(image = new Image("D:\\Работа\\Проект\\project_2_1\\src\\main\\resources\\project2\\Business\\image3.jpg"));
        fourth_image.setImage(image = new Image("D:\\Работа\\Проект\\project_2_1\\src\\main\\resources\\project2\\Business\\image4.jpeg"));
    }
    @FXML
    protected void onEconomyButtonClick(){
        toggleButtonGroup(technology_button, sports_button, business_button, economy_button, 4);
        first_image.setImage(image = new Image("D:\\Работа\\Проект\\project_2_1\\src\\main\\resources\\project2\\Economy\\image1.jpg"));
        second_image.setImage(image = new Image("D:\\Работа\\Проект\\project_2_1\\src\\main\\resources\\project2\\Economy\\image2.png"));
        third_image.setImage(image = new Image("D:\\Работа\\Проект\\project_2_1\\src\\main\\resources\\project2\\StartNews\\economy.jpg"));
        fourth_image.setImage(image = new Image("D:\\Работа\\Проект\\project_2_1\\src\\main\\resources\\project2\\Economy\\image4.jpg"));
    }


    @FXML
    void initialize(String label, String username) {
        user_avatar_label.setText(label);
        username_avatar_label.setText(username);
    }
    public void toggleButtonGroup(Button first_button, Button second_button, Button third_button, Button fourth_button, int count){
        Bloom activated_bloom = new Bloom(0.65);
        Bloom diactivated_bloom = new Bloom(0);
        switch (count){
            case 1:
                first_button.setEffect(activated_bloom);
                second_button.setEffect(diactivated_bloom);
                third_button.setEffect(diactivated_bloom);
                fourth_button.setEffect(diactivated_bloom);
                break;
            case 2:
                first_button.setEffect(diactivated_bloom);
                second_button.setEffect(activated_bloom);
                third_button.setEffect(diactivated_bloom);
                fourth_button.setEffect(diactivated_bloom);
                break;
            case 3:
                first_button.setEffect(diactivated_bloom);
                second_button.setEffect(diactivated_bloom);
                third_button.setEffect(activated_bloom);
                fourth_button.setEffect(diactivated_bloom);
                break;
            case 4:
                first_button.setEffect(diactivated_bloom);
                second_button.setEffect(diactivated_bloom);
                third_button.setEffect(diactivated_bloom);
                fourth_button.setEffect(activated_bloom);
                break;
        }
    }

    public NewsMenuBar() {
    }



}
