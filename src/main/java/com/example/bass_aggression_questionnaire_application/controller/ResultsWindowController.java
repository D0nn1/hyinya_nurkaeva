package com.example.bass_aggression_questionnaire_application.controller;

import com.example.bass_aggression_questionnaire_application.service.AppService;
import com.example.bass_aggression_questionnaire_application.service.impl.AppServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ResultsWindowController {

    @FXML
    private Label resultLabel;

    private List<Boolean> answers;
    private String firstName;
    private String lastName;

    private AppService appService;

    public ResultsWindowController(List<Boolean> answers, String firstName, String lastName) {
        this.answers = answers;
        this.firstName = firstName;
        this.lastName = lastName;
        this.appService = new AppServiceImpl();
    }

    @FXML
    private void initialize() {
        // Получить текущее время
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = date.atTime(LocalTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");


        StringBuffer results = appService.getIndexesFromResult(answers);

        // Отобразите результаты
        resultLabel.setText("Имя: " + firstName + "\nФамилия: " + lastName +
                "\nДата: " + dateTime.format(formatter) +
                "\n" + results);

        // Сохраните результаты в текстовый файл
        saveResultsToFile(results);
    }

    private void saveResultsToFile(StringBuffer results) {
        // Получить текущее время
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = date.atTime(LocalTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt", true))) {
            writer.write("Имя: " + firstName + "\nФамилия: " + lastName +
                    "\nДата: " + dateTime.format(formatter) +
                    "\n" + results + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void closeAndRestart() {
        Stage stage = (Stage) resultLabel.getScene().getWindow();
        stage.close();
    }
}
