package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Утилита для анализа текстовых файлов.
 * Подсчитывает количество строк, слов и символов.
 */
public class TextAnalyzer {
    private String content;
    private int lineCount;
    private int wordCount;
    private int charCount;

    /**
     * Конструктор, принимающий путь к файлу.
     * @param filePath путь к текстовому файлу
     * @throws IOException если файл не найден или не может быть прочитан
     */
    public TextAnalyzer(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            throw new IOException("Файл не найден: " + filePath);
        }
        this.content = Files.readString(path);
        analyze();
    }

    /**
     * Выполняет анализ текста.
     */
    private void analyze() {
        // Подсчёт строк
        lineCount = content.split("\r?\n").length;
        
        // Подсчёт символов (включая пробелы)
        charCount = content.length();
        
        // Подсчёт слов (разделители: пробелы, табы, переносы строк)
        String trimmedContent = content.trim();
        if (trimmedContent.isEmpty()) {
            wordCount = 0;
        } else {
            String[] words = trimmedContent.split("\\s+");
            wordCount = words.length;
        }
    }

    /**
     * Получить количество строк.
     * @return количество строк
     */
    public int getLineCount() {
        return lineCount;
    }

    /**
     * Получить количество слов.
     * @return количество слов
     */
    public int getWordCount() {
        return wordCount;
    }

    /**
     * Получить количество символов.
     * @return количество символов
     */
    public int getCharCount() {
        return charCount;
    }

    /**
     * Получить статистику в виде строки.
     * @return форматированная строка со статистикой
     */
    public String getStatistics() {
        return String.format(
            "Статистика файла:\n" +
            "Количество строк: %d\n" +
            "Количество слов: %d\n" +
            "Количество символов: %d",
            lineCount, wordCount, charCount
        );
    }
}

