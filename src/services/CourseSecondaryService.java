package services;

import entity.CoursePrimary;
import entity.CourseSecondary;

import java.util.ArrayList;

public class CourseSecondaryService {
    private final ArrayList<CourseSecondary> courses;

    public CourseSecondaryService(ArrayList<CourseSecondary> courses) {
        this.courses = courses;
    }

    public ArrayList<CourseSecondary> getAll() {
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

    public void add(CourseSecondary course) {
        CourseSecondary newCourse = new CourseSecondary(
                course.getId(),
                course.getName(),
                course.getLesson(),
                course.getRetail()
        );
        this.courses.add(newCourse);
    }

    public void update(int id, CourseSecondary c) {
        CourseSecondary course = getById(id);
        course.setName(c.getName());
        course.setLesson(c.getLesson());
        course.setRetail(c.getRetail());
        course.setId(c.getId());
    }

    public void delete(int id) {
        CourseSecondary course = getById(id);
        if (course == null) {
            System.out.println("Course not found!");
        } else {
            for (CourseSecondary c : courses) {
                if (c.getId() == id) {
                    courses.remove(c);
                }
            }

            System.out.println("deleted course id: " + id + " success!");
        }
    }
}
