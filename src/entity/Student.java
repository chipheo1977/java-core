package entity;

import constant.Role;

import java.util.List;
import java.util.stream.Collectors;

public class Student extends Person {

    private int id;
    private float score;
    private Role role;
    private List<Integer> courseIds;

    public List<Integer> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<Integer> courseIds) {
        this.courseIds = courseIds;
    }

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

    public Student(String name, int age, boolean isDied, float score, Role role, List<Integer> courseIds) {
        super(name, age, isDied);
        this.score = score;
        this.role = role;
        this.courseIds = courseIds;
    }

    public Student(String name, int age, boolean isDied, float score, int id, Role role, List<Integer> courseIds) {
        super(name, age, isDied);
        this.score = score;
        this.role = role;
        this.id = id;
        this.courseIds = courseIds;
    }

    public Student(int id, String name, int age, boolean isDied, float score, Role role) {
        super(name, age, isDied);
        this.id = id;
        this.score = score;
        this.role = role;
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
                "role: " + this.role +
                ", " +
                "course ids: " + courseIds.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}
