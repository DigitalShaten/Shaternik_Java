package Lesson7.Task2;

public class Circle extends Figure{
    private final int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*Math.pow(radius,2);
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public void printFigure() {
        System.out.printf("Я - круг, мой радиус - %d, моя площадь - %.2f, мой периметр - %.2f%n", radius, area(), perimeter());
    }
}
