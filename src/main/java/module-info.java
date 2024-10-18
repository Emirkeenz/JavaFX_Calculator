module org.example.javafx_calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javafx_calculator to javafx.fxml;
    exports org.example.javafx_calculator;
}