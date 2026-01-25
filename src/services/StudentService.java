package services;

import entity.Student;

import java.util.ArrayList;

public class StudentService {
    private final ArrayList<Student> students;

    public StudentService(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Student> getAll() {
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

    public Student add(Student st) {
        Student newStudent = new Student(st.getName(), st.getAge(), st.isDied(),  st.getScore(), st.getId());
        this.students.add(newStudent);
        return newStudent;
    }

    public void update(int id, Student st) {
        Student student = getById(id);
        student.setName(st.getName());
        student.setAge(st.getAge());
        student.setDied(st.isDied());
        student.setScore(st.getScore());
        student.setId(st.getId());
    }

    public void delete(int id) {
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
