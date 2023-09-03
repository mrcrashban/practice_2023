module com.example.practice {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.practice to javafx.fxml;
    exports com.example.practice;
    exports com.example.practice.fourth;
    opens com.example.practice.fourth to javafx.fxml;
    exports com.example.practice.third;
    opens com.example.practice.third to javafx.fxml;
    exports com.example.practice.second;
    opens com.example.practice.second to javafx.fxml;
    exports com.example.practice.first;
    opens com.example.practice.first to javafx.fxml;
}