package com.example.practice.first;

import com.example.practice.second.Device;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class UserActionsController implements Initializable {

    @FXML
    private TableColumn<Actions, String> action_id;

    @FXML
    private Button recieve_button_device;

    @FXML
    private Button recieve_button_login;

    @FXML
    private TableView<Actions> actions_table;

    @FXML
    private TableColumn<Actions, String> description;

    @FXML
    private TableColumn<Actions, String> device_id;

    @FXML
    private ComboBox<Device> device_name;

    @FXML
    private TableColumn<Actions, String> dt;

    @FXML
    private DatePicker finish_date;

    @FXML
    private ComboBox<Device> login_choice;

    @FXML
    private DatePicker start_date;

    @FXML
    private TableColumn<Actions, String> user_id;

    @FXML
    private TableColumn<Actions, String> versionapp;

    ObservableList<Device> listD;
    ObservableList<Device> listU;
    ObservableList<Actions> listA;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listD = FirstHelper.getdevicesnames();
        listU = FirstHelper.getusersnames();
        device_name.setItems(listD);
        login_choice.setItems(listU);
        recieve_button_login.setOnAction(actionEvent -> {
            print_login_actions();
        });
        recieve_button_device.setOnAction(actionEvent -> {
            print_device_actions();
        });
    }

    void print_login_actions(){
        String first = start_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String second = finish_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String login = login_choice.getValue().toString();
        action_id.setCellValueFactory(new PropertyValueFactory<Actions, String>("action_id"));
        user_id.setCellValueFactory(new PropertyValueFactory<Actions, String>("user_id"));
        description.setCellValueFactory(new PropertyValueFactory<Actions, String>("description"));
        device_id.setCellValueFactory(new PropertyValueFactory<Actions, String>("device_id"));
        dt.setCellValueFactory(new PropertyValueFactory<Actions, String>("date"));
        versionapp.setCellValueFactory(new PropertyValueFactory<Actions, String>("version"));
        listA = FirstHelper.getActionsLogin(first,second,login);
        actions_table.setItems(listA);
    }

    void print_device_actions(){
        String first = start_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String second = finish_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String login = login_choice.getValue().toString();
        action_id.setCellValueFactory(new PropertyValueFactory<Actions, String>("action_id"));
        user_id.setCellValueFactory(new PropertyValueFactory<Actions, String>("user_id"));
        description.setCellValueFactory(new PropertyValueFactory<Actions, String>("description"));
        device_id.setCellValueFactory(new PropertyValueFactory<Actions, String>("device_id"));
        dt.setCellValueFactory(new PropertyValueFactory<Actions, String>("date"));
        versionapp.setCellValueFactory(new PropertyValueFactory<Actions, String>("version"));
        listA = FirstHelper.getActionsDevice(first,second,login);
        actions_table.setItems(listA);
    }
}
