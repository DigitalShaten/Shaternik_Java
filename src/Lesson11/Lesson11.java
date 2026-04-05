package Lesson11;

import java.util.Scanner;

public class Lesson11 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] stringsForTask = new String[3];
        System.out.println("Будьте добры, введите строки: ");
        for (int i = 0; i < stringsForTask.length; i++) {
            System.out.println("Ввод строки номер " + (i + 1) + ": ");
            stringsForTask[i] = scanner.nextLine();
        }

        /* 1. Ввести 3 строки с консоли, найти самую короткую и самую длинную строки. Вывести
        найденные строки и их длину. */

        String shortest = stringsForTask[0];
        String longest = stringsForTask[0];

        for (String line : stringsForTask) {
            if (line.length() < shortest.length()) {
                shortest = line;
            }
            if (line.length() > longest.length()) {
                longest = line;
            }
        }

        System.out.println("Задача 1");
        System.out.println("Самая длинная строка (" + longest.length() + "): " + longest);
        System.out.println("Самая короткая строка (" + shortest.length() + "): " + shortest);

        /*2. Ввести 3 строки с консоли. Упорядочить и вывести строки в порядке возрастания
        значений их длины. */
        for (int i = 0; i < stringsForTask.length - 1; i++) {
            for (int j = 0; j < stringsForTask.length - 1 - i; j++) {
                if (stringsForTask[j].length() > stringsForTask[j + 1].length()) {
                    String temp = stringsForTask[j];
                    stringsForTask[j] = stringsForTask[j + 1];
                    stringsForTask[j + 1] = temp;
                }
            }
        }

        System.out.println("Задача 2");
        for (String line : stringsForTask) {
            System.out.println(line + " (" + line.length() + ")");
        }

        /*3. Ввести 3 строки с консоли. Вывести на консоль те строки, длина которых меньше
        средней, а также их длину. */
        int totalSize = 0;
        for (String line : stringsForTask) {
            totalSize += line.length();
        }

        System.out.println("Задача 3");
        double average = (double) totalSize / stringsForTask.length;
        System.out.println("Средняя длина: " + average);

        System.out.println("Строки меньше средней длины: ");
        for (String line : stringsForTask) {
            if (line.length() < average) {
                System.out.println(line + " (" + line.length() + ")");
            }
        }

        /*4. Ввести 3 строки с консоли. Найти слово, состоящее только из различных символов.
        Если таких слов несколько, найти первое из них. */
        System.out.println("Задача 4");

        boolean found = false;

        for (String line : stringsForTask) {
            String[] words = line.split(" ");

            for (String word : words) {
                boolean isUnique = true;

                for (int i = 0; i < word.length(); i++) {
                    for (int j = i + 1; j < word.length(); j++) {
                        if (word.charAt(i) == word.charAt(j)) {
                            isUnique = false;
                            break;
                        }
                    }
                    if (!isUnique) break;
                }

                if (isUnique) {
                    System.out.println("Первое слово с уникальными символами: " + word);
                    found = true;
                    break;
                }
            }

            if (found) break;
        }

        if (!found) {
            System.out.println("Таких слов нет");
        }

        /*5. Вывести на консоль новую строку, которой задублирована каждая буква из
        начальной строки. Например, "Hello" -> "HHeelllloo". */
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < stringsForTask[0].length(); i++) {
            char symbol = stringsForTask[0].charAt(i);
            result.append(symbol).append(symbol);
        }
        System.out.println("Задача 5");
        System.out.println(result.toString());


        /*Задача *:
        Дана строка произвольной длины с произвольными словами. Написать программу для
        проверки является ли любое выбранное слово в строке палиндромом.
        Например, есть строка, вводится число 3, значит необходимо проверить является ли 3-е слово в этой строке палиндромом.
        Предусмотреть предупреждающие сообщения на случаи ошибочных ситуаций: например, в строке 5 слов, а на вход программе передали число 500. */
        System.out.println("Задача*:");
        System.out.println("Введите новую строку для задачи*:");

        String inputText = scanner.nextLine();
        String[] words = inputText.trim().split("\\s+");

        System.out.println("Введите номер слова:");
        int index = scanner.nextInt();

        if (index < 1 || index > words.length) {
            System.out.println("Ошибка: такого слова не существует");
            return;
        }

        String word = words[index - 1];
        boolean isPalindrome = true;

        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Слово \"" + word + "\" является палиндромом");
        } else {
            System.out.println("Слово \"" + word + "\" НЕ является палиндромом");
        }
    }
}
