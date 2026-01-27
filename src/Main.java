import Controller.CoursePrimaryController;
import Controller.CourseSecondaryController;
import Controller.StudentController;
import constant.Role;
import entity.CoursePrimary;
import entity.CourseSecondary;
import entity.Student;
import services.CoursePrimaryService;
import services.CourseSecondaryService;
import services.StudentService;
import utils.Helper;

import java.util.ArrayList;


public class Main {

    public static ArrayList<Student> defaultStudents = new ArrayList<>();
    public static ArrayList<CoursePrimary> defaultCoursesPrimary = new ArrayList<>();
    public static ArrayList<CourseSecondary> defaultCoursesSecondary = new ArrayList<>();

    static {
        defaultStudents.add(new Student("Loi Nguyen Huu", 25, false, 1.5F, 1, Role.NORMAL));
        defaultStudents.add(new Student("Loi Nguyen Viet", 26, false, 2.5F, 2, Role.LEADER));
        defaultCoursesPrimary.add(new CoursePrimary(1, "English", 10, 1000));
        defaultCoursesPrimary.add(new CoursePrimary(2, "Chinese", 101, 2000));
        defaultCoursesSecondary.add(new CourseSecondary(1, "Chinese 2", 202, 4000));
    }

    public static void main(String[] args) {
        StudentService studentService = new StudentService(defaultStudents);
        StudentController studentController = new StudentController(studentService);

        CoursePrimaryService coursePrimaryService = new CoursePrimaryService(defaultCoursesPrimary);
        CoursePrimaryController coursePrimaryController = new CoursePrimaryController(coursePrimaryService);

        CourseSecondaryService courseSecondaryService = new CourseSecondaryService(defaultCoursesSecondary);
        CourseSecondaryController courseSecondaryController = new CourseSecondaryController(courseSecondaryService);

        int choice;

        do {
            System.out.println("===== MENU management school =====");
            System.out.println("1. Management student");
            System.out.println("2. Management primary course");
            System.out.println("3. Management secondary course");
            System.out.println("4. Exit!");
            System.out.print("select option (1-4): ");

            choice = Helper.scanner.nextInt();
            Helper.scanner.nextLine();

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
                    System.out.println("3. Management secondary course");
                    courseSecondaryController.managementCourse();
                    break;
                case 4:
                    Helper.scanner.close();
                    break;
                default:
                    System.out.println("Wrong options, please select 1–3.");
            }

        } while (choice != 5);
    }
}