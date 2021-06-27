package com.zabaronak.bullsandcows.widget;

import java.net.URL;
import java.util.ResourceBundle;

import com.zabaronak.bullsandcows.service.ShowWindowsService;
import com.zabaronak.bullsandcows.service.impl.ShowWindowService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RegulationsWidget {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonMainMenu;

    private ShowWindowsService showWindowsService;

    @FXML
    void initialize() {
    showWindowsService = new ShowWindowService();
    }

    @FXML
    void mainMenuOn(ActionEvent event) {
        showWindowsService.showWindow("com/zabaronak/bullsandcows/widget/menuwidget.fxml","Bulls and Cows");
        showWindowsService.closeWindow(buttonMainMenu);
    }
}
