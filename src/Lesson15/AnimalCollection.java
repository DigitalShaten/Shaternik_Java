package Lesson15;

import java.util.LinkedList;

public class AnimalCollection {
    private final LinkedList<String> animals = new LinkedList<>();

    public void add(String animal) {
        if (animal == null || animal.isBlank()) return;
        animals.addFirst(animal);
    }

    public String remove() {
        if (animals.isEmpty()) return null;
        return animals.removeLast();
    }

    public void printAll() {
        System.out.println(String.join(", ", animals));
    }
}
