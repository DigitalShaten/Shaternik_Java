package Lesson8.Task1;

public class Patient {
    private String name;
    private int typeHeal;
    private Doctor doctor;

    public Patient(String name, int typeHeal) {
        this.name = name;
        this.typeHeal = typeHeal;
    }

    public String getName() {
        return name;
    }

    public int getTypeHeal() {
        return typeHeal;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
