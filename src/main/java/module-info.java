module com.example.mdtracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.mdtracker to javafx.fxml;
    exports com.example.mdtracker;
}