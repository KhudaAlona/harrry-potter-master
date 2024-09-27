package edu.pro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Шлях до файлу
        String filePath = "src/edu/pro/txt/harry.txt";

        try {
            // Очищений текст
            String content = cleanText(filePath);
            // Масив слів
            String[] words = content.split("\\s+");
            // Підрахунок частоти слів
            Map<String, Integer> wordFrequency = countWordFrequency(words);
            // Виведення топ-30 найпоширеніших слів
            printTopWords(wordFrequency, 30);
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }

    // Метод для очищення тексту
    public static String cleanText(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return content.toLowerCase().replaceAll("[^a-zA-Z\\s]", ""); // Лише літери і пробіли
    }

    // Метод для підрахунку частоти слів
    public static Map<String, Integer> countWordFrequency(String[] words) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) { // Ігнорування порожніх слів
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }
        return wordFrequency;
    }

    // Метод для виведення топ-N найпоширеніших слів
    public static void printTopWords(Map<String, Integer> wordFrequency, int topN) {
        wordFrequency.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(topN)
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}