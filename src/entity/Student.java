package entity;

import constant.Role;

public class Student extends Person {

    private int id;
    private float score;
    private Role role;

    public float getScore() {
        return score;
    }

    public int getId() {
        return this.id;
    }

    public Role getRole() {
        return this.role;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Student(String name, int age, boolean isDied, float score, Role role) {
        super(name, age, isDied);
        this.score = score;
        this.role = role;
    }

    public Student(String name, int age, boolean isDied, float score, int id, Role role) {
        super(name, age, isDied);
        this.score = score;
        this.role = role;
        this.id = id;
    }


    @Override
    public String toString() {
        return "Student: " + getName() +
                ", " +
                "score: " + score +
                ", " +
                "age: " + getAge() +
                ", " +
                "status: " + (isDied() ? "died" : "alive") +
                ", " +
                "id: " + this.id +
                ", " +
                "role: " + this.role;
    }
}
