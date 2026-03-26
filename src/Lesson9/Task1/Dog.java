package Lesson9.Task1;

import java.util.List;

public class Dog extends Animal{
    private List<String> favoriteFood = List.of("meat", "rabbit", "vegetable");

    private Dog() {}

    public static Dog create() {
        return new Dog();
    }

    public void voice() {
        System.out.println("Звуки дога");
    }

    public String eat(String food){
        if (favoriteFood.contains(food.toLowerCase()))
            return "Собака любит кушать: " + food;
        return "Собака не кушает: " +  food;
    }
}
