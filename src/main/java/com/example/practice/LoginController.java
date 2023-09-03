package com.example.practice;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button old_version;

    @FXML
    private Button popular_scenes;

    @FXML
    private Button user_actions;

    @FXML
    private Button users_list;

    @FXML
    void initialize(){
        user_actions.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("UserActions_view.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Мониторинг использования");
            stage.setScene(new Scene(parent, 672, 434));
            stage.showAndWait();
        });
        users_list.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("UsersList_view.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Мониторинг использования");
            stage.setScene(new Scene(parent, 672, 434));
            stage.showAndWait();
        });
        popular_scenes.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("TopVisited_view.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Мониторинг использования");
            stage.setScene(new Scene(parent, 672, 434));
            stage.showAndWait();
        });
        old_version.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Oldversion_view.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Мониторинг использования");
            stage.setScene(new Scene(parent, 672, 434));
            stage.showAndWait();
        });
    }
}

