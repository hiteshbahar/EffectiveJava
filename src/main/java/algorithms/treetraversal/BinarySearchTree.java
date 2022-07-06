package algorithms.treetraversal;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean insert(int data) {
        root = insert(root, data);
        return true;
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private Node insert(Node node, int data) {

        if (node == null) {
            return new Node(data);
        }

        if (node.data > data) {
            node.left = insert(node.left, data);
        }

        if (node.data < data) {
            node.right = insert(node.right, data);
        } else {
            return node;
        }
        return node;
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);
        }
    }

    private void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.println(node.data);
            inOrderTraversal(node.left);
            inOrderTraversal(node.right);
        }
    }

    private void postOrderTraversal(Node node) {

        if (node != null) {
            inOrderTraversal(node.left);
            inOrderTraversal(node.right);
            System.out.println(node.data);
        }
    }


}
