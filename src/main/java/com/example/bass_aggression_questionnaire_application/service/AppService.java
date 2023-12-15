package com.example.bass_aggression_questionnaire_application.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface AppService {

    static List<String> readQuestions() {
        try (FileReader reader = new FileReader("questions.txt");
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            List<String> questions = new ArrayList<>();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                questions.add(line);
            }
            return questions;
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }

    StringBuffer getIndexesFromResult(List<Boolean> results);

}
