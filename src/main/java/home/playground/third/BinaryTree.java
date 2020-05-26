package home.playground.third;

import home.playground.common.StringConcatenator;

import java.util.StringJoiner;

public class BinaryTree {

    private Node root;
    private int size;
    private int[] treeArray;
    private int index;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
        this.index = 0;
    }

    public int size() {
        return size;
    }

    public void add(int number) {
        root = addNode(root, number);
    }

    private Node addNode(Node node, int number) {
        if(node == null) {
            node = new Node(number);
            size++;
        }
        if(number < node.getValue()) {
            node.setLeft(addNode(node.getLeft(), number));
        } else if(number > node.getValue()) {
            node.setRight(addNode(node.getRight(), number));
        }
        return node;
    }

    public void remove(int number) {
        root = removeNode(root, number);
    }

    private Node removeNode(Node node, int number) {
        if(node == null) {
            return null;
        }
        if(number < node.getValue()) {
            node.setLeft(removeNode(node.getLeft(), number));
        } else if(number > node.getValue()) {
            node.setRight(removeNode(node.getRight(), number));
        } else {
            if(node.getLeft() == null && node.getRight() == null) {
                node = null;
                size--;
            } else if(node.getLeft() == null) {
                node = node.getRight();
                size--;
            } else if(node.getRight() == null) {
                node = node.getLeft();
                size--;
            } else {
                Node minNode = locateMin(node.getRight());
                node.setValue(minNode.getValue());
                node.setRight(removeNode(node.getRight(), minNode.getValue()));
            }
        }
        return node;
    }

    private Node locateMin(Node node) {
        if(node.getLeft() == null) {
            return node;
        } else {
            return locateMin(node.getLeft());
        }
    }

    public boolean contains(int number) {
        return hasNode(root, number);
    }

    private boolean hasNode(Node node, int number) {
        if(node == null) {
            return Boolean.FALSE;
        }
        if(number < node.getValue()) {
            return hasNode(node.getLeft(), number);
        } else if(number > node.getValue()) {
            return hasNode(node.getRight(), number);
        } else {
            return Boolean.TRUE;
        }
    }

    public int[] asc() {
        this.treeArray = new int[this.size()];
        this.index = 0;
        populateTreeAsc(root);
        return this.treeArray;
    }

    private void populateTreeAsc(Node node) {
        if(node == null) {
            return;
        }
        populateTreeAsc(node.getLeft());
        this.treeArray[this.index++] = node.getValue();
        populateTreeAsc(node.getRight());
    }

    public int[] desc() {
        this.treeArray = new int[this.size()];
        this.index = 0;
        populateTreeDesc(root);
        return this.treeArray;
    }

    private void populateTreeDesc(Node node) {
        if(node == null) {
            return;
        }
        populateTreeDesc(node.getRight());
        this.treeArray[this.index++] = node.getValue();
        populateTreeDesc(node.getLeft());
    }
}
