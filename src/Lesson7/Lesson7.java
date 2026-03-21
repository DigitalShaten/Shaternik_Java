package Lesson7;

import Lesson7.Task1.*;
import Lesson7.Task2.*;
import Lesson7.Task3.Person;

/**
 * Домашнее задание №7
 * @author Nikita Shaternik
 * 22.03.2026
 */

public class Lesson7 {
    public static void main(String[] args) throws CloneNotSupportedException{
        /*Задача 1:
        Создать классы "Директор", "Рабочий", "Бухгалтер". Реализовать интерфейс с методом,
        который печатает название должности и имплементировать этот метод в созданные
        классы.*/
        System.out.println("Задание 1");
        Director director = new Director();
        Accountant accountant = new Accountant();
        Worker worker = new Worker();

        director.jobTitle();
        accountant.jobTitle();
        worker.jobTitle();

        System.out.println();
        /*Задача 2:
        Написать иерархию классов Фигура, Треугольник, Прямоугольник, Круг. Реализовать
        функцию подсчета площади для каждого типа фигуры и подсчет периметра(используя
        абстрактный класс/методы). Создать массив из 5 разных фигур. Вывести на экран сумму
        периметра всех фигур в массиве.*/
        System.out.println("Задание 2");
        Figure circleFirst = new Circle(5);
        Figure circleSecond = new Circle(3);
        Figure triangleFirst = new Triangle(7,6,4);
        Figure triangleSecond = new Triangle(5,3,3);
        Figure rectangle = new Rectangle(2,4);


        Figure[] figures = {circleFirst, triangleFirst, rectangle, circleSecond, triangleSecond};
        double resultOfAllPerimeters = 0;
        for (Figure figure : figures) {
            resultOfAllPerimeters += figure.perimeter();
        }
        System.out.printf("Сумма периметров всех фигур в массиве - %.2f%n", resultOfAllPerimeters);

        System.out.println();
        /*Задача *:
        Самостоятельно изучить и показать пример работы интерфейса-маркера Cloneable.*/
        System.out.println("Задание 3");
        Person ivan = new Person( "Иван", 21);
        Person ivanClone = (Person) ivan.clone();

        ivan.printInfo();
        ivanClone.printInfo();
    }
}
