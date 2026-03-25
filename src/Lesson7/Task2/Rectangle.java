package Lesson7.Task2;

public class Rectangle extends Figure{
    private final int height;
    private final int width;

    public Rectangle (int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double area() {
        return height*width;
    }

    @Override
    public double perimeter() {
        return 2*(height+width);
    }

    @Override
    public void printFigure() {
        System.out.printf("Я - прямоугольник, мои стороны - %d, %d, моя площадь - %.2f, мой периметр - %.2f%n", height, width, area(), perimeter());
    }
}
