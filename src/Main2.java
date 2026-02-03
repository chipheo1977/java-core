import java.util.*;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        Student student = new Student("A", 20);
        Student student1 = new Student("B", 18);
        Student student2 = new Student("C", 30);
        Student student3 = new Student("D", 30);
        Student student4 = new Student("E", 50);
        Student student5 = new Student("F", 50);


        List<Student> students = List.of(student5, student, student1, student2, student3, student4);


        // 1. grouping
        // ex1:
        Map<Integer, List<Student>> mapData = students.stream().collect(Collectors.groupingBy(Student::getAge));
        // System.out.println(mapData.toString());;

        // ex2
         // Map<Integer, List<Student>> mapData = students.stream().collect(Collectors.groupingBy(Student::getAge, TreeMap::new, Collectors.toList()));

        // 2. peek
//        List<Student> newLst = students.stream().peek(item -> System.out.println(item.getAge())).toList();
//        System.out.println(newLst.toString());

        // 3. flatMap
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );

        List<Integer> flatList = nestedList.stream()
                .flatMap(it -> it.stream())
                .filter(it -> it % 2 == 0)
                .toList();
//        System.out.println(flatList);

        // 4. limit & skip
        List<Student> newLstStudents = students.stream().skip(1).limit(2).toList();


        // 5. sorted
        Comparator<Student> comparator = Comparator.comparing(Student::getName).thenComparing(Student::getAge);
        Comparator<Student> comparator2 = Comparator.comparing(Student::getAge).reversed();
        List<Student> studentsSorted = students.stream().sorted(comparator).toList();
        System.out.println(studentsSorted);

    }
}

class Student {

    private String name;
    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
