module com.mycompany.seminario {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires lombok;
    requires jasperreports;
    requires java.persistence;


    opens com.mycompany.seminario to javafx.fxml;
    exports com.mycompany.seminario;
}
