module com.example.finalfinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finalfinal to javafx.fxml;
    exports com.example.finalfinal;
}