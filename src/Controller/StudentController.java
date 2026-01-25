package Controller;

import entity.Student;
import services.StudentService;
import utils.Helper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentController {
    private static Scanner scanner = new Scanner(System.in);
    private StudentService service;
    private Helper helper;

    public StudentController(StudentService service, Helper helper) {
        this.service = service;
        this.helper = helper;
    }

    public void listStudents() {
        service.getAll().forEach(System.out::println);
    }

    public void updateStudent() {
        try {
            System.out.print("Please enter student id: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter name:");
            String name = scanner.nextLine();

            System.out.print("Enter age:");
            int age = scanner.nextInt();

            System.out.print("Enter score:");
            float score = scanner.nextFloat();

            Student stUpdated = new Student(name, age, false, score, id);
            service.update(id, stUpdated);
        } catch (InputMismatchException e) {
            System.out.println("Enter wrong format!");
        }
    }

    public void deleteStudentById() {
        int id = Helper.inputValidInt("student id", 100);

        this.service.delete(id);
    }

    public void addStudent() {
        String name = helper.inputValidName();
        int age = helper.inputValidInt("age", 100);
        float score = helper.inputValidFloat("score", 10);
        int id = helper.randomNumber();

        Student newStudent = new Student(name, age, false, score, id);
        service.add(newStudent);

        System.out.println("Add students: " + name + " success!");
    }

    public void managementStudent() {
        int choice;
        do {
            System.out.println("===== MENU student =====");
            System.out.println("1. list");
            System.out.println("2. add");
            System.out.println("3. edit");
            System.out.println("4. delete");
            System.out.println("5. exit!");
            System.out.print("select option (1-5): ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Option 1: list students");
                    this.listStudents();
                    break;
                case 2:
                    System.out.println("Option 2: add student");
                    this.addStudent();
                    break;
                case 3:
                    System.out.println("Option 3: edit student");
                    this.updateStudent();
                    break;
                case 4:
                    System.out.println("Options 4: delete student");
                    this.deleteStudentById();
                    break;
                case 5:
                    scanner.close();
                    break;
                default:
                    System.out.println("Wrong options, please select 1–5.");
            }
        } while (choice != 5);
    }
}
