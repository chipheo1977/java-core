package controller;

import services.StudentService;
import utils.Helper;
import utils.StudentHelper;

public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    private void hackScore() throws Exception {
        int id = StudentHelper.enterId();

        Thread t1 = new Thread(() -> service.autoUpdateScore(id));
        Thread t2 = new Thread(() -> service.autoUpdateScore(id));
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Hack success");
    }

    private void testDeadlock() throws Exception {
        int st1Id = StudentHelper.enterId();
        int st2Id = StudentHelper.enterId();

        Thread t1 = new Thread(() ->
                service.transferScore(st1Id, st2Id));

        Thread t2 = new Thread(() ->
                service.transferScore(st1Id, st2Id));

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    public void managementStudent() throws Exception {
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
            System.out.println("11. race condition");
            System.out.println("12. deadlock");
            System.out.println("13. exit!");
            System.out.print("select option (1-13): ");

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
                    System.out.println("Options 11: race condition");
                    this.hackScore();
                    break;
                case 12:
                    System.out.println("Options 12: deadlock");
                    this.testDeadlock();
                    break;
                case 13:
                    Helper.scanner.close();
                    break;
                default:
                    System.out.println("Wrong options, please select 1–13.");
            }
        } while (choice != 12);
    }
}
