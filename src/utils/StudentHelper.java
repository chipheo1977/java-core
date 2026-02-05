package utils;

import constant.MaxLimit;
import constant.Role;
import exception.*;

public class StudentHelper {
    public static String enterName() {
        while (true) {
            try {
                System.out.print("Enter name: ");
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

    public static int enterAge() {
        while (true) {
            try {
                System.out.print("Enter age: ");
                String age = Helper.scanner.nextLine();

                boolean isEmpty = Helper.isEmpty(age, "age");
                if (isEmpty) {
                    throw new EmptyException("age");
                }

                boolean isInValid = Helper.isInvalidInt(age);
                if (isInValid) {
                    throw new InvalidException(); // TODO: Exception k ro rang
                }
                int ageFormatted = Helper.convertStringToInt(age);
                boolean isMax = Helper.isMaxNumber(ageFormatted, MaxLimit.AGE, "age");
                if (isMax) {
                    throw new MaxNumberException("age", MaxLimit.AGE);
                }

                return ageFormatted;

            } catch (AppException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static float enterScore() {
        while (true) {
            try {
                System.out.print("Enter score: ");
                String score = Helper.scanner.nextLine();

                boolean isEmpty = Helper.isEmpty(score, "score");
                if (isEmpty) {
                    throw new EmptyException("score");
                }

                boolean isInValid = Helper.isInValidFloat(score);
                if (isInValid) {
                    throw new InvalidException();
                }
                float scoreFormatted = Helper.convertStringToFloat(score);
                boolean isMax = Helper.isMaxNumber((int) scoreFormatted, MaxLimit.SCORE, "age");
                if (isMax) {
                    throw new MaxNumberException("age", MaxLimit.SCORE);
                }

                return scoreFormatted;

            } catch (AppException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Role enterRole() {
        while (true) {
            try {
                Helper.wikiRole();
                System.out.print("Enter role: ");
                String role = Helper.scanner.nextLine();

                boolean isEmpty = Helper.isEmpty(role, "role");
                if (isEmpty) {
                    throw new EmptyException("role");
                }

                boolean isInValid = Helper.isInvalidInt(role);
                if (isInValid) {
                    throw new InvalidException();
                }
                int codeFormatted = Helper.convertStringToInt(role);
                boolean isMax = Helper.isMaxNumber(codeFormatted, MaxLimit.ROLE, "role");
                if (isMax) {
                    throw new MaxNumberException("role", MaxLimit.ROLE);
                }

                return Role.fromCode(codeFormatted);

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
