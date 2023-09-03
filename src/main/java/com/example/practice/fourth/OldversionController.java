package com.example.practice.fourth;

import com.example.practice.fourth.Devices;
import com.example.practice.fourth.GetDevices;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class OldversionController implements Initializable {

    @FXML
    private TableView<Devices> devices_table;

    @FXML
    private TableColumn<Devices, String> device_memory;

    @FXML
    private TableColumn<Devices, String> device_model;

    @FXML
    private TableColumn<Devices, String> device_name;

    @FXML
    private TableColumn<Devices, String> device_udid;

    @FXML
    private TableColumn<Devices, String> device_version;

    @FXML
    private TableColumn<Devices, String> devicemodel2;

    @FXML
    private TextField old_version;

    @FXML
    private TableColumn<Devices, String> systemname;

    @FXML
    private TableColumn<Devices, String> versionapp;

    @FXML
    private Button search_button;

    ObservableList<Devices> listD;
    ObservableList<Devices> listO;

    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement pst = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        all_devices();
        search_button.setOnAction(actionEvent -> {
            search_devices();
        });
    }

    @FXML
    void all_devices() {
        device_udid.setCellValueFactory(new PropertyValueFactory<Devices, String>("udid"));
        device_name.setCellValueFactory(new PropertyValueFactory<Devices, String>("name"));
        device_model.setCellValueFactory(new PropertyValueFactory<Devices, String>("model"));
        systemname.setCellValueFactory(new PropertyValueFactory<Devices, String>("systemname"));
        devicemodel2.setCellValueFactory(new PropertyValueFactory<Devices, String>("devicemodel"));
        device_version.setCellValueFactory(new PropertyValueFactory<Devices, String>("deviceversion"));
        device_memory.setCellValueFactory(new PropertyValueFactory<Devices, String>("physicalmemory"));
        versionapp.setCellValueFactory(new PropertyValueFactory<Devices, String>("versionapp"));
        listD = GetDevices.devicesList();
        devices_table.setItems(listD);
        System.out.println("Work");
    }
    @FXML
    void search_devices() {
        String version = old_version.getText();
        device_udid.setCellValueFactory(new PropertyValueFactory<Devices, String>("udid"));
        device_name.setCellValueFactory(new PropertyValueFactory<Devices, String>("name"));
        device_model.setCellValueFactory(new PropertyValueFactory<Devices, String>("model"));
        systemname.setCellValueFactory(new PropertyValueFactory<Devices, String>("systemname"));
        devicemodel2.setCellValueFactory(new PropertyValueFactory<Devices, String>("devicemodel"));
        device_version.setCellValueFactory(new PropertyValueFactory<Devices, String>("deviceversion"));
        device_memory.setCellValueFactory(new PropertyValueFactory<Devices, String>("physicalmemory"));
        versionapp.setCellValueFactory(new PropertyValueFactory<Devices, String>("versionapp"));
        listO = GetDevices.oldDevicesList(version);
        devices_table.setItems(listO);
        System.out.println("ura!");
    }
}
