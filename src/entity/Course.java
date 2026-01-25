package entity;

public abstract class Course {

    protected int id;
    protected String name;
    protected int lesson;
    protected double retail;

    public Course(int id, String name, int lesson, double retail) {
        this.id = id;
        this.name = name;
        this.lesson = lesson;
        this.retail = retail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLesson() {
        return lesson;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }

    public double getRetail() {
        return retail;
    }

    public void setRetail(double retail) {
        this.retail = retail;
    }

    public abstract double calculatePrice();
}
