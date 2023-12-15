package com.example.bass_aggression_questionnaire_application.service.impl;

import com.example.bass_aggression_questionnaire_application.service.AppService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppServiceImpl  implements AppService {
    @Override
    public  StringBuffer getIndexesFromResult(List<Boolean> results) {
        StringBuffer indexes = new StringBuffer();

        // Инициализируем словарь для хранения баллов для каждого пункта
        Map<String, Integer> indexesMap = new HashMap<>();
        indexesMap.put("Физическая агрессия", 0);
        indexesMap.put("Косвенная агрессия", 0);
        indexesMap.put("Раздражение", 0);
        indexesMap.put("Негативизм", 0);
        indexesMap.put("Обида", 0);
        indexesMap.put("Подозрительность", 0);
        indexesMap.put("Вербальная агрессия", 0);
        indexesMap.put("Угрызения совести, чувство вины", 0);


        // Проходим по всем ответам
        for (int i = 0; i < results.size(); i++) {
            // Если ответ "да"
            if (results.get(i)) {
                if (i == 1 || i == 25 || i == 33 || i == 48 || i == 55 || i == 62 || i == 68) {
                    indexesMap.put("Физическая агрессия", indexesMap.get("Физическая агрессия") + 1);
                } if (i == 9 || i == 17 || i == 41) {
                    indexesMap.put("Физическая агрессия", indexesMap.get("Физическая агрессия") - 1);
                }
                // Если это вопрос о косвенной агрессии
                if (i == 2 || i == 18 || i == 34 || i == 42 || i == 56 || i == 63) {
                    indexesMap.put("Косвенная агрессия", indexesMap.get("Косвенная агрессия") + 1);
                } if (i == 10 || i == 26 || i == 49) {
                    indexesMap.put("Косвенная агрессия", indexesMap.get("Косвенная агрессия") - 1);
                }

                // Если это вопрос о раздражении
                if (i == 3 || i == 19 || i == 27 || i == 43 || i == 50 || i == 57 || i == 64 || i == 72) {
                    indexesMap.put("Раздражение", indexesMap.get("Раздражение") + 1);
                } if (i == 11 || i == 35 || i == 69) {
                    indexesMap.put("Раздражение", indexesMap.get("Раздражение") - 1);
                }

                // Если это вопрос о негативизме
                if (i == 4 || i == 12 || i == 20 || i == 23 || i == 36) {
                    indexesMap.put("Негативизм", indexesMap.get("Негативизм") + 1);
                }

                // Если это вопрос об обиде
                if (i == 5 || i == 13 || i == 21 || i == 29 || i == 37 || i == 51 || i == 58) {
                    indexesMap.put("Обида", indexesMap.get("Обида") + 1);
                } if (i == 44) {
                    indexesMap.put("Обида", indexesMap.get("Обида") - 1);
                }

                // Если это вопрос о подозрительности
                if (i == 6 || i == 14 || i == 22 || i == 30 || i == 38 || i == 45 || i == 52 || i == 59) {
                    indexesMap.put("Подозрительность", indexesMap.get("Подозрительность") + 1);
                } if (i == 65 || i == 70) {
                    indexesMap.put("Подозрительность", indexesMap.get("Подозрительность") - 1);
                }

                // Если это вопрос о вербальной агрессии
                if (i == 7 || i == 15 || i == 23 || i == 31 || i == 46 || i == 53 || i == 60 || i == 71 || i == 73) {
                    indexesMap.put("Вербальная агрессия", indexesMap.get("Вербальная агрессия") + 1);
                } if (i == 39 || i == 66 || i == 74 || i == 75) {
                    indexesMap.put("Вербальная агрессия", indexesMap.get("Вербальная агрессия") - 1);
                }

                // Если это вопрос о угрызениях совести, чувстве вины
                if (i == 8 || i == 16 || i == 24 || i == 32 || i == 40 || i == 47 || i == 54 || i == 61 || i == 67) {
                    indexesMap.put("Угрызения совести, чувство вины", indexesMap.get("Угрызения совести, чувство вины") + 1);
                }
            }
        }

        indexesMap.forEach((key, value) -> indexes.append(key).append(" - ").append(value).append(" б\n"));

        System.out.println(indexes);

        return indexes;
    }


}
