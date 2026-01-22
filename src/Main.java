import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static ArrayList<Student> students = new ArrayList<>();

    static {
        students.add(new Student("Loi Nguyen Huu", 25, false, 1.5F, 1));
        students.add(new Student("Loi Nguyen Viet", 26, false, 2.5F, 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Option 1: list students");
                    Helper.listStudents(students);
                    break;
                case 2:
                    System.out.println("Option 2: add student");
                    Helper.addStudent(students, scanner);
                    break;
                case 3:
                    System.out.println("Option 3: edit student");
                    Helper.updateStudentById(students, scanner);
                    break;
                case 4:
                    System.out.println("Options 4: delete student");
                    Helper.deleteStudentById(students, scanner);
                    break;
                case 5:
                    scanner.close();
                    break;
                default:
                    System.out.println("Wrong options, please select 1–5.");
            }

        } while (choice != 5);


        scanner.close();
    }
}