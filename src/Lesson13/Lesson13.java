package Lesson13;

import static Lesson13.User.checkUser;

/**
 * Домашнее задание №13
 * @author Nikita Shaternik
 * 12.04.2026
 */

public class Lesson13 {
    public static void main(String[] args) {
        /* Задача 1:
        Создать класс, в котором будет статический метод. Этот метод принимает на вход три
        параметра: login, password, confirmPassword. Все поля имеют тип данных String. Длина
        login должна быть меньше 20 символов и не должен содержать пробелы. Если login не
        соответствует этим требованиям, необходимо выбросить WrongLoginException. Длина
        password должна быть меньше 20 символов, не должен содержать пробелов и должен содержать хотя бы одну цифру. Также password и confirmPassword должны быть равны.
        Если password не соответствует этим требованиям, необходимо выбросить
        WrongPasswordException. WrongPasswordException и WrongLoginException -
        пользовательские классы исключения с двумя конструкторами – один по умолчанию,
        второй принимает сообщение исключения и передает его в конструктор класса Exception.
        Метод возвращает true, если значения верны, false в противном случае.*/
        try {
            boolean result = checkUser ("Иван", "pass123", "pass123");
            if (result) {
                System.out.println("Пользователь подтвержден!");
            }
        } catch (WrongLoginException e) {
            System.out.println("Ошибка логина: " + e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка пароля: " + e.getMessage());
        }

        /* Задача *:
        Написать try/catch/finally, в котором finally вызван не будет. */
        try {
            System.out.println("Задача со звездочкой!");
            throw new RuntimeException();
        } catch (RuntimeException runtimeExceptionE) {
            System.out.println("Что-то пошло не так и мы выходим!");
            System.exit(0);
        } finally {
            System.out.println("Этого мы не увидим");
        }

    }
}
