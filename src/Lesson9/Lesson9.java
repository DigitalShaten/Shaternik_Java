package Lesson9;

import Lesson8.Task2.Apple;
import Lesson9.Task1.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Lesson9 {
    public static void main(String[] args) {

        /*Задача 1:
        Создать логически верную иерархию следующих классов: Animal, Dog, Tiger, Rabbit.
        Переопределить методы voice(), eat(String food) чтобы они выводили верную
        информацию. Метод eat может принимать “Meat”, “Grass” и другие строки.
        Например, еслки мы создадим объет класса Rabbit, вызовем метод eat() и передадим
        туда “Grass” он должен написать в консоли что любит есть травку. Если передадим “Meat” или другую строку то он будет недоволен. */
        Animal rabbit = new Rabbit();
        Animal tiger = new Tiger();
        Animal dog = Dog.create(); // для задания со звездочкой
        List<String> food = Arrays.asList("Meat", "Grass", "Vegetable", "Rabbit");
        Random random = new Random();

        int foodNumber = random.nextInt(food.size());
        String foodName = food.get(foodNumber);
        System.out.println(rabbit.eat(foodName));

        foodNumber = random.nextInt(food.size());
        foodName = food.get(foodNumber);
        System.out.println(tiger.eat(foodName));

        foodNumber = random.nextInt(food.size());
        foodName = food.get(foodNumber);
        System.out.println(dog.eat(foodName));


        /*Задача *:
        Написать такой конструктор, который запретит создание объекта класса Dog в других
        классах; Найти способ вызывать методы voice(), eat() класса Dog, который позволит
        обойти ограничение, наложенное конструктором выше. Объяснить, как работают оба
        способа.*/

        // основное решение - создать private конструктор, а дога создавать через фабричный метод (публичный метод, возвращающий нового дога)
        // можно было через рефлексию
        System.out.println();
        try {
            Constructor<Dog> constructor = Dog.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Dog dogPrivate = constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException |
                 InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("Задача со звездочкой");
        foodNumber = random.nextInt(food.size());
        foodName = food.get(foodNumber);
        System.out.println(dog.eat(foodName));

    }
}
