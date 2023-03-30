package project2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FileCreate file_create = new FileCreate();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginMenu.fxml"));
        if(file_create.logic()){
            fxmlLoader = new FXMLLoader(Main.class.getResource("NewsMenuBar.fxml"));
        }
        Scene scene = new Scene(fxmlLoader.load(), 822, 518);
        stage.setTitle("News");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}