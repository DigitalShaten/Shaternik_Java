import java.util.Scanner;

/**
 * Домашнее задание №2
 * @author Nikita Shaternik
 * 03.03.2026
 */

public class Lesson2 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("1 - Задача 1");
            System.out.println("2 - Задача 2");
            System.out.println("3 - Задача 3");
            System.out.println("4 - Задача 4");
            System.out.println("5 - Задача 5");
            System.out.println("0 - Выход");
            System.out.println("Введите номер задачи: ");

            if (scanner.hasNextInt()) {
                int choose = scanner.nextInt();

                switch (choose) {
                    case 1 -> TaskOne.run();
                    case 2 -> TaskTwo.run();
                    case 3 -> TaskThree.run();
                    case 4 -> TaskFour.run();
                    case 5 -> TaskFive.run();
                    case 0 -> {
                        printDash("Выхожу...");
                        return;
                    }
                    default -> {
                        printDash("Нет такого выбора...Давай еще раз...");
                    }
                }
            } else {
                System.out.println("Введите число: ");
                scanner.next();
            }
        }
    }
    /* Задача 1:
        Напишите программу, которая будет принимать на вход число из консоли и на выход
        будет выводить сообщение четное число или нет. Для определения четности числа
        используйте операцию получения остатка от деления (операция выглядит так: '% 2'). */

    static class TaskOne {
        public static void run() {
            System.out.println("Задача 1! Введите число для определения четности: ");

            if (scanner.hasNextInt()) {
                int number =  scanner.nextInt();
                if (number % 2 == 0) {
                    System.out.println("Число четное!");
                    printDash("Продолжим?");
                } else {
                    System.out.println("Число нечетное!");
                    printDash("Продолжим?");
                }
            } else {
                printDash("Давай еще раз...");
                scanner.next();
            }
        }
    }

    /* Задача 2:
        Для введенного числа t (температура на улице) вывести: Если t>–5, то вывести «Warm».
        Если –5>= t > –20, то вывести «Normal». Если –20>= t, то вывести «Cold».*/

    static class TaskTwo {
        public static void run() {
            System.out.println("Задача 2! Введите температуру на улице: ");

            if (scanner.hasNextInt()) {
                int t = scanner.nextInt();
                if (t>-5) {
                    System.out.println("Warm");
                    if (t > 55) {
                        System.out.println("А потенциально это... смэрть...");
                    }
                    printDash("Продолжим?");
                } else if (t > -20) {
                    System.out.println("Normal");
                    printDash("Продолжим?");
                } else {
                    System.out.println("Cold");
                    if (t < -90) {
                        System.out.println("А потенциально это... смэрть...");
                    }
                    printDash("Продолжим?");
                }
            } else {
                printDash("Давай еще раз...");
                scanner.next();
            }
        }
    }

    /* Задача 3:
        Составьте программу, выводящую на экран квадраты чисел от 10 до 20 включительно.*/

    static class TaskThree {
        public static void run() {
            System.out.println("Задача 3! Выводим на экран квадраты чисел от 10 до 20 включительно: ");
            int num = 10;

            for (int i = 10; i <= 20; i++) {
                System.out.println(i + " -> " + (int) Math.pow(i, 2));
            }

            printDash("Готово. Дальше?");
        }
    }

    /* Задача 4:
        Необходимо, чтоб программа выводила на экран вот такую последовательность:
        7 14 21 28 35 42 49 56 63 70 77 84 91 98. В решении используйте цикл while.*/

    static class TaskFour {
        public static void run() {
            System.out.println("Задача 4! Введите стартовое число для отсчета: ");
            int numCycle = 14;

            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                int numFix = num;
                int cycle = 0;

                while (cycle < numCycle) {
                    System.out.print(num + " ");
                    num+=numFix;
                    cycle++;
                }
                System.out.println();
                printDash("Справились...Идем дальше?");

            } else {
                printDash("Давай еще раз...");
                scanner.next();
            }
        }
    }

    /* Задача *:
        Напишите программу, где пользователь вводит любое целое положительное число. А
        программа суммирует все числа от 1 до введенного пользователем числа. Для ввода
        числа воспользуйтесь классом Scanner. Сделать проверку, чтобы пользователь не мог
        ввести некорректные данные.*/

    static class TaskFive {
        public static void run() {
            System.out.println("Задача 5*! Положительное целое число, будем суммировать: ");

            while (true) {
                int result = 0;
                if (scanner.hasNextInt()) {
                    int num = scanner.nextInt();
                    if (num > 0) {
                        for (int i = 1; i <= num; i ++) {
                            result+=i;
                        }
                        System.out.println("Сумма всех чисел от 1 до введенного числа = " + result);
                        printDash("Продолжим?");
                        break;
                    } else {
                        printDash("Введите положительное число: ");
                    }
                } else {
                    printDash("Давай еще раз...");
                    scanner.next();
                    return;
                }
            }
        }
    }

    public static void printDash(String message){
        System.out.println("----------------------------------------");
        System.out.println(message);
        System.out.println("----------------------------------------");
    }
}






