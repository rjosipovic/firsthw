package home.playground.third;

import home.playground.common.UserInput;

public class ThirdMain {

    private static BinaryTree tree = new BinaryTree();

    public static void main(String[] args) {
        initTree(args);
        printTree();
        System.out.println("What would you liek to do?");
        TreeInput input;
        do {
            input = UserInput.acceptTreeInput();
            handleInput(input);
        } while(input.getOperation() != TreeOperation.END);
        System.out.println("Ending execution...");
    }

    private static void handleInput(TreeInput input) {
        switch (input.getOperation()) {
            case ADD:
                if(tree.contains(input.getNumber())) {
                    System.out.println(String.format("The number %d already exists in the tree, it can't be added again", input.getNumber()));
                } else {
                    tree.add(input.getNumber());
                    System.out.println(String.format("The number %d was added to the tree", input.getNumber()));
                }
                break;
            case CONTAINS:
                if(tree.contains(input.getNumber())) {
                    System.out.println(String.format("The number %d exists in the tree", input.getNumber()));
                } else {
                    System.out.println(String.format("The number %d does not exist in the tree", input.getNumber()));
                }
                break;
            case ASCENDING:
                System.out.println(String.format("The order of the tree ascending is: %s", tree.asc()));
                break;
            case DESCENDING:
                System.out.println(String.format("The order of the tree descending is: %s", tree.desc()));
                break;
            case SIZE:
                System.out.println(String.format("Size of the tree is %d", tree.size()));
                break;
        }
    }

    private static void printTree() {
        System.out.println(String.format("The current tree is: %s", tree.asc()));
    }

    private static void initTree(String[] args) {
        for(String arg : args) {
            try {
                int n = Integer.parseInt(arg);
                tree.add(n);
            } catch(NumberFormatException e) {
                System.out.println(String.format("Invalid argument: %s", arg));
            }
        }
    }
}
