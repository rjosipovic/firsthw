package home.playground.first;

import home.playground.common.UserInput;

/**
 * Hello world!
 *
 */
public class FirstMain {
    public static void main( String[] args ) {
        int n = UserInput.acceptNaturalNumber();
        Operation operation = UserInput.acceptOperationOnNumber(n);

        switch (operation) {
            case FACTORIAL:
                System.out.println(ExecuteOperation.factorial(n));
                break;
            case PRIMES:
                System.out.println(ExecuteOperation.primes(n));
                break;
            case DENOMINATOR:
                int m = UserInput.acceptNaturalNumber();
                System.out.println(ExecuteOperation.denominator(n, m));
                break;
        }
    }
}
