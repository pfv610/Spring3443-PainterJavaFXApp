module edu.utsa.cs3443.spring2026painterapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.utsa.cs3443.spring2026painterapp to javafx.fxml;
    exports edu.utsa.cs3443.spring2026painterapp;
}