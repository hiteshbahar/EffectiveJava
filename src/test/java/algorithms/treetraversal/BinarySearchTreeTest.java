package algorithms.treetraversal;

import org.junit.jupiter.api.Test;

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

        bst.inOrderTraversal(); //output [3,9,10,15,16,52,54,56,61]

        bst.preOrderTraversal(); //output [52,15,9,3,10,16,56,54,61]

        bst.postOrderTraversal(); //output [3,10,9,16,15,54,61,56,52]
    }
}
