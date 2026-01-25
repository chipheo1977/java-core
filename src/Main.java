import Controller.CoursePrimaryController;
import Controller.CourseSecondaryController;
import Controller.StudentController;
import entity.Course;
import entity.CoursePrimary;
import entity.CourseSecondary;
import entity.Student;
import services.CoursePrimaryService;
import services.CourseSecondaryService;
import services.StudentService;
import utils.Helper;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static ArrayList<Student> defaultStudents = new ArrayList<>();
    public static ArrayList<CoursePrimary> defaultCourses = new ArrayList<>();
    public static ArrayList<CourseSecondary> defaultCoursesSecondary = new ArrayList<>();

    static {
        defaultStudents.add(new Student("Loi Nguyen Huu", 25, false, 1.5F, 1));
        defaultStudents.add(new Student("Loi Nguyen Viet", 26, false, 2.5F, 2));
        defaultCourses.add(new CoursePrimary(1, "English", 10, 1000));
        defaultCourses.add(new CoursePrimary(2, "Chinese", 101, 2000));
        defaultCoursesSecondary.add(new CourseSecondary(1, "Chinese 2", 202, 4000));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Helper helper = new Helper();

        StudentService studentService = new StudentService(defaultStudents);
        StudentController studentController = new StudentController(studentService, helper);
        CoursePrimaryService  courseService = new CoursePrimaryService(defaultCourses);
        CoursePrimaryController coursePrimaryController = new CoursePrimaryController(courseService, helper);
        CourseSecondaryService courseSecondaryService = new CourseSecondaryService(defaultCoursesSecondary);
        CourseSecondaryController courseSecondaryController = new CourseSecondaryController(courseSecondaryService, helper);

        int choice;

        do {
            System.out.println("===== MENU management school =====");
            System.out.println("1. Management student");
            System.out.println("2. Management primary course");
            System.out.println("3. Management secondary course");
            System.out.println("3. Exit!");
            System.out.print("select option (1-3): ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("1. Management student");
                    studentController.managementStudent();
                    break;
                case 2:
                    System.out.println("2. Management primary course");
                    coursePrimaryController.managementCourse();
                    break;
                case 3:
                    System.out.println("2. Management secondary course");
                    courseSecondaryController.managementCourse();
                    break;
                case 4:
                    scanner.close();
                    break;
                default:
                    System.out.println("Wrong options, please select 1–3.");
            }

        } while (choice != 5);
    }
}