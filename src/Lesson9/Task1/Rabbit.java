package Lesson9.Task1;

import java.util.List;

public class Rabbit extends Animal{
    private List<String> favoriteFood = List.of("grass", "vegetable");

    public void voice() {
        System.out.println("Звуки рэббита");
    }

    public String eat(String food){
        if (favoriteFood.contains(food.toLowerCase()))
            return "Зайчик любит кушать: " + food;
        return "Зайчик не кушает: " + food;
    }
}
