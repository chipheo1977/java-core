package controller;

import services.CourseSecondaryService;

import java.util.Scanner;

public class CourseSecondaryController {

    private static final Scanner scanner = new Scanner(System.in);
    private final CourseSecondaryService service;

    public CourseSecondaryController(CourseSecondaryService service) {
        this.service = service;
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
                    service.getAll();
                    break;
                case 2:
                    System.out.println("Option 2: add course");
                    service.add();
                    break;
                case 3:
                    System.out.println("Option 3: edit course");
                    service.update();
                    break;
                case 4:
                    System.out.println("Options 4: delete course");
                    service.delete();
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
