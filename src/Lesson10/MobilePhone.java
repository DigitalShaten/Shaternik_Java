package Lesson10;

public class MobilePhone {
    protected String model;

    public MobilePhone(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return model;
    }
}
