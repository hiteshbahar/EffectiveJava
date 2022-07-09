package algorithms.treetraversal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeTest {

    @Test
    void treeTraversal() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(52);
        bst.insert(15);
        bst.insert(56);
        bst.insert(9);
        bst.insert(16);
        bst.insert(54);
        bst.insert(3);
        bst.insert(10);
        bst.insert(61);

        Integer[] inorderArray = {3, 9, 10, 15, 16, 52, 54, 56, 61};
        List<Integer> expectedInorder = Arrays.asList(inorderArray);

        ArrayList<Integer> result = bst.inOrderTraversal();
        assertEquals(expectedInorder, result);

        Integer[] preorderArray = {52,15,9,3,10,16,56,54,61};
        List<Integer> expectedPreorder = Arrays.asList(preorderArray);
        result = bst.preOrderTraversal();//output [52,15,9,3,10,16,56,54,61]
        assertEquals(expectedPreorder, result);

        Integer[] postOrderArray= {3,10,9,16,15,54,61,56,52};
        List<Integer> expectedPostOrder = Arrays.asList(postOrderArray);
        result = bst.postOrderTraversal(); //output [3,10,9,16,15,54,61,56,52]
        assertEquals(expectedPostOrder, result);
    }
}
