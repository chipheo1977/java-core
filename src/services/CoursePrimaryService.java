package services;

import constant.MaxLimit;
import entity.CoursePrimary;
import utils.Helper;

import java.util.ArrayList;

public class CoursePrimaryService {
    private final ArrayList<CoursePrimary> courses;

    public CoursePrimaryService(ArrayList<CoursePrimary> courses) {
        this.courses = courses;
    }

    public ArrayList<CoursePrimary> getAll() {
        this.courses.forEach(System.out::println);
        return this.courses;
    }

    public CoursePrimary getById(int id) {
        for (CoursePrimary c : this.courses) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void add() {
        String name = Helper.inputValidName("name", MaxLimit.Length.getValue());
        int lesson = Helper.inputValidInt("lesson", MaxLimit.ID.getValue());
        float retail = Helper.inputValidFloat("retail", MaxLimit.PRICE.getValue());
        int id = Helper.randomNumber();

        CoursePrimary newCourse = new CoursePrimary(
                id,
                name,
                lesson,
                retail
        );
        this.courses.add(newCourse);

        System.out.println("Add course primary: " + name + " success!");
    }

    public void update() {
        int id = Helper.inputValidInt("student id", MaxLimit.ID.getValue());
        String name = Helper.inputValidName("name", MaxLimit.Length.getValue());
        int lesson = Helper.inputValidInt("lesson", MaxLimit.LESSON.getValue());
        float retail = Helper.inputValidFloat("retail", MaxLimit.PRICE.getValue());

        CoursePrimary c = getById(id);

        c.setName(name);
        c.setLesson(lesson);
        c.setRetail(retail);

        System.out.println("Updated course primary: " + name + " success!");
    }

    public void delete() {
        int id = Helper.inputValidInt("course id", MaxLimit.ID.getValue());
        CoursePrimary course = getById(id);
        if (course == null) {
            System.out.println("Course not found!");
        } else {
            for (CoursePrimary c : courses) {
                if (c.getId() == id) {
                    courses.remove(c);
                }
            }

            System.out.println("Deleted course primary id: " + id + " success!");
        }
    }
}
