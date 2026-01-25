package entity;

public class Person {
    private String name;
    private int age;
    private boolean isDied;

    public Person(String name, int age, boolean isDied) {
        this.name = name;
        this.age = age;
        this.isDied = isDied;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDied() {
        return isDied;
    }

    public void setDied(boolean died) {
        isDied = died;
    }
}
