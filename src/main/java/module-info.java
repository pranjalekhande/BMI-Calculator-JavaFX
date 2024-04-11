module com.example.bmicalulator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bmicalulator to javafx.fxml;
    exports com.example.bmicalulator;
}