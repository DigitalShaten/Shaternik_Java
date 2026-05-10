package Lesson17;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Домашнее задание №17
 *
 * @author Nikita Shaternik
 * 01.05.2026
 */

public class Lesson17 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*Задача 1:
        Пользователь вводит в консоль дату своего рождения. Программа должна вернуть дату,
        когда пользователю исполнится 100 лет. Использовать Date/Time API. */
        System.out.println("Задача 1: введите дату своего рождения");
        System.out.print("Дата рождения (в формате 2000-12-31): ");
        String dateOfBirthdayString = scanner.nextLine();

        try {
            LocalDate dateOfBirthday = LocalDate.parse(dateOfBirthdayString);
            LocalDate date100 = dateOfBirthday.plusYears(100);
            System.out.println("Дата, когда вам исполнится 100 лет: " + date100);

        } catch (DateTimeParseException exception) {
            System.out.println("Неверный формат даты!");
        }


        /*Задача 2:
        Используя Predicate среди массива чисел вывести только те, которые являются
        положительными. */
        System.out.println("Задача 2: интерфейс Predicate");
        int[] arrayNumber = {-4, -3, 1, 3, 5, 7, 10, 12, 17};

        Predicate<Integer> isEven = x -> x % 2 == 0;
        for (int number : arrayNumber) {
            if (isEven.test(number)) {
                System.out.println(number);
            }
        }

        /*Задача 3:
        Используя Function реализовать лямбду, которая будет принимать в себя строку в
        формате “*сумма* BYN”(через пробел, вместо *сумма* вставить любое значение), а
        возвращать сумму, переведенную сразу в доллары. */
        System.out.println("Задача 3: интерфейс Function");

        double rateUSD = 2.83;
        Function<String, Double> convert = x -> {
            String[] parts = x.split("\\s+");
            double value = Double.parseDouble(parts[0]);
            return value / rateUSD;
        };

        try {
            double result = convert.apply("210 BYN");
            System.out.printf("210 BYN получили, на выходе %.2f USD\n", result);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Нарушен формат строки (цифра - текст)");
        }

        /*Задача 4:Используя Consumer реализовать лямбду, которая будет принимать в себя строку в
        формате “*сумма* BYN”(через пробел, вместо *сумма* вставить любое значение), а
        выводить сумму, переведенную сразу в доллары. */
        System.out.println("Задача 4: интерфейс Consumer");

        Consumer<String> convertTask = x -> {
            try {
                String[] parts = x.split("\\s+");
                double value = Double.parseDouble(parts[0]);
                System.out.printf("Преобразование BYN в USD вернуло: %.2f USD\n", value / rateUSD);
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Нарушен формат строки (цифра - текст)");
            }

        };

        convertTask.accept("210 BYN");

        /*Задача 5:
        Используя Supplier написать метод, который будет возвращать введенную с консоли
        строку задом наперед. */
        System.out.println("Задача 5: интерфейс Supplier");

        Supplier<String> revert = () -> {
            String userInput = scanner.nextLine();
            StringBuilder userText = new StringBuilder(userInput);
            return userText.reverse().toString();
        };
        System.out.println("Введите любую строку: ");
        System.out.println("Метод переворазачивает строку задом наперед: " + revert.get()); //улыбок тебе дед макар
    }
}
