package Lesson8.Task1;

public class Surgeon extends Doctor{
    public static final int SURGEON = 1;

    @Override
    public void heal() {
        System.out.println("Лечим хирургически.");
    }
}
