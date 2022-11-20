module com.example.personabeachpark {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.personabeachpark to javafx.fxml;
    exports com.example.personabeachpark;
}