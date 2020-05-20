package home.playground.first;

import home.playground.common.StringConcatenator;

public enum Operation {
    FACTORIAL,
    DENOMINATOR,
    PRIMES;

    public static Operation fromString(String value) {

        switch (value.toLowerCase()) {
            case "factorial":
                return FACTORIAL;
            case "denominator":
                return DENOMINATOR;
            case "primes":
                return PRIMES;
            default:
                throw new IllegalArgumentException(String.format("Unknown operation", value));
        }
    }

    public static String all() {
        StringConcatenator concatenate = new StringConcatenator(',');
        for(Operation operation : Operation.values()) {
            concatenate.add(operation.name());
        }
        return concatenate.toString();
    }
}
