package Lesson12;

/**
 * Домашнее задание №12
 * @author Nikita Shaternik
 * 07.04.2026
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson12 {
    public static void main(String[] args) {
        /* Задача 1:
        Вывести в консоль из строки которую пользователь вводит с клавиатуры все
        аббревиатуры. Аббревиатурой будем считать слово от 2 до 6 символов, состоящее
        только из прописных букв, без чисел.*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String inputFirst = scanner.nextLine();
        boolean found = false;

        Pattern pattern = Pattern.compile("\\b[А-ЯЁ]{2,6}\\b", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(inputFirst);

        System.out.println("Аббревиатуры: ");
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }
        if (!found) {
            System.out.println("Аббревиатуры не найдены");
        }

        /* Задача *:
        Программа на вход получает произвольный текст. В этом тексте может быть номер
        документа(один или несколько), емейл и номер телефона. Номер документа в формате: xxxx-xxxx-xx, где x - это любая цифра;
        номер телефона в формате: +(xx)xxxxxxx. Документ может содержать не всю информацию, т.е. например, может не содержать номер телефона, или другое.
        Необходимо найти эту информацию и вывести в консоль в формате:email: teachmeskills@gmail.com
        document number: 1423-1512-51
        и т.д*/
        System.out.println("\nЗадача*");
        String textSecond = """
                               Вчера я получил письмо от teachmeskills@gmail.com с важной информацией.
                               В тексте был указан номер документа 1423-1512-51 и дополнительный 9999-0000-12.
                               Также мне позвонили с номера +(29)1234567 и позже с +(44)7654321.
                               Друг отправил мне контакт user.test123@mail.ru, но номер документа там был неправильный: 123-1234-12.
                               Ещё один email: example_email@domain.com.
                               В тексте встречались случайные числа 12345678 и строки вроде abcd-efgh-ij.
                               Иногда попадаются почти правильные номера +(12)12345 или 1111-2222-333.
                               И напоследок: support@company.org и номер документа 5555-6666-77.""";

        Pattern docPattern = Pattern.compile("\\b\\d{4}-\\d{4}-\\d{2}\\b");
        Pattern emailPattern = Pattern.compile("\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\b");
        Pattern numberPattern = Pattern.compile("\\+\\(\\d{2}\\)\\d{7}");

        System.out.println("=== EMAIL ===");
        printMatchs(emailPattern, textSecond, "email: ");

        System.out.println("=== DOCUMENTS ===");
        printMatchs(docPattern, textSecond, "document nubmer: ");

        System.out.println("=== PHONES ===");
        printMatchs(numberPattern, textSecond, "phone nubmer: ");
    }

    public static void printMatchs (Pattern pattern, String text, String label) {
        Matcher matcher = pattern.matcher(text);
        boolean found = false;

        while (matcher.find()) {
            System.out.println(label + matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println(label + "не найдено");
        }
        System.out.println(); //только для разделения и красивого вывода
    }
}
