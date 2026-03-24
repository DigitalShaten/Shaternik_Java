package Lesson8;

import Lesson8.Task1.*;
import Lesson8.Task2.Apple;

import java.lang.reflect.Field;
import java.util.Scanner;

/**
 * Домашнее задание №8
 * @author Nikita Shaternik
 * 24.03.2026
 */

public class Lesson8 {
    public static void main(String[] args) {
        /*Задача 1:
        Создать программу для имитации работы клиники. Пусть в клинике будет три врача:
        хирург, терапевт и дантист. Каждый врач имеет метод «лечить», но каждый врач лечит
        по-своему. Так же предусмотреть класс «Пациент» с полем «План лечения» и полем
        «Доктор». Создать объект класса «Пациент» и добавить пациенту план лечения. У
        терапевта создать метод, который будет назначать врача пациенту согласно плану
        лечения:
        Если план лечения имеет код 1 – назначить хирурга и выполнить метод лечить.
        Если план лечения имеет код 2 – назначить дантиста и выполнить метод лечить.
        Если план лечения имеет любой другой код – назначить терапевта и выполнить метод
        лечить. */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Задание 1");
        System.out.println("Выбор направления:");
        System.out.println("1. Хирург");
        System.out.println("2. Дантист");
        System.out.println("3. Терапевт");
        System.out.println("Введите план лечения:");
        int plan = scanner.nextInt();

        Patient patient = new Patient("Иван", plan);

        Therapist therapist = new Therapist();

        System.out.println("Поступил пациент " + patient.getName() +".");
        therapist.assignDoctor(patient);
        System.out.println(patient.getDoctor().getClass().getSimpleName());

        /*Задача *:
        Создать класс Apple и добавить в него поле color с модификатором доступа private и
        инициализировать его. В методе main другого класса создать объект Apple, и не
        используя сеттеры изменить значение поля color.*/
        System.out.println("------------------------");
        System.out.println("Задание 2");
        try {
            Apple apple = new Apple();

            apple.getColor();

            Field field = Apple.class.getDeclaredField("color");
            field.setAccessible(true);
            field.set(apple, "Green");

            System.out.println(field.get(apple));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
