package com.example.practice.second;

import com.example.practice.third.TopVisitedScreens;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class GetInfo {
    public static Connection ConnectDB() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practice_2023", "postgres", "19022002");
            System.out.println("ready");
            return connection;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static ObservableList<Device> device () {
        Connection connection = ConnectDB();
        ObservableList<Device> list = FXCollections.observableArrayList();
        try {
            PreparedStatement get_devices_list = connection.prepareStatement("select distinct screenname from statistics_logs where screenname != '\\N'");
            ResultSet devices_list = get_devices_list.executeQuery();

            while (devices_list.next()) {
                list.add(new Device(devices_list.getString("screenname")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ObservableList<User> getUsers (String start_date, String finish_date, String screen_name) {
        Connection connection = ConnectDB();
        ObservableList<User> list = FXCollections.observableArrayList();
        try {
            PreparedStatement get_users = connection.prepareStatement("SELECT DISTINCT accountname FROM users, " +
                    "statistics_logs WHERE users.id = statistics_logs.userid and screenname = '" + screen_name +
                    "' and dt between '" + start_date + "' and '" + finish_date + "'");
            ResultSet users_list = get_users.executeQuery();

            while (users_list.next()) {
                list.add(new User(users_list.getString("accountname")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
