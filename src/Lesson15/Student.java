package Lesson15;

import java.util.ArrayList;
import java.util.List;

/* Задача 3:
        Создать класс Student, содержащий следующие характеристики – имя, группа, курс,
        оценки по предметам. Создать коллекцию, содержащую объекты класса Student.
        Написать метод, который удаляет студентов со средним баллом <3. Если средний
        балл>=3, студент переводится на следующий курс. Дополнительно написать метод
        printStudents(List<Student> students, int course), который получает список студентов и
        номер курса. А также печатает на консоль имена тех студентов из списка, которые
        обучаются на данном курсе. */
public class Student {
    private String name;
    private String groupNumber;
    private int course;
    private List<Integer> grades;

    public Student(String name, String groupNumber, int course, List<Integer> grades) {
        this.name = name;
        this.groupNumber = groupNumber;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public boolean isGoodStudent() {
        return getAverageGrade() >= 3.0;
    }

    public void increaseCourse() {
        this.course++;
    }

    public String getName() {
        return name;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public int getCourse() {
        return course;
    }

    public List<Integer> getGrades() {
        return grades;
    }

}
