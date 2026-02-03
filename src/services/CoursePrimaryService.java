package services;

import entity.CoursePrimary;
import exception.AppException;
import exception.NotFoundException;
import utils.CourseHelper;
import utils.Helper;

import java.util.ArrayList;
import java.util.Objects;

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
        for (CoursePrimary course : this.courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public CoursePrimary getByName(String name) {
        for (CoursePrimary course : this.courses) {
            if (Objects.equals(course.getName(), name)) {
                return course;
            }
        }
        return null;
    }

    public void add() {
        try {
            int id = Helper.randomNumber();
            String name = CourseHelper.enterName();
            int lesson = CourseHelper.enterLesson();
            float retail = CourseHelper.enterPrice();

            CoursePrimary newCourse = new CoursePrimary(
                    id,
                    name,
                    lesson,
                    retail
            );
            this.courses.add(newCourse);

            System.out.println("Add course primary: " + name + " success!");
        } catch (Exception e) {
            System.out.println("Error system");
        }
    }

    public void update() {
        try {
            int id = CourseHelper.enterId();
            String name = CourseHelper.enterName();
            int lesson = CourseHelper.enterLesson();
            float retail = CourseHelper.enterPrice();

            CoursePrimary course = getById(id);
            if (course == null) {
                throw new NotFoundException();
            }

            course.setName(name);
            course.setLesson(lesson);
            course.setRetail(retail);

            System.out.println("Updated course primary: " + name + " success!");
        } catch (AppException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error system");
        }

    }

    public void delete() {
        try {
            int id = CourseHelper.enterId();
            CoursePrimary course = getById(id);
            if (course == null) {
                throw new NotFoundException();
            }

            courses.removeIf(c -> c.getId() == id);
            System.out.println("Deleted course primary id: " + id + " success!");
        } catch (AppException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("System error");
        }
    }
}
