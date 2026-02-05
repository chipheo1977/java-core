package services;

import constant.Role;
import entity.CoursePrimary;
import entity.Student;
import exception.AppException;
import exception.NotFoundException;
import utils.CourseHelper;
import utils.Helper;
import utils.StudentHelper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentService {
    private final ArrayList<Student> students;
    private final CoursePrimaryService courseService;

    public StudentService(ArrayList<Student> students, CoursePrimaryService courseService) {
        this.students = students;
        this.courseService = courseService;
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

    public void findLowestScore() {
        try {
            Student lowestStudent = students
                    .stream()
                    .min(Comparator.comparing(Student::getScore)).orElse(null);

            if (lowestStudent == null) {
                throw new NotFoundException(); // TODO: ro rang hon
            }

            System.out.println(lowestStudent);
        } catch (AppException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listStudentByCourse() {
        try {

            // 1. Can course name -> service khac
            // Giam so luong data can lay
            Set<Integer> courseIds = students.stream().flatMap(it -> it.getCourseIds().stream()).collect(Collectors.toSet());
            Map<Integer, String> mapCourseByNames = courseService.getMapCourseNameByIds(courseIds);

            // 2. group
            Map<String, List<String>> mapStudents = students.stream()
                    .flatMap(student -> student.getCourseIds().stream().map(courseId -> buildMapStudentByCourse(courseId, student, mapCourseByNames))
                    ).collect(Collectors.groupingBy(
                            Map.Entry::getKey,
                            Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                    ));

            System.out.println(mapStudents);
        } catch (AppException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Map.Entry<String, String> buildMapStudentByCourse(Integer courseId, Student student, Map<Integer, String> mapCourseByNames) {
        return Map.entry(mapCourseByNames.get(courseId), student.getName());
    }


    public void findStudentHighestScoreByCourse() {
        try {
            //TODO:  nen nhap id
            String courseName = CourseHelper.enterName();
            CoursePrimary found = courseService.getByName(courseName);

            if (found == null) {
                throw new NotFoundException(); // TODO: error can ro rang hon
            }

            // TODO: Refactor
            Map<Integer, List<Student>> mapStudents = students.stream()
                    .flatMap(student -> student.getCourseIds().stream()
                            .map(
                                    courseId -> Map.entry(
                                            courseId,
                                            student
                                    )
                            )
                    ).collect(Collectors.groupingBy(
                            Map.Entry::getKey,
                            Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                    ));

            //
            List<Student> studentByCourse = mapStudents.get(found.getId());

            List<Student> studentsHighestScore = studentByCourse
                    .stream()
                    .sorted(Comparator.comparing(Student::getScore).reversed())
                    .limit(1)
                    .toList();

            studentsHighestScore.forEach(System.out::println);

        } catch (AppException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("System Error");
        }
    }

    public void sortIncrease() {
        try {
            List<Student> sortStudents = students
                    .stream()
                    .sorted(Comparator.comparing(Student::getScore))
                    .toList();
            sortStudents.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("System Error");
        }
    }

    public void sortDecrease() {
        try {
            List<Student> sortStudents = students
                    .stream()
                    .sorted(Comparator.comparing(Student::getScore).reversed())
                    .toList();
            sortStudents.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("System Error");
        }
    }

    public void add() {
        try {
            int id = Helper.randomNumber();
            String name = StudentHelper.enterName();
            int age = StudentHelper.enterAge();
            float score = StudentHelper.enterScore();
            Role role = StudentHelper.enterRole();

            Student newStudent = new Student(id, name, age, false, score, role);

            this.students.add(newStudent);
            System.out.println("Add students: " + name + " success!");

        } catch (Exception e) {
            System.out.println("Error system");
        }
    }

    public void update() {
        try {
            int id = StudentHelper.enterId();
            String name = StudentHelper.enterName();
            int age = StudentHelper.enterAge();
            float score = StudentHelper.enterScore();
            Role role = StudentHelper.enterRole();

            Student student = getById(id);
            student.setName(name);
            student.setAge(age);
            student.setScore(score);
            student.setRole(role);

            System.out.println("Updated students: " + name + " success!");
        } catch (Exception e) {
            System.out.println("Error system");
        }

    }

    public void delete() {
        try {
            int id = StudentHelper.enterId();
            Student student = getById(id);

            if (student == null) {
                throw new NotFoundException();
            }

            students.removeIf(s -> s.getId() == id);
            System.out.println("deleted student id: " + id + " success!");
        } catch (AppException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error system");
        }

    }
}
