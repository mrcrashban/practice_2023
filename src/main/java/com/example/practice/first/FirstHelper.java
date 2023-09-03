package com.example.practice.first;

import com.example.practice.second.Device;
import com.example.practice.second.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class FirstHelper {
    public static Connection ConnectDB() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practice_2023", "postgres", "19022002");
            System.out.println("ready");
            return connection;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static ObservableList<Device> getdevicesnames () {
        Connection connection = ConnectDB();
        ObservableList<Device> list = FXCollections.observableArrayList();
        try {
            PreparedStatement get_devices_list = connection.prepareStatement("select distinct name from devices");
            ResultSet devices_list = get_devices_list.executeQuery();

            while (devices_list.next()) {
                list.add(new Device(devices_list.getString("name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ObservableList<Device> getusersnames () {
        Connection connection = ConnectDB();
        ObservableList<Device> list = FXCollections.observableArrayList();
        try {
            PreparedStatement get_devices_list = connection.prepareStatement("select distinct accountname from users");
            ResultSet devices_list = get_devices_list.executeQuery();

            while (devices_list.next()) {
                list.add(new Device(devices_list.getString("accountname")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ObservableList<Actions> getActionsLogin (String start_date, String finish_date, String login) {
        Connection connection = ConnectDB();
        ObservableList<Actions> list = FXCollections.observableArrayList();
        try {
            PreparedStatement get_actions = connection.prepareStatement("SELECT statistics_logs.guid,statistics_logs.userid,statistics_logs.dt,statistics_logs.action,statistics_logs.deviceid,statistics_logs.versionapp FROM statistics_logs, users WHERE users.accountname = '" + login + "' and users.id = statistics_logs.userid" +
                    " and statistics_logs.dt between '" + start_date + "' and '" + finish_date + "' order by dt");
            ResultSet actions_list = get_actions.executeQuery();

            while (actions_list.next()) {
                list.add(new Actions(actions_list.getString("guid"),actions_list.getString("userid"),actions_list.getString("dt"),
                        actions_list.getString("action"),actions_list.getString("deviceid"), actions_list.getString("versionapp")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ObservableList<Actions> getActionsDevice (String start_date, String finish_date, String device) {
        Connection connection = ConnectDB();
        ObservableList<Actions> list = FXCollections.observableArrayList();
        try {
            PreparedStatement get_actions = connection.prepareStatement("SELECT guid,userid,dt,action,deviceid,statistics_logs.versionapp FROM statistics_logs, devices WHERE devices.name = '" + device + "'  and devices.udid = statistics_logs.deviceid " +
                    "and statistics_logs.dt between '" + start_date + "' and '" + finish_date + "' order by dt");
            ResultSet actions_list = get_actions.executeQuery();

            while (actions_list.next()) {
                list.add(new Actions(actions_list.getString("guid"),actions_list.getString("userid"),actions_list.getString("dt"),
                        actions_list.getString("action"),actions_list.getString("deviceid"), actions_list.getString("versionapp")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
