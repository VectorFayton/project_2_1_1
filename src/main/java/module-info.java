module com.example.project_2_0 {
    requires javafx.controls;
    requires javafx.fxml;


    opens project2 to javafx.fxml;
    exports project2;
}