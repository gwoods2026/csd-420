module org.example.module7 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.module7 to javafx.fxml;
    exports org.example.module7;
}