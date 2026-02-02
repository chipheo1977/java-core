package services;

import constant.MaxLimit;
import entity.CourseSecondary;
import utils.Helper;

import java.util.ArrayList;

public class CourseSecondaryService {

    private final ArrayList<CourseSecondary> courses;

    public CourseSecondaryService(ArrayList<CourseSecondary> courses) {
        this.courses = courses;
    }

    public ArrayList<CourseSecondary> getAll() {
        courses.forEach(System.out::println);
        return this.courses;
    }

    public CourseSecondary getById(int id) {
        for (CourseSecondary c : this.courses) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void add() {
        String name = Helper.inputValidName("name", MaxLimit.Length.getValue());
        int lesson = Helper.inputValidInt("lesson", MaxLimit.LESSON.getValue());
        float retail = Helper.inputValidFloat("retail", MaxLimit.PRICE.getValue());
        int id = Helper.randomNumber();

        CourseSecondary newC = new CourseSecondary(
                id,
                name,
                lesson,
                retail
        );
        this.courses.add(newC);

        System.out.println("Add secondary course: " + name + " success!");
    }

    public void update() {
        int value = MaxLimit.ID.getValue();
        int id = Helper.inputValidInt("Student id", value);
        String name = Helper.inputValidName("name", MaxLimit.Length.getValue());
        int lesson = Helper.inputValidInt("lesson", MaxLimit.LESSON.getValue());
        float retail = Helper.inputValidFloat("retail", MaxLimit.PRICE.getValue());

        CourseSecondary course = getById(id);
        course.setName(name);
        course.setLesson(lesson);
        course.setRetail(retail);

        System.out.println("Updated secondary course: " + name + " success!");
    }

    public void delete() {
        int id = Helper.inputValidInt("course id", MaxLimit.ID.getValue());

        CourseSecondary course = getById(id);

        // TODO: Nên sử dụng retun thay vì if else
        if (course == null) {
            System.out.println("Course not found!");
        } else {
            for (CourseSecondary c : courses) {
                if (c.getId() == id) {
                    courses.remove(c);
                }
            }

            System.out.println("deleted secondary course id: " + id + " success!");
        }
    }
}
