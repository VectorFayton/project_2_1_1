package project2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.SortedMap;

import static project2.LoginMenu.OpenScene;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FileCreate fileCreate = new FileCreate();

        if (fileCreate.logic()) {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("NewsMenuBar.fxml"));
            loader.load();
            NewsMenuBar newsMenuBar = loader.getController();
            newsMenuBar.initialize(fileCreate.getMembers(1), fileCreate.getMembers(2));
            Parent root = loader.getRoot();
            stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 822, 518);
            stage.setTitle("News");
            stage.setScene(scene);
            stage.show();
        }
    }
    public static void main (String[]args){
        launch();
    }
}