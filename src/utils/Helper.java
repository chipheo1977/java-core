package utils;

import services.StudentService;

import java.util.Random;
import java.util.Scanner;

public class Helper {

    private static final int NAME_MAX_LENGTH = 10;

    public static int randomNumber() {
        Random random = new Random();
        return random.nextInt(100);
    }
    private static Scanner scanner = new Scanner(System.in);

    public static float inputValidFloat(String field, float max) {
        while (true) {
            System.out.print("Enter " + field + ": ");
            String input = scanner.nextLine();
            try {
                float number = Float.parseFloat(input);
                if (number > max) {
                    System.out.println(field + " must be <= " + max);
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    public static int inputValidInt(String field, int max) {
        while (true) {
            System.out.print("Enter " + field + ": ");
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);

                if (number > max) {
                    System.out.println(field + " must be <= " + max);
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    public static String inputValidName() {
        while (true) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty");
            } else if (name.length() > NAME_MAX_LENGTH) {
                System.out.println("Name must be <= " + NAME_MAX_LENGTH + " characters!");
            } else {
                return name;
            }
        }
    }
}
