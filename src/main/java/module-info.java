module com.pooespol.appmillionarie {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.pooespol.appmillionarie to javafx.fxml;
    opens com.pooespol.appmillionarie.modelo to javafx.base;
    exports com.pooespol.appmillionarie;
}