package Controller;

import entity.CoursePrimary;
import services.CoursePrimaryService;
import utils.Helper;

import java.util.Scanner;

public class CoursePrimaryController {

    private static final Scanner scanner = new Scanner(System.in);
    private CoursePrimaryService service;
    private Helper helper;

    public CoursePrimaryController(CoursePrimaryService service, Helper helper) {
        this.service = service;
        this.helper = helper;
    }

    public void listCourse() {
        service.getAll().forEach(System.out::println);
    }

    public void addCourse() {
        String name = helper.inputValidName();
        int lesson = helper.inputValidInt("lesson", 100);
        float retail = helper.inputValidFloat("retail", 1000);
        int id = helper.randomNumber();

        CoursePrimary newCourse = new CoursePrimary(id, name, lesson, retail);
        service.add(newCourse);

        System.out.println("Add course: " + name + " success!");
    }

    public void deleteCourseById() {
        int id = Helper.inputValidInt("course id", 100);

        this.service.delete(id);
    }

    public void update() {
        int id = Helper.inputValidInt("student id", 100);
        String name = helper.inputValidName();
        int lesson = helper.inputValidInt("lesson", 1000);
        float retail = helper.inputValidFloat("retail", 99999);

        CoursePrimary newCourse = new CoursePrimary(id, name, lesson, retail);
        service.update(id, newCourse);
    }

    public void managementCourse() {
        int choice;
        do {
            System.out.println("===== MENU course =====");
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
                    System.out.println("Option 1: list courses");
                    this.listCourse();
                    break;
                case 2:
                    System.out.println("Option 2: add course");
                    this.addCourse();
                    break;
                case 3:
                    System.out.println("Option 3: edit course");
                    this.update();
                    break;
                case 4:
                    System.out.println("Options 4: delete course");
                    this.deleteCourseById();
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
