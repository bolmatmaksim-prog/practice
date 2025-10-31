# Утилита для работы с текстовыми файлами

## Описание

Консольная утилита на Java для анализа текстовых файлов. Программа позволяет:
- Считывать текст из файла
- Подсчитывать количество строк, слов и символов
- Выводить статистику в консоль или сохранять в файл `stats.txt`

## Требования

- Java 11 или выше
- Maven 3.x

## Установка

Клонируйте репозиторий:
```bash
git clone <ваш-url-репозитория>
cd 11
```

## Сборка

```bash
mvn clean compile
```

## Запуск

```bash
mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="путь/к/файлу.txt"
```

Или скомпилируйте и запустите:
```bash
mvn clean package
java -cp target/classes org.example.Main путь/к/файлу.txt
```

## Использование

Программа принимает путь к текстовому файлу в качестве аргумента командной строки и выводит статистику в консоль. 

Для сохранения статистики в файл `stats.txt` используйте флаг `-o` или `--output`:
```bash
java -cp target/classes org.example.Main путь/к/файлу.txt -o
```

## Примеры

```bash
# Вывод в консоль
java -cp target/classes org.example.Main input.txt

# Сохранение в файл
java -cp target/classes org.example.Main input.txt -o
```

## Структура проекта

```
src/
  main/
    java/
      org/example/
        Main.java
        TextAnalyzer.java
```

