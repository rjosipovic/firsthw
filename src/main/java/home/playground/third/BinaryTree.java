package home.playground.third;

import home.playground.common.StringConcatenator;

import java.util.StringJoiner;

public class BinaryTree {

    private Node root;
    private int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public void add(int n) {
        Node newNode = new Node(n);
        if(root == null) {
            root = newNode;
            size++;
        } else {
            addNumber(root, newNode);
        }
    }

    private void addNumber(Node node, Node newNode) {
        if(newNode.getValue() < node.getValue()) {
            if(node.getLeft() == null) {
                node.setLeft(newNode);
                size++;
            } else {
                addNumber(node.getLeft(), newNode);
            }
        } else if(newNode.getValue() > node.getValue()) {
            if(node.getRight() == null) {
                node.setRight(newNode);
                size++;
            } else {
                addNumber(node.getRight(), newNode);
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean contains(int n) {
        return get(root, n) != null;
    }

    private Node get(Node node, int number) {

        if(node == null) {
            return null;
        } else {
            if(number == node.getValue()) {
                return node;
            } else if(number < node.getValue()) {
                return get(node.getLeft(), number);
            } else {
                return get(node.getRight(), number);
            }
        }
    }

    public String asc() {
        StringJoiner joiner = new StringJoiner(" ");
        treeAscArray(root, joiner);
        return joiner.toString();
    }

    public String desc() {
        StringJoiner joiner = new StringJoiner(" ");
        treeDscArray(root, joiner);
        return joiner.toString();
    }

    private void treeAscArray(Node node, StringJoiner joiner) {
        if(node == null) {
            return;
        }

        if(node.getLeft() != null) {
            treeAscArray(node.getLeft(), joiner);
        }

        joiner.add(Integer.toString(node.getValue()));

        if(node.getRight() != null) {
            treeAscArray(node.getRight(), joiner);
        }
    }

    private void treeDscArray(Node node, StringJoiner joiner) {
        if(node == null) {
            return;
        }

        if(node.getRight() != null) {
            treeDscArray(node.getRight(), joiner);
        }

        joiner.add(Integer.toString(node.getValue()));

        if(node.getLeft() != null) {
            treeDscArray(node.getLeft(), joiner);
        }
    }
}
