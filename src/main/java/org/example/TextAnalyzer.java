package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextAnalyzer {
    private String content;
    private int lineCount;
    private int wordCount;
    private int charCount;

    public TextAnalyzer(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            throw new IOException("Файл не найден: " + filePath);
        }
        this.content = Files.readString(path);
        analyze();
    }

    private void analyze() {
        lineCount = content.split("\r?\n").length;
        charCount = content.length();
        
        String trimmedContent = content.trim();
        if (trimmedContent.isEmpty()) {
            wordCount = 0;
        } else {
            String[] words = trimmedContent.split("\\s+");
            wordCount = words.length;
        }
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getCharCount() {
        return charCount;
    }

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
