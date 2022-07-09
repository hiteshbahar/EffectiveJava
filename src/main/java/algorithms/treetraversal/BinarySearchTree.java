package algorithms.treetraversal;

import java.util.ArrayList;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean insert(int data) {
        root = insert(root, data);
        return true;
    }

    public ArrayList<Integer> inOrderTraversal() {
        ArrayList<Integer> output = new ArrayList<>();
        inOrderTraversal(root, output);
        return output;
    }

    public ArrayList<Integer> postOrderTraversal() {
        ArrayList<Integer> output = new ArrayList<>();
        postOrderTraversal(root, output);
        return output;
    }

    public ArrayList<Integer> preOrderTraversal() {
        ArrayList<Integer> output = new ArrayList<>();
        preOrderTraversal(root, output);
        return output;
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

    private void inOrderTraversal(Node node, ArrayList<Integer> output) {
        if (node != null) {
            inOrderTraversal(node.left, output);
            output.add(node.data);
            inOrderTraversal(node.right, output);
        }
    }

    private void preOrderTraversal(Node node, ArrayList<Integer> output) {
        if (node != null) {
            output.add(node.data);
            preOrderTraversal(node.left, output);
            preOrderTraversal(node.right, output);
        }
    }

    private void postOrderTraversal(Node node, ArrayList<Integer> output) {

        if (node != null) {
            postOrderTraversal(node.left, output);
            postOrderTraversal(node.right, output);
            output.add(node.data);
        }
    }


}
