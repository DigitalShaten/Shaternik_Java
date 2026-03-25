package Lesson7.Task3;

public class Person implements Cloneable{
    private final String name;
    private final int age;

    public Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void printInfo() {
        System.out.println("Меня зовут " + name + ". Мне " + age + ".");
    }
}
