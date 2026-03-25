package Lesson7.Task2;

public class Triangle extends Figure{
    private final int sideA;
    private final int sideB;
    private final int sideC;

    public Triangle(int sideA, int sideB, int sideC) {
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            throw new IllegalArgumentException("Такого треугольника не существует");
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double area() {
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public double perimeter() {
        return sideA+sideB+sideC;
    }

    @Override
    public void printFigure() {
        System.out.printf("Я - треугольник, мои стороны - %d, %d, %d, моя площадь - %.2f, мой периметр - %.2f%n", sideA, sideB, sideC, area(), perimeter());
    }
}
