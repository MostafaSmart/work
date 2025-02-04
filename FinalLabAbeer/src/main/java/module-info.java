module com.example.finallababeer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finallababeer to javafx.fxml;
    exports com.example.finallababeer;
}