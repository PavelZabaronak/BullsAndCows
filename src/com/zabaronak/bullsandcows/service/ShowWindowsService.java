package com.zabaronak.bullsandcows.service;

import javafx.scene.Node;
import javafx.stage.Stage;

public interface ShowWindowsService {

    void showWindow(String url, String name);
    void closeWindow(Node node);
}
