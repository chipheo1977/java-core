package services;

import constant.FileConstant;
import constant.Role;
import entity.CoursePrimary;
import entity.Student;
import exception.AppException;
import exception.NotFoundException;
import utils.CourseHelper;
import utils.FileHelper;
import utils.Helper;
import utils.StudentHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
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
                throw new NotFoundException("student");
            }

            System.out.println(lowestStudent);
        } catch (AppException e) {
            System.out.println(e.getMessage());
        }
    }

    private Map.Entry<String, String> buildMapStudentByCourse(Integer courseId, Student student, Map<Integer, String> mapCourseByNames) {
        return Map.entry(mapCourseByNames.get(courseId), student.getName());
    }

    public void listStudentByCourse() {
        try {
            Set<Integer> courseIds = students
                    .stream()
                    .flatMap(it -> it.getCourseIds().stream()).collect(Collectors.toSet());
            Map<Integer, String> mapCourseByNames = courseService.getMapCourseNameByIds(courseIds);

            Map<String, List<String>> mapStudents = students.stream()
                    .flatMap(student -> student
                            .getCourseIds()
                            .stream()
                            .map(courseId -> buildMapStudentByCourse(courseId, student, mapCourseByNames)))
                    .collect(Collectors.groupingBy(
                            Map.Entry::getKey,
                            Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                    ));

            System.out.println("5:" + mapStudents);

        } catch (AppException e) {
            System.out.println(e.getMessage());
        }
    }

    public void findStudentHighestScoreByCourse() {
        try {
            int id = CourseHelper.enterId();
            CoursePrimary found = courseService.getById(id);

            if (found == null) {
                throw new NotFoundException("course");
            }

            Set<Integer> courseIds = students
                    .stream()
                    .flatMap(it -> it.getCourseIds().stream()).collect(Collectors.toSet());
            Map<Integer, String> mapCourseByNames = courseService.getMapCourseNameByIds(courseIds);

            Map<Integer, List<Student>> mapStudentsByCourse = students.stream()
                    .flatMap(student -> student
                            .getCourseIds()
                            .stream()
                            .map(courseId -> Map.entry(courseId, student)))
                    .collect(Collectors.groupingBy(
                            Map.Entry::getKey,
                            Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                    ));

            List<Student> studentByCourse = mapStudentsByCourse.get(found.getId());

            List<Student> studentsHighestScore = studentByCourse
                    .stream()
                    .sorted(Comparator.comparing(Student::getScore).reversed())
                    .limit(2)
                    .toList();

            studentsHighestScore.forEach(System.out::println);

        } catch (AppException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("System Error");
        }
    }

    public void sortByAsc() {
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

    public void sortByDesc() {
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

    public synchronized void autoUpdateScore(int id) {
        try {
            Student student = getById(id);

            float currentScore = student.getScore();
            currentScore = currentScore + 1;

            student.setScore(currentScore);
        } catch (AppException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error system");
        }
    }

    public void transferScore(int fromId, int toId) {
        try {
            Student from = getById(fromId);
            Student to = getById(toId);

            synchronized (from) {

                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (to) {
                    from.setScore(from.getScore() - 1);
                    to.setScore(to.getScore() + 1);
                }
            }
        } catch (AppException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error system");
        }
    }

    public void delete() {
        try {
            int id = StudentHelper.enterId();
            Student student = getById(id);

            if (student == null) {
                throw new NotFoundException("student");
            }

            students.removeIf(s -> s.getId() == id);
            System.out.println("deleted student id: " + id + " success!");
        } catch (AppException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error system");
        }

    }

    public void exportToFile() {
        try {
            Path path = FileHelper.getPath(FileConstant.STUDENTS_PATH);
            if (!Files.exists(path)) {
                throw new NotFoundException("File");
            }

            List<Student> studentsExport = students
                    .stream()
                    .sorted(Comparator.comparing(Student::getScore))
                    .limit(3)
                    .toList();
            List<String> lines = studentsExport.stream()
                    .map(item -> item.getId() + " " + item.getName())
                    .toList();

            FileHelper.writeFile(path, lines);
            System.out.println("Export success");
        } catch (AppException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
