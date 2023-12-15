package com.example.bass_aggression_questionnaire_application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.bass_aggression_questionnaire_application.service.AppService.readQuestions;

public class TestWindowController {

    @FXML
    private Label questionLabel;

    private List<String> questions;
    private List<Boolean> answers;

    private int currentIndex = 0;

    private String firstName;
    private String lastName;

    public TestWindowController(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        questions = readQuestions();
        answers = new ArrayList<>();
    }

    @FXML
    private void initialize() {
        showNextQuestion();
    }

    private void showNextQuestion() {
        if (currentIndex < questions.size()) {
            questionLabel.setText(questions.get(currentIndex));
        } else {
            // Показать результаты или перейти к окну результатов
            showResults();
        }
    }

    @FXML
    private void answerYes() {
        answers.add(true);
        currentIndex++;
        showNextQuestion();
    }

    @FXML
    private void answerNo() {
        answers.add(false);
        currentIndex++;
        showNextQuestion();
    }


    private void showResults() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ResultsWindow.fxml"));
            ResultsWindowController resultsController = new ResultsWindowController(answers, firstName, lastName);
            loader.setController(resultsController);

            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Результаты теста");
            stage.show();

            // Закрываем текущее окно теста
            Stage currentStage = (Stage) questionLabel.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

