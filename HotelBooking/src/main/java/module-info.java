module com.company.hotelbooking {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;
//    requires java;
    
    opens com.company.hotelbooking to javafx.fxml;
    exports com.company.hotelbooking;
}
