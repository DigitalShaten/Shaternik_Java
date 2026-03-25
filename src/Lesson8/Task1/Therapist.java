package Lesson8.Task1;

import static Lesson8.Task1.Dentist.DENTIST;
import static Lesson8.Task1.Surgeon.SURGEON;

public class Therapist extends Doctor{

    @Override
    public void heal() {
        System.out.println("Лечим симптомы.");
    }

    public void assignDoctor(Patient patient) {
        int plan = patient.getTypeHeal();
        Doctor doctor;

        if (plan == SURGEON) {
            doctor = new Surgeon();
            System.out.println("Назначен хирург.");
        } else if (plan == DENTIST) {
            doctor = new Dentist();
            System.out.println("Назначен дантист.");
        } else {
            doctor = this;
            System.out.println("Назначен терапевт.");
        }

        patient.setDoctor(doctor);
        doctor.heal();
    }
}
