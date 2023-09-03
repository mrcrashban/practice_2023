package com.example.practice.second;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class UsersListViewController implements Initializable {

    @FXML
    private TableColumn<User, String> account_name;

    @FXML
    private TableView<User> accounts_table;

    @FXML
    private DatePicker finish_date;

    @FXML
    private ComboBox<Device> screen_choice;

    @FXML
    private DatePicker start_date;

    @FXML
    private Button search_button;

    ObservableList<Device> listD;
    ObservableList<User> listU;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listD = GetInfo.device();
        screen_choice.setItems(listD);
        search_button.setOnAction(actionEvent -> {
            print_users();
        });
    }

    void print_users() {
        String first = start_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String second = finish_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String screenname = screen_choice.getValue().toString();
        account_name.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        listU = GetInfo.getUsers(first,second,screenname);
        accounts_table.setItems(listU);
    }
}
