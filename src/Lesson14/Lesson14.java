package Lesson14;


import java.io.*;
import java.util.Scanner;

/**
 * Домашнее задание №14
 *
 * @author Nikita Shaternik
 * 15.04.2026
 */

public class Lesson14 {
    public static void main(String[] args) {
        /*Задача 1:
        В задании приложен файл Ромео и Джульетта на английском, вычитать его в приложении. Проанализировать и записать в другой файл самое длинное слово.*/
        String longestWord = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Lesson14/romeo-and-juliet.txt"));) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");

                for (String word:words) {
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try (FileWriter writer = new FileWriter("src/Lesson14/long_word.txt")) {
            writer.write(longestWord);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        System.out.println("Самое длинное слово: " + longestWord);

        /* Задача *:
        Допустим есть txt файл с номерами документов. Номером документа является строка,
        состоящая из букв и цифр(без служебных символов). Пусть этот файл содержит каждый номер
        документа с новой строки и в строке никакой другой информации, только номер документа.
        Валидный номер документа должен иметь длину 15 символов и начинаться с последовательности
        docnum(далее любая последовательность букв/цифр) или contract(далее любая последовательность букв/цифр).
        Написать программу для чтения информации из входного файла - путь к входному файлу должен задаваться через консоль.
        Программа должна проверять номера документов на валидность. Валидные номера документов следует записать в один файл-отчет.
        Невалидные номера документов следует записать в другой файл-отчет, но после
        номеров документов следует добавить информацию о том, почему этот документ не валиден.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу:");
        String path = scanner.nextLine();

        try (
                BufferedReader reader = new BufferedReader(new FileReader(path));
                FileWriter validWriter = new FileWriter("src\\Lesson14\\valid.txt");
                FileWriter invalidWriter = new FileWriter("src\\Lesson14\\invalid.txt");
        ) {

            String line;

            while ((line = reader.readLine()) != null) {

                line = line.trim();

                if (line.isEmpty()) continue;

                boolean isValid = true;
                String reason = "";

                if (line.length() != 15) {
                    isValid = false;
                    reason += "Неверная длина; ";
                }

                if (!line.startsWith("docnum") && !line.startsWith("contract")) {
                    isValid = false;
                    reason += "Неверный префикс; ";
                }

                if (!line.matches("[a-zA-Z0-9]+")) {
                    isValid = false;
                    reason += "Недопустимые символы; ";
                }

                if (isValid) {
                    validWriter.write(line + "\n");
                } else {
                    invalidWriter.write(line + " -> " + reason + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
