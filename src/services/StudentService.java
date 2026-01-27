package services;

import constant.MaxLimit;
import constant.Role;
import entity.Student;
import utils.Helper;

import java.util.ArrayList;

public class StudentService {
    private final ArrayList<Student> students;

    public StudentService(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Student> getAll() {
        this.students.forEach(System.out::println);
        return this.students;
    }

    public Student getById(int id) {
        for (Student s : this.students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void add() {
        String name = Helper.inputValidName("name", MaxLimit.Length.getValue());
        int age = Helper.inputValidInt("age", MaxLimit.AGE.getValue());
        float score = Helper.inputValidFloat("score", MaxLimit.SCORE.getValue());
        Helper.wikiRole();
        int code = Helper.inputValidInt("role", 3);
        Role role = Role.fromCode(code);
        int id = Helper.randomNumber();

        Helper.isMaxNumber(age, MaxLimit.AGE.getValue(), "age");

        Student newStudent = new Student(name, age, false, score, id, role);
        this.students.add(newStudent);

        System.out.println("Add students: " + name + " success!");
    }

    public void update() {
        int id = Helper.inputValidInt("student id", MaxLimit.ID.getValue());
        String name = Helper.inputValidName("name", MaxLimit.Length.getValue());
        int age = Helper.inputValidInt("age", MaxLimit.AGE.getValue());
        float score = Helper.inputValidFloat("score", MaxLimit.SCORE.getValue());
        Helper.wikiRole();
        int code = Helper.inputValidInt("role", 3);
        Role role = Role.fromCode(code);

        Student student = getById(id);
        student.setName(name);
        student.setAge(age);
        student.setScore(score);
        student.setRole(role);

        System.out.println("Updated students: " + name + " success!");
    }

    public void delete() {
        int id = Helper.inputValidInt("student id", MaxLimit.ID.getValue());
        Student student = getById(id);

        if (student == null) {
            System.out.println("entity.Student not found!");
        } else {
            for (Student s : students) {
                if (s.getId() == id) {
                    students.remove(s);
                }
            }

            System.out.println("deleted student id: " + id + " success!");
        }
    }
}
