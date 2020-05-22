package home.playground.third;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

public class BinaryTreeTest {

    @Test
    public void testAdd() {
        int[] treeValues = {10, 5, 15, 3, 6, 12, 19};
        BinaryTree tree = new BinaryTree();
        for(int n : treeValues) {
            tree.add(n);
        }
        System.out.println(tree.asc());
        System.out.println(tree.desc());

        assertTrue(tree.contains(10));
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(15));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(12));
        assertTrue(tree.contains(19));

        assertFalse(tree.contains(1));
        assertFalse(tree.contains(2));
        assertFalse(tree.contains(4));
        assertFalse(tree.contains(100));

    }
}
