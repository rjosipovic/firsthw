package home.playground.common;

import home.playground.first.Operation;
import java.util.Scanner;

public class UserInput {

    private static final String ENTER_NUMBER_MSG = "Enter a natural number";
    private static final String INVALID_NUMBER_ERR_MSG_TEMPLATE = "'%s' is not a natural number, please enter a new number";

    private static final String ENTER_OPERATION_ON_NUMBER_TEMPLATE = "What operation would you like to perform on number: %d?";
    private static final String INVALID_OPERATION_ERR_MSG_TEMPLATE = "'%s' is not a supported operation, please enter one of: %s";

    private static final String ENTER_STRING_MSG = "Please enter a string that is at least 2 character long:";
    private static final String INVALID_STRING_ERR_MSG_TEMPLATE = "Sorry, '%s' is not a valid string, please try again:";

    private static final int MAX_INVALID_ATTEMPTS = 10;
    private static final String INVALID_ATTEMPTS_REACHED_ERR_MSG = "Invalid attempts reached";

    public static int acceptNaturalNumber() {
        System.out.println(ENTER_NUMBER_MSG);
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < MAX_INVALID_ATTEMPTS; i++) {
            String line = scanner.nextLine().trim();
            try {
                int number = Integer.parseInt(line);
                return number;
            } catch (NumberFormatException e) {
                System.out.println(String.format(INVALID_NUMBER_ERR_MSG_TEMPLATE, line));
            }
        }
        throw new RuntimeException(INVALID_ATTEMPTS_REACHED_ERR_MSG);
    }

    public static Operation acceptOperationOnNumber(int number) {
        System.out.println(String.format(ENTER_OPERATION_ON_NUMBER_TEMPLATE, number));
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < MAX_INVALID_ATTEMPTS; i++) {
            String line = scanner.nextLine().trim();
            try{
                Operation operation = Operation.fromString(line);
                return operation;
            } catch (IllegalArgumentException e) {
                System.out.println(String.format(INVALID_OPERATION_ERR_MSG_TEMPLATE, line, Operation.all()));
            }
        }
        throw new RuntimeException(INVALID_ATTEMPTS_REACHED_ERR_MSG);
    }

    public static String acceptString(int minLength) {
        System.out.println(ENTER_STRING_MSG);
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < MAX_INVALID_ATTEMPTS; i++) {
            String input = scanner.nextLine().trim();
            if (input.length() >= minLength) {
                return input;
            } else {
                System.out.println(String.format(INVALID_STRING_ERR_MSG_TEMPLATE, input));
            }
        }
        throw new RuntimeException(INVALID_ATTEMPTS_REACHED_ERR_MSG);
    }
}
