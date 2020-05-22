package home.playground.third;

public class TreeInput {

    private TreeOperation operation;
    private int number;

    public TreeInput(TreeOperation operation) {
        this.operation = operation;
    }

    public TreeInput(TreeOperation operation, int number) {
        this.operation = operation;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public TreeOperation getOperation() {
        return operation;
    }
}
