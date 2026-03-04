import java.util.Locale;
import java.util.Scanner;

/**
 * Домашнее задание №1
 * @author Nikita Shaternik
 * 26.02.2026
 */

public class Lesson1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // Есть проблема с этими плавающими значениями то , то .
        int num = 0;
        boolean exit = false;

        System.out.println("Здравствуйте, Томаш! Перед вам 5 готовых задач:");


        while (!exit) {
            System.out.println("1. Задача 1");
            System.out.println("2. Задача 2");
            System.out.println("3. Задача 3");
            System.out.println("4. Задача 4");
            System.out.println("5. Задача 5");
            System.out.println("6. Задача *");
            System.out.println("7. Выход");
            System.out.println("Введите номер задачи:");
            switch (scanner.nextInt()) {
                case 1 -> {
//              Задача 1:
//              Написать приложение, которое будет вычислять и выводить значение по формуле:
//              a=4*(b+c-1)/2; b и c задаем в коде самостоятельно.
                    System.out.println("Для выполнения Задачи 1, введите в консоль значение переменной b и с. \nВведите значение b: ");
                    double b = scanner.nextDouble();
                    System.out.println("Введите значение c: ");
                    double c = scanner.nextDouble();

                    System.out.println("Результат a=4*(b+c-1)/2 = " + 4*(b+c-1)/2);
                    System.out.println("----------------------------------------------");
                    System.out.println("Отлично! Продолжим? Выберите номер задачи:");
                    System.out.println("----------------------------------------------");
                }

                case 2 -> {
//              Задача 2:
//              В переменной n хранится двузначное число. Создайте программу, вычисляющую и
//              выводящую на экран сумму цифр n. Например: n =26, в результате мы должны получить 8
//              (2+6).
                    System.out.println("---------------------------------------------------");
                    System.out.println("Задача 2: Сумма цифр двухзначного числа n");

                    while (true) {
                        System.out.println("Введите двухзначное число: ");
                        if (scanner.hasNextInt()) {
                            num = scanner.nextInt();
                            if (num >= 10 && num<= 99) {
                                System.out.println("Результат суммы цифр числа n = " + (num % 10 + num / 10));
                                System.out.println("----------------------------------------------");
                                System.out.println("Отлично! Продолжим? Выберите номер задачи:");
                                System.out.println("----------------------------------------------");
                                break;
                            }
                            else {
                                System.out.println("Не, ну так не честно...");
                            }
                        }
                    }
                }

                case 3 -> {
//               Задача 3:
//               В переменной n хранится трёхзначное число. Создайте программу, вычисляющую и
//               выводящую на экран сумму цифр n. Например: n =126, в результате мы должны получить
//               9 (1+2+6).
                    System.out.println("Задача 3: Сумма цифр трехнзначного числа n");

                    while (true) {
                        System.out.println("Введите трехзначное число: ");
                        if (scanner.hasNextInt()) {
                            num = scanner.nextInt();
                            if (num >= 100 && num<= 999) {
                                System.out.println("Результат суммы цифр числа n = " + (num / 100 + (num / 10) % 10 + num % 10));
                                System.out.println("----------------------------------------------");
                                System.out.println("Отлично! Продолжим? Выберите номер задачи:");
                                System.out.println("----------------------------------------------");
                                break;
                            }
                            else {
                                System.out.println("Не, ну так не честно...");
                            }
                        }
                    }

                }

                case 4 -> {
//               Задача 4:
//               В переменной n хранится вещественное число с ненулевой дробной частью. Создайте
//               программу, округляющую число n до ближайшего целого и выводящую результат на
//               экран.
                    System.out.println("Задача 4: округление ненулевой дробной части n");

                    while (true) {
                        System.out.println("Введите число с ненулевой дробной частью (пример 3.2): ");
                        if (scanner.hasNextDouble()) {
                            double num1 = scanner.nextDouble();
                            double test = num1 - (int) num1;
                            if (test != 0) {
                                System.out.println("Округление числа = " + (int)Math.round(num1));
                                System.out.println("----------------------------------------------");
                                System.out.println("Отлично! Продолжим? Выберите номер задачи:");
                                System.out.println("----------------------------------------------");
                                break;
                            }
                            else {
                                System.out.println("Не, ну так не честно...Повтори еще раз.");
                            }
                        }
                        else {
                            System.out.println("Так, давай число напишем:");
                            scanner.next();
                        }
                    }
                }

                case 5 -> {
//              Задача 5:
//              В переменных q и w хранятся два натуральных числа. Создайте программу, выводящую
//              на экран результат деления q на w с остатком. Пример вывода программы (для случая,
//              когда в q хранится 21, а в w хранится 8): 21 / 8 = 2 и 5 в остатке.
                    System.out.println("Задача 5: вывод целого числа с остатком");

                    while (true) {
                        System.out.println("Введите натуральное число q: ");
                        int q = scanner.nextInt();

                        System.out.println("Введите натуральное число w: ");
                        int w = scanner.nextInt();

                        if (q <= 0 || w <= 0) {
                            System.out.println("Оба числа должны быть натуральными! Попробуйте снова.");
                            continue;
                        }

                        int numFull= q / w;
                        int nummLast = q % w;

                        System.out.printf("%d / %d = %d и %d в остатке.\n", q, w, numFull, nummLast);
                        System.out.println("----------------------------------------------");
                        System.out.println("Отлично! Продолжим? Выберите номер задачи:");
                        System.out.println("----------------------------------------------");
                        break;
                    }
                }

                case 6 -> {
//              Задача *:
//               Написать программу которая будет менять местами значение целочисленных
//              переменных. Пример:
//              int a = 1; int b = 2;
//               sout(a); //выведет 2
//               sout(b); //выведет 1
//               Усовершенствовать программу, использовать только 2 входные переменные (a,b);
                    System.out.println("Задача 6: смена местами введенных переменных");
                    System.out.println("Введите 1 число:");
                    int number1 = scanner.nextInt();
                    System.out.println("Введите 2 число:");
                    int number2 = scanner.nextInt();

                    System.out.printf("Меняем значение, как хотим." +
                            "\nМожно так: %d, %d" +
                            "\nМожно обратно: %d, %d" +
                            "\nМожно вместе: %d%d\n",
                            number2, number1, number1, number2, number1, number2);
                    System.out.println("----------------------------------------------");
                    System.out.println("Отлично! Продолжим? Выберите номер задачи:");
                    System.out.println("----------------------------------------------");
                }
                case 7 -> {
                    System.out.println("Выход из программы. До свидания!");
                    exit = true;
                }
                default -> System.out.println("Введите задачу из списка");
            }
        }
    }
}
