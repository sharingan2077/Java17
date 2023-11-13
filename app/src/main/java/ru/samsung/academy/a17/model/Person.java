package ru.samsung.academy.a17.model;

public class Person {

    private String name;
    private int age;
    private boolean isMale;

    private int avatar;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getAvatar() {
        return avatar;
    }

    public Person(String name, int age, boolean isMale, int avatar) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.avatar = avatar;
    }
}
