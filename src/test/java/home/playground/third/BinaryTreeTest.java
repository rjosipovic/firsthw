package home.playground.third;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class BinaryTreeTest {

    private static BinaryTree tree;

    @BeforeClass
    public static void construct() {
        tree = new BinaryTree();
    }

    @Before
    public void initTree() {
        int[] treeValues = {10, 5, 15, 3, 6, 12, 19, 11};
        for(int n : treeValues) {
            tree.add(n);
        }
    }

    @After
    public void destroyTree() {
        tree = new BinaryTree();
    }

    @Test
    public void testAdd() {
        assertEquals(8, tree.size());
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

    @Test
    public void testRemove() {
        assertEquals(8, tree.size());
        tree.remove(122);
        assertEquals(8, tree.size());
        tree.remove(19);
        assertEquals(7, tree.size());
        tree.remove(12);
        assertEquals(6, tree.size());
        tree.remove(15);
        assertEquals(5, tree.size());
        tree.remove(5);
        assertEquals(4, tree.size());
    }

    @Test
    public void testAsc() {
        int[] treeValues = {3, 5, 6, 10, 11, 12, 15, 19};
        assertTrue(Arrays.equals(treeValues, tree.asc()));
    }

    @Test
    public void testDesc() {
        int[] treeValues = {19, 15, 12, 11, 10, 6, 5, 3};
        assertTrue(Arrays.equals(treeValues, tree.desc()));
    }
}
