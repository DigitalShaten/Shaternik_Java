package Lesson10;

import java.util.Objects;

public class User implements Cloneable{
    private String name;
    private int age;
    private String email;
    protected MobilePhone mobilePhone;

    public User(String name, int age, String email, MobilePhone mobilePhone) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.mobilePhone = mobilePhone;
    }

    // Переопределение toString
    @Override
    public String toString() {
        return "Пользователь { " +
                "имя = '" + name + '\'' +
                ", возраст = " + age +
                ", email = '" + email + '\'' +
                ", телефон = '" + mobilePhone + '\'' +
                '}';
    }

    // Переопределение equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email);
    }

    // Переопределение hashCode
    @Override
    public int hashCode() {
        return Objects.hash(name, age, email);
    }

    // Shallow clone - клонирование ссылки
    @Override
    protected User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }

    // Deep clone - глубокое клонирование
    public User deepClone() {
        return new User(
                this.name,
                this.age,
                this.email,
                new MobilePhone (this.mobilePhone.model)
        );
    }
}
