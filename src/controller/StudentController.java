package controller;

import services.StudentService;
import utils.Helper;

public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    public void managementStudent() {
        int choice;
        do {
            System.out.println("===== MENU student =====");
            System.out.println("1. list");
            System.out.println("2. add");
            System.out.println("3. edit");
            System.out.println("4. delete");
            System.out.println("5. list student by course");
            System.out.println("6. find students highest score by course");
            System.out.println("7. order student by increase");
            System.out.println("8. order student by decrease");
            System.out.println("9. find lowest score student");
            System.out.println("10. export lowest score student");
            System.out.println("11. exit!");
            System.out.print("select option (1-11): ");

            choice = Helper.scanner.nextInt();
            Helper.scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Option 1: list students");
                    this.service.getAll();
                    break;
                case 2:
                    System.out.println("Option 2: add student");
                    this.service.add();
                    break;
                case 3:
                    System.out.println("Option 3: edit student");
                    this.service.update();
                    break;
                case 4:
                    System.out.println("Options 4: delete student");
                    this.service.delete();
                    break;
                case 5:
                    System.out.println("Options 5: list student by course");
                    service.listStudentByCourse();
                    break;
                case 6:
                    System.out.println("Options 6: list student highest score by course");
                    service.findStudentHighestScoreByCourse();
                    break;
                case 7:
                    System.out.println("Options 7: order student by increase");
                    service.sortByAsc();
                    break;
                case 8:
                    System.out.println("Options 8: order student by decrease");
                    service.sortByDesc();
                    break;
                case 9:
                    System.out.println("Options 9: find lowest score student");
                    service.findLowestScore();
                    break;
                case 10:
                    System.out.println("Options 10: export 3 student lowest point");
                    service.exportToFile();
                    break;
                case 11:
                    Helper.scanner.close();
                    break;
                default:
                    System.out.println("Wrong options, please select 1–10.");
            }
        } while (choice != 5);
    }
}
