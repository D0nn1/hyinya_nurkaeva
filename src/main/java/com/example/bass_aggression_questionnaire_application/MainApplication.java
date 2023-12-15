package com.example.bass_aggression_questionnaire_application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("/MainWindow.fxml"));

        primaryStage.getIcons().add(new Image("file:icon.png"));
        primaryStage.setTitle("Тестирование");
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}