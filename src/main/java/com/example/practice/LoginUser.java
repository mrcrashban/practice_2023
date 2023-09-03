package com.example.practice;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginUser {

    @FXML
    private Button login_Button;

    @FXML
    private TextField login_Input;

    @FXML
    private PasswordField password_Input;


    @FXML
    void initialize(){
        login_Button.setOnAction(actionEvent -> {
           String login = login_Input.getText().trim();
           String password = password_Input.getText().trim();
           if (!login.equals("") && !password.equals("")){
               try {
                   loginUser(login,password);
               } catch (SQLException e) {
                   throw new RuntimeException(e);
               }
           }
        });
    }

    private void loginUser(String login, String password) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practice_2023", "postgres", "19022002");
        Statement statement = connection.createStatement();
        ResultSet resultUser = statement.executeQuery("select * from confrimed_users where login=\'" + login + '\'');
        try {
            resultUser.next();
            String recieved_password = resultUser.getString(2);
            if (recieved_password.equals(password)) {
                login_Button.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Main_view.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Parent parent = loader.getRoot();
                Stage stage = new Stage();
                stage.setTitle("Мониторинг использования");
                stage.setScene(new Scene(parent, 700, 500));
                stage.showAndWait();
            }
        }   catch (Exception e){
            System.out.println("No user");
        }
        System.out.println("Ky");
        System.out.println(login);
        System.out.println(password);
    }
}
