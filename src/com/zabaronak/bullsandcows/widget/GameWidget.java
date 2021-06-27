package com.zabaronak.bullsandcows.widget;

import com.zabaronak.bullsandcows.exception.ValidException;
import com.zabaronak.bullsandcows.service.GameService;
import com.zabaronak.bullsandcows.service.MessageService;
import com.zabaronak.bullsandcows.service.ShowWindowsService;
import com.zabaronak.bullsandcows.service.impl.GameServiceImp;
import com.zabaronak.bullsandcows.service.impl.MessageServiceImp;
import com.zabaronak.bullsandcows.service.impl.ShowWindowService;
import com.zabaronak.bullsandcows.validator.NumberValidator;
import com.zabaronak.bullsandcows.validator.impl.NumberValidatorImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GameWidget {

    @FXML
    private Button buttonMainMenu;

    @FXML
    private TextField input;

    @FXML
    private Button runButton;

    @FXML
    private TextArea resultOutput;

    private ShowWindowsService showWindowsService;

    private GameService gameService;

    private MessageService messageService;

    private NumberValidator validator;

    private int counter=0;

    @FXML
    void initialize() {
        showWindowsService = new ShowWindowService();
        gameService = new GameServiceImp();
        gameService.generationNumber();
        messageService = new MessageServiceImp();
        validator = new NumberValidatorImpl();
    }

    @FXML
    void mainMenuOn(ActionEvent event) {
        showWindowsService.showWindow("com/zabaronak/bullsandcows/widget/menuwidget.fxml", "Bulls and Cows");
        showWindowsService.closeWindow(buttonMainMenu);
    }

    @FXML
    void runOn(ActionEvent event) {
        counter++;
        String number = input.getText();
        try {
            validator.numberValid(number);
            if (gameService.checkNumber(number)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Win");
                alert.setHeaderText(null);
                alert.setContentText("Ты победил молодец!\nКоличество попыток: "+counter);
                alert.showAndWait();
            } else {

                String newMessage = messageService.generationMessage(
                        gameService.counterCows(number),
                        gameService.counterBulls(number));
                String oldMessage = resultOutput.getText();
                resultOutput.setText(oldMessage + newMessage);
            }
        } catch (ValidException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }


    }

}
