package com.zabaronak.bullsandcows.widget;

import java.net.URL;
import java.util.ResourceBundle;
import com.zabaronak.bullsandcows.service.ShowWindowsService;
import com.zabaronak.bullsandcows.service.impl.ShowWindowService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuWidget {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonStart;

    @FXML
    private Button buttonRegulations;

    private ShowWindowsService showWindowsService;

    @FXML
    void initialize() {
    showWindowsService = new ShowWindowService();
    }


    @FXML
    void regulationsOn(ActionEvent event) {
    showWindowsService.showWindow("com/zabaronak/bullsandcows/widget/regulationswidget.fxml","Regulations");
    showWindowsService.closeWindow(buttonStart);
    }

    @FXML
    void startOn(ActionEvent event) {
        showWindowsService.showWindow("com/zabaronak/bullsandcows/widget/gamewidget.fxml","Bulls and Cows");
        showWindowsService.closeWindow(buttonStart);
    }
}
