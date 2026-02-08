package services;

import entity.CourseSecondary;
import exception.AppException;
import exception.NotFoundException;
import utils.CourseHelper;
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
        try {
            int id = Helper.randomNumber();
            String name = CourseHelper.enterName();
            int lesson = CourseHelper.enterLesson();
            float retail = CourseHelper.enterPrice();

            CourseSecondary newCourse = new CourseSecondary(
                    id,
                    name,
                    lesson,
                    retail
            );
            this.courses.add(newCourse);

            System.out.println("Add secondary course: " + name + " success!");
        } catch (Exception e) {
            System.out.println("System error");
        }

    }

    public void update() {
        try {
            int id = CourseHelper.enterId();
            String name = CourseHelper.enterName();
            int lesson = CourseHelper.enterLesson();
            float retail = CourseHelper.enterPrice();

            CourseSecondary course = getById(id);
            if (course == null) {
                throw new NotFoundException("course");
            }

            course.setName(name);
            course.setLesson(lesson);
            course.setRetail(retail);

            System.out.println("Updated secondary course: " + name + " success!");
        } catch (AppException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("System error");
        }
    }

    public void delete() {
        try {
            int id = CourseHelper.enterId();

            CourseSecondary course = getById(id);
            if (course == null) {
                throw new NotFoundException("course");
            }

            courses.removeIf(c -> c.getId() == id);
            System.out.println("deleted secondary course id: " + id + " success!");
        } catch (AppException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("System error");
        }

    }
}
