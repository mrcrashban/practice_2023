package com.example.practice.third;

import com.example.practice.fourth.Devices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class GetScreensTop {
    public static Connection ConnectDB() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practice_2023", "postgres", "19022002");
            System.out.println("ready");
            return connection;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static ObservableList<TopVisitedScreens> topVisitedScreens (String start_date, String finish_date) {
        Connection connection = ConnectDB();
        ObservableList<TopVisitedScreens> list = FXCollections.observableArrayList();
        try {
            PreparedStatement get_top_Screens = connection.prepareStatement("SELECT screenname, count(*) as views from statistics_logs where screenname != '\\N' and dt between '"  + start_date + "' and '"  + finish_date + "' group by screenname order by views desc LIMIT 10");
            ResultSet screens_list = get_top_Screens.executeQuery();

            while (screens_list.next()) {
                list.add(new TopVisitedScreens(screens_list.getString("screenname"), screens_list.getInt("views")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
