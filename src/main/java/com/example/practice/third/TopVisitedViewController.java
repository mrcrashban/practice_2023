package com.example.practice.third;

import com.example.practice.fourth.GetDevices;
import com.example.practice.third.TopVisitedScreens;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class TopVisitedViewController implements Initializable {

    @FXML
    private DatePicker finish_date;

    @FXML
    private Button find_button;

    @FXML
    private DatePicker start_date;

    @FXML
    private TableColumn<TopVisitedScreens, String> screenname;

    @FXML
    private TableView<TopVisitedScreens> topviews_table;

    @FXML
    private TableColumn<TopVisitedScreens, String> views_count;

    ObservableList<TopVisitedScreens> listS;

    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement pst = null;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        find_button.setOnAction(actionEvent -> {
            top_screens();
        });
    }

    @FXML
    void top_screens(){
        String first = start_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String second = finish_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        screenname.setCellValueFactory(new PropertyValueFactory<TopVisitedScreens, String>("screen_name"));
        views_count.setCellValueFactory(new PropertyValueFactory<TopVisitedScreens, String>("views"));
        listS = GetScreensTop.topVisitedScreens(first, second);
        topviews_table.setItems(listS);
        System.out.println("Work");
    }
}
