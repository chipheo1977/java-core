import controller.CoursePrimaryController;
import controller.CourseSecondaryController;
import controller.StudentController;
import constant.Role;
import entity.CoursePrimary;
import entity.CourseSecondary;
import entity.Student;
import services.CoursePrimaryService;
import services.CourseSecondaryService;
import services.StudentService;
import utils.Helper;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static ArrayList<Student> defaultStudents = new ArrayList<>();
    public static ArrayList<CoursePrimary> defaultCoursesPrimary = new ArrayList<>();
    public static ArrayList<CourseSecondary> defaultCoursesSecondary = new ArrayList<>();
    public static ArrayList<Integer> groupCourse1 = new ArrayList<>(List.of(1, 3));
    public static ArrayList<Integer> groupCourse2 = new ArrayList<>(List.of(2, 4));


    static {
        defaultCoursesPrimary.add(new CoursePrimary(1, "English", 10, 1000));
        defaultCoursesPrimary.add(new CoursePrimary(2, "Chinese", 101, 2000));
        defaultCoursesPrimary.add(new CoursePrimary(3, "Korean", 101, 3000));
        defaultCoursesPrimary.add(new CoursePrimary(4, "Math", 1, 200));
        defaultCoursesSecondary.add(new CourseSecondary(1, "Chinese 2", 202, 4000));

        defaultStudents.add(new Student("Loi Nguyen Huu", 25, false, 1.5F, 1, Role.NORMAL, groupCourse1));
        defaultStudents.add(new Student("Loi Nguyen Viet", 26, false, 2.5F, 2, Role.LEADER, groupCourse2));
        defaultStudents.add(new Student("Loi Tien Nam", 20, false, 5.5F, 3, Role.SEMI_LEADER, groupCourse1));
//        defaultStudents.add(new Student("Trung Huu Hai", 30, false, 9.5F, 4, Role.NORMAL, groupCourse2));
//        defaultStudents.add(new Student("Trung Huu Hai 1", 30, false, 9.5F, 4, Role.NORMAL, groupCourse2));
//        defaultStudents.add(new Student("Trung Huu Hai 2", 30, false, 9.5F, 4, Role.NORMAL, groupCourse2));
//        defaultStudents.add(new Student("Trung Huu Hai 3", 30, false, 9.5F, 4, Role.NORMAL, groupCourse2));
//        defaultStudents.add(new Student("Trung Huu Hai 4", 30, false, 9.5F, 4, Role.NORMAL, groupCourse2));
//        defaultStudents.add(new Student("Trung Huu Hai 5", 30, false, 9.5F, 4, Role.NORMAL, groupCourse2));

    }

    public static void main(String[] args) {
        CoursePrimaryService coursePrimaryService = new CoursePrimaryService(defaultCoursesPrimary);
        CoursePrimaryController coursePrimaryController = new CoursePrimaryController(coursePrimaryService);

        CourseSecondaryService courseSecondaryService = new CourseSecondaryService(defaultCoursesSecondary);
        CourseSecondaryController courseSecondaryController = new CourseSecondaryController(courseSecondaryService);

        StudentService studentService = new StudentService(defaultStudents, coursePrimaryService);
        StudentController studentController = new StudentController(studentService);

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
