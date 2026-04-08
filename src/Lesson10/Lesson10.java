package Lesson10;

/**
 * Домашнее задание №10
 * @author Nikita Shaternik
 * 31.03.2026
 */

public class Lesson10 {
    public static void main(String[] args) throws CloneNotSupportedException {
        /* Задача 1:
        Создать класс для описания пользователя системы. Переопределить в классе методы
        toString,hashcode и equals. Создать несколько экземпляров класса с одним и тем же
        значением полей и сравнить с помощью метода equals. */
        User ivanFirst = new User("Ivan", 25, "ivan@gmail.com", new MobilePhone("samsung"));
        User ivanSecond = new User("Ivan", 25, "ivan@gmail.com", new MobilePhone("samsung"));
        User petrProstoPetr = new User("Petr", 30, "petr@gmail.com",new MobilePhone("iphone"));

        System.out.println(ivanFirst);
        System.out.println(ivanSecond);

        System.out.println("Проверка ИванаПервого и ИванаВторого: " + ivanFirst.equals(ivanSecond)); // true
        System.out.println("Проверка ИванаПервого и ПростоПетьку: " + ivanFirst.equals(petrProstoPetr)); // false


        /*Задача *:
        Создать программу для реализации поверхностного и глубокого клонирования объекта
        класса User. Пусть на вход программе будет передаваться тип операции клонирования
        (поверхностное клонирование или глубокое), а также id юзера для клонирования. */

        int choose = 2; // чтобы не создавать лишние Scanner, для визуализации можно менять тут вход

        User clone;
        if (choose == 1) {
            clone = ivanFirst.clone();
        } else if (choose == 2) {
            clone = ivanFirst.deepClone();
        } else {
            System.out.println("Неверный тип клонирования");
            return;
        }

        clone.mobilePhone.model = "nokia";

        System.out.println("Оригинал: " + ivanFirst);
        System.out.println("Клон: " + clone);
    }
}
