package com.example.bass_aggression_questionnaire_application.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

public class MainWindowController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    private final String NAME_REGEX = "^[а-яА-Я]+[а-яА-Я]?[а-яА-Яа-яА-Я]+$";

    @FXML
    private void startTest(ActionEvent event) {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();

        if (!Pattern.matches(NAME_REGEX, firstName) && !Pattern.matches(NAME_REGEX, lastName)) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Неверные данные");
            alert.setContentText("Введены некорректные данные. Попробуйте еще раз.");
            alert.show();
            return;
        }

        // Переход к следующему окну (TestWindow.fxml)
        try {
            TestWindowController testController = new TestWindowController(firstName, lastName);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/TestWindow.fxml"));
            loader.setController(testController);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}