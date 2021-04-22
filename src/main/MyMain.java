package main;

import implementation.MyBinarySearchTree;

public class MyMain {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> bst =
                new MyBinarySearchTree<>();
        bst.insert(50);
        bst.insert(42);
        bst.insert(65);
        bst.insert(105);
        bst.insert(55);
        bst.insert(100);
        bst.inOrder(bst.getRoot());
        System.out.println();
        bst.delete(65);
        bst.inOrder(bst.getRoot());
        System.out.println();
        bst.delete(42);
        bst.inOrder(bst.getRoot());
        System.out.println();
        bst.delete(50);
        bst.inOrder(bst.getRoot());
    }
}
