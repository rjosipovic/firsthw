package home.playground.third;

import home.playground.common.StringConcatenator;

public enum TreeOperation {
    ADD,
    SIZE,
    CONTAINS,
    ASCENDING,
    DESCENDING,
    END;

    public static TreeOperation fromString(String operation) {

        switch (operation.toLowerCase()) {
            case "add":
                return ADD;
            case "size":
                return SIZE;
            case "contains":
                return CONTAINS;
            case "ascending":
                return ASCENDING;
            case "descending":
                return DESCENDING;
            case "end":
                return END;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static String all() {
        StringConcatenator concatenate = new StringConcatenator(',');
        for(TreeOperation operation : TreeOperation.values()) {
            concatenate.add(operation.name());
        }
        return concatenate.toString();
    }
}
