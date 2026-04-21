package Lesson15;

import java.util.*;

/**
 * Домашнее задание №15
 *
 * @author Nikita Shaternik
 * 21.04.2026
 */

public class Lesson15 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* Задача 1:
        Пользователь вводит набор чисел в виде одной строки с клавиатуры. Например: "1, 2, 3,
        4, 4, 5". Избавиться от повторяющихся элементов в строке. Вывести результат на экран.
        При решении использовать коллекции. */
        System.out.println("Задача 1: введите числа с клавитуры через запятую");

        String allNumber = scanner.nextLine();
        String[] numbers = allNumber.split(",");

        Set<Integer> setCollection = new LinkedHashSet<>();
        for (String num : numbers) {
            try {
                int value = Integer.parseInt(num.trim());
                setCollection.add(value);
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Вы ввели буквы. Нарушает правила ввода.");
            }
        }
        System.out.println(setCollection);

        /* Задача 2:
        Создать класс, который будет хранить в себе коллекцию с названиями животных.
        Реализовать методы удаления и добавления животных по следующим правилам:
        добавляется всегда в начало коллекции, а удаляется всегда из конца. Показать работу
        объекта этого класса в main методе другого класса. */
        System.out.println("Задача 2: добавляем животинок в начало, удаляем в конце");

        AnimalCollection animals = new AnimalCollection();

        animals.add("Кот");
        animals.add("Собака");
        animals.add("Лев");

        System.out.println("Удалено: " + animals.remove());
        animals.printAll();


        /* Задача 3:
        Создать класс Student, содержащий следующие характеристики – имя, группа, курс,
        оценки по предметам. Создать коллекцию, содержащую объекты класса Student.
        Написать метод, который удаляет студентов со средним баллом <3. Если средний
        балл>=3, студент переводится на следующий курс. Дополнительно написать метод
        printStudents(List<Student> students, int course), который получает список студентов и
        номер курса. А также печатает на консоль имена тех студентов из списка, которые
        обучаются на данном курсе. */
        List<Student> students = new ArrayList<>();

        students.add(new Student("Иван", "A1", 1, List.of(5, 4, 4)));
        students.add(new Student("Петр", "A1", 1, List.of(2, 2, 3)));
        students.add(new Student("Анна", "A1", 2, List.of(4, 4, 5)));

        students.removeIf(student -> {
            if (student.isGoodStudent()) {
                student.increaseCourse();
                return false;
            } else {
                return true;
            }
        });
        printStudents(students, 2);

        /* Задача *:
        Представим, что в Java нет коллекции типа ArrayList. Создать свой класс, симулирующий
        работу класса динамической коллекции - т.е. создать свою кастомную коллекцию. В
        основе коллекции будет массив. Кастомная коллекция должна хранить элементы разных
        классов(т.е. это generic).
        Предусмотреть операции(методы):
        1. добавления элемента
        2. удаления элемента
        3. получение элемента по индексу
        4. проверка есть ли элемент в коллекции
        5. очистка всей коллекции
        Предусмотреть конструктор без параметров - создает массив размером
        по умолчанию. Предусмотреть конструктор с задаваемым размером внутреннего
        массива. Предусмотреть возможность автоматического расширения коллекции при
        добавлении элемента в том случае, когда коллекция уже заполнена. */
        MyList<Object> list = new MyList<>();

        list.add("Кот");
        list.add("Собака");
        list.add("Лев");

        System.out.println("Элемент с индексом 1: " + list.get(1));
        System.out.println("Есть Лев? " + list.contains("Лев"));

        list.remove(1);

        System.out.println("Есть Собака? " + list.contains("Собака"));

        list.clear();

        System.out.println("Есть Кот после clear? " + list.contains("Кот"));
    }

    public static void printStudents(List<Student> students, int course) {
        for (Student s : students) {
            if (s.getCourse() == course) {
                System.out.println(s.getName());
            }
        }
    }
}
