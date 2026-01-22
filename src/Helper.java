import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Helper {
    public static Student getStudentById(ArrayList<Student> students, int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public static void updateStudentById(ArrayList<Student> students, Scanner scanner) {
        try {
            System.out.print("Please enter student id: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Student student = getStudentById(students, id);

            if (student == null) {
                System.out.println("Student not found!");
            } else {
                System.out.print("Enter name:");
                student.setName(scanner.nextLine());
                scanner.nextLine();

                System.out.print("Enter age:");
                student.setAge(scanner.nextInt());

                System.out.print("Enter score:");
                student.setScore(scanner.nextFloat());

                System.out.println("Updated student id: " + id + " success!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Enter wrong format!");
        }
    }

    public static void deleteStudentById(ArrayList<Student> students, Scanner scanner) {
        System.out.print("Please enter student id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student student = getStudentById(students, id);
        if (student == null) {
            System.out.println("Student not found!");
        } else {
            try {
                for (Student s : students) {
                    if (s.getId() == id) {
                        students.remove(s);
                    }
                }

                System.out.println("deleted student id: " + id + " success!");
            } catch (InputMismatchException e) {
                System.out.println("Enter wrong format!");
            }
        }
    }

    public static void addStudent(ArrayList<Student> students, Scanner scanner) {
        try {
            System.out.print("Enter name:");
            String name = scanner.nextLine();
            scanner.nextLine(); // @TODO: why?

            System.out.print("Enter age:");
            int age = scanner.nextInt();

            System.out.print("Enter score:");
            float score = scanner.nextFloat();

            Random random = new Random();
            int id = random.nextInt(10);
            students.add(new Student(name, age, false, (float) score, id));

            System.out.println("Add students: " + name + " success!");
        } catch (InputMismatchException e) {
            System.out.println("Wrong format!");
            scanner.nextLine();
        }
    }

    public static void listStudents(ArrayList<Student> students) {
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
