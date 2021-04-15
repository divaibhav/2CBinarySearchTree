package main;

import implementation.MyBinarySearchTree;

public class MyMain {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> bst =
                new MyBinarySearchTree<>();
        bst.insert(50);
        bst.insert(42);
        bst.insert(65);
        bst.inOrder(bst.getRoot());
    }
}
