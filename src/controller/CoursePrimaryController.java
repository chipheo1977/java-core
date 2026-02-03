package controller;

import services.CoursePrimaryService;
import utils.Helper;

public class CoursePrimaryController {

    private final CoursePrimaryService service;

    public CoursePrimaryController(CoursePrimaryService service) {
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

            choice = Helper.scanner.nextInt();
            Helper.scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Option 1: list courses");
                    this.service.getAll();
                    break;
                case 2:
                    System.out.println("Option 2: add course");
                    this.service.add();
                    break;
                case 3:
                    System.out.println("Option 3: edit course");
                    this.service.update();
                    break;
                case 4:
                    System.out.println("Options 4: delete course");
                    this.service.delete();
                    break;
                case 5:
                    Helper.scanner.close();
                    break;
                default:
                    System.out.println("Wrong options, please select 1–5.");
            }
        } while (choice != 5);
    }
}
