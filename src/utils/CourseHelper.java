package utils;

import constant.MaxLimit;
import exception.*;

public class CourseHelper {
    public static String enterName() {
        while (true) {
            try {
                System.out.print("Enter course name: ");
                String name = Helper.scanner.nextLine();

                boolean isEmptyName = Helper.isEmpty(name, "name");
                if (isEmptyName) {
                    throw new EmptyException("name");
                }

                boolean isMaxLenName = Helper.isMaxLength(name, MaxLimit.LENGTH, "name");
                if (isMaxLenName) {
                    throw new MaxLengthException("name", MaxLimit.LENGTH);
                }

                return name;
            } catch (AppException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int enterLesson() {
        while (true) {
            try {
                System.out.print("Enter lesson: ");
                String lesson = Helper.scanner.nextLine();

                boolean isEmpty = Helper.isEmpty(lesson, "lesson");
                if (isEmpty) {
                    throw new EmptyException("lesson");
                }

                boolean isInValid = Helper.isInvalidInt(lesson);
                if (isInValid) {
                    throw new InvalidException();
                }
                int lessonFormatted = Helper.convertStringToInt(lesson);
                boolean isMax = Helper.isMaxNumber(lessonFormatted, MaxLimit.LESSON, "lesson");
                if (isMax) {
                    throw new MaxNumberException("lesson", MaxLimit.LESSON);
                }

                return lessonFormatted;

            } catch (AppException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int enterPrice() {
        while (true) {
            try {
                System.out.print("Enter price: ");
                String price = Helper.scanner.nextLine();

                boolean isEmpty = Helper.isEmpty(price, "price");
                if (isEmpty) {
                    throw new EmptyException("price");
                }

                boolean isInValid = Helper.isInvalidInt(price);
                if (isInValid) {
                    throw new InvalidException();
                }
                int priceFormatted = Helper.convertStringToInt(price);
                boolean isMax = Helper.isMaxNumber(priceFormatted, MaxLimit.PRICE, "price");
                if (isMax) {
                    throw new MaxNumberException("price", MaxLimit.PRICE);
                }

                return priceFormatted;

            } catch (AppException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int enterId() {
        while (true) {
            try {
                System.out.print("Enter id: ");
                String id = Helper.scanner.nextLine();

                boolean isEmpty = Helper.isEmpty(id, "id");
                if (isEmpty) {
                    throw new EmptyException("id");
                }

                boolean isInValid = Helper.isInvalidInt(id);
                if (isInValid) {
                    throw new InvalidException();
                }
                int idFormatted = Helper.convertStringToInt(id);
                boolean isMax = Helper.isMaxNumber(idFormatted, MaxLimit.ID, "id");
                if (isMax) {
                    throw new MaxNumberException("id", MaxLimit.ID);
                }

                return idFormatted;

            } catch (AppException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
