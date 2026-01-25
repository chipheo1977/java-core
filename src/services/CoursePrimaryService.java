package services;

import entity.CoursePrimary;

import java.util.ArrayList;

public class CoursePrimaryService {
    private final ArrayList<CoursePrimary> courses;

    public CoursePrimaryService(ArrayList<CoursePrimary> courses) {
        this.courses = courses;
    }

    public ArrayList<CoursePrimary> getAll() {
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

    public void add(CoursePrimary course) {
        CoursePrimary newCourse = new CoursePrimary(
                course.getId(),
                course.getName(),
                course.getLesson(),
                course.getRetail()
        );
        this.courses.add(newCourse);
    }

    public void update(int id, CoursePrimary c) {
        CoursePrimary course = getById(id);
        course.setName(c.getName());
        course.setLesson(c.getLesson());
        course.setRetail(c.getRetail());
        course.setId(c.getId());
    }

    public void delete(int id) {
        CoursePrimary course = getById(id);
        if (course == null) {
            System.out.println("Course not found!");
        } else {
            for (CoursePrimary c : courses) {
                if (c.getId() == id) {
                    courses.remove(c);
                }
            }

            System.out.println("deleted course id: " + id + " success!");
        }
    }
}
