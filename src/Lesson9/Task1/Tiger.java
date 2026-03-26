package Lesson9.Task1;

import java.util.List;

public class Tiger extends Animal{
    private List<String> favoriteFood = List.of("meat", "rabbit");

    @Override
    public void voice() {
        System.out.println("Звуки тигера");
    }

    @Override
    public String eat(String food){
        if (favoriteFood.contains(food.toLowerCase()))
            return "Тигр любит кушать: " + food;
        return "Тигр не кушает: " + food;
    }
}
