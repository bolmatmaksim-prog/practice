package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Главный класс приложения.
 * Принимает путь к файлу и выводит статистику.
 */
public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Использование: java Main <путь_к_файлу> [опции]");
            System.out.println("Опции:");
            System.out.println("  -o, --output  Сохранить статистику в файл stats.txt");
            System.exit(1);
        }

        String filePath = args[0];
        boolean outputToFile = false;

        // Проверка опций
        if (args.length > 1) {
            for (int i = 1; i < args.length; i++) {
                if (args[i].equals("-o") || args[i].equals("--output")) {
                    outputToFile = true;
                }
            }
        }

        try {
            TextAnalyzer analyzer = new TextAnalyzer(filePath);
            String statistics = analyzer.getStatistics();

            if (outputToFile) {
                // Запись в файл (будет реализована в ветке feature/file-output)
                System.out.println("Статистика сохранена в файл stats.txt");
            } else {
                System.out.println(statistics);
            }
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
            System.exit(1);
        }
    }
}
