package com.zabaronak.bullsandcows.service.impl;

import com.zabaronak.bullsandcows.service.ShowWindowsService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;

public class ShowWindowService implements ShowWindowsService {

    @Override
    public void showWindow(String url, String name) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(url));
            stage.setTitle(name);
            stage.setScene(new Scene(root, 579, 544));
            stage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Can not open window :\n" +e.getMessage());

            alert.showAndWait();
        }
    }

    @Override
    public void closeWindow(Node node) {
        Stage stage = (Stage)node.getScene().getWindow();
        stage.close();
    }

}
