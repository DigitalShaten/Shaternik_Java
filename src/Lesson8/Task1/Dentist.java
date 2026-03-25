    package Lesson8.Task1;

    public class Dentist extends Doctor{
        public static final int DENTIST = 2;

        @Override
        public void heal() {
            System.out.println("Лечим зубы.");
        }
    }
