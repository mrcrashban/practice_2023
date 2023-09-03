package com.example.practice.fourth;

import com.example.practice.fourth.Devices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class GetDevices {
    Connection connection = null;
    public static Connection ConnectDB() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practice_2023", "postgres", "19022002");
            System.out.println("ready");
            return connection;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static ObservableList<Devices> oldDevicesList (String version) {
        Connection connection = ConnectDB();
        ObservableList<Devices> list = FXCollections.observableArrayList();
        try {
            PreparedStatement get_old_devices = connection.prepareStatement(
                    "select * from tbl_devices where string_to_array(tbl_devices.versionapp, '.') " +
                            "< string_to_array('" + version + "','.')");
            ResultSet devices_list = get_old_devices.executeQuery();

            while (devices_list.next()) {
                list.add(new Devices(devices_list.getString("UDID"), devices_list.getString("Name"),
                        devices_list.getString("Model"), devices_list.getString("SystemName"),
                        devices_list.getString("DeviceModel"), devices_list.getString("DeviceVersion"),
                        devices_list.getString("PhysicalMemory"), devices_list.getString("versionapp")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static ObservableList<Devices> devicesList () {
        Connection connection = ConnectDB();
        ObservableList<Devices> list = FXCollections.observableArrayList();
        try {
            PreparedStatement get_old_devices = connection.prepareStatement("select * from devices");
            ResultSet devices_list = get_old_devices.executeQuery();

            while (devices_list.next()) {
                list.add(new Devices(devices_list.getString("UDID"), devices_list.getString("Name"),
                        devices_list.getString("Model"), devices_list.getString("SystemName"),
                        devices_list.getString("DeviceModel"), devices_list.getString("DeviceVersion"),
                        devices_list.getString("PhysicalMemory"), devices_list.getString("versionapp")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
