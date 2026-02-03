package utils;

import constant.MaxLimit;
import exception.AppException;

import java.util.Random;
import java.util.Scanner;

public class Helper {

    private static final int NAME_MAX_LENGTH = 10;

    public static int randomNumber() {
        Random random = new Random();
        return random.nextInt(MaxLimit.ID);
    }

    public static Scanner scanner = new Scanner(System.in);

    public static float inputValidFloat(String field, float max) {
        while (true) {
            System.out.print("Enter " + field + ": ");
            String input = scanner.nextLine();

            try {
                isEmpty(input, field);

                float number = Float.parseFloat(input);
                isMaxNumber((int) number, (int) max, field);

                return number;
            } catch (AppException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid float!");
            }
        }
    }

    public static int inputValidInt(String field, int max) {
        while (true) {
            System.out.print("Enter " + field + ": ");
            String input = scanner.nextLine();

            try {
                isEmpty(input, field);

                int number = Integer.parseInt(input);
                isMaxNumber(number, max, field);

                return number;
            } catch (AppException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println(field + " must be a valid integer");
            }
        }
    }

    public static String inputValidName(String field, int max) {
        while (true) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine().trim();

            try {
                isEmpty(name, field);
                isMaxLength(name, max, field);

                return name;
            } catch (AppException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int convertStringToInt(String value) {
        return Integer.parseInt(value);
    }

    public static float convertStringToFloat(String value) {
        return Float.parseFloat(value);
    }

    public static boolean isMaxNumber(int value, int max, String field) {
        return value > max;
    }

    public static boolean isEmpty(String value, String field) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isMaxLength(String value, int max, String field) {
        return value.length() > max;
    }

    public static boolean isInvalidInt(String value) {
        if (value == null || value.trim().isEmpty()) {
            return true;
        }
        try {
            convertStringToInt(value);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static boolean isInValidFloat(String value) {
        if (value == null || value.trim().isEmpty()) {
            return true;
        }
        try {
            convertStringToFloat(value);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static void wikiRole() {
        System.out.println("Please select a role");
        System.out.println("1. Leader");
        System.out.println("2. Semi leader");
        System.out.println("3. Normal");
    }
}
