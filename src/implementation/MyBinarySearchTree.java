package implementation;

import java.util.NoSuchElementException;

public class MyBinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;//head of linked list

    public Node<E> getRoot() {
        return root;
    }
    //insert
    public void insert(E data){
        //creating a new node
        Node<E> node = new Node<>(data);
        if(isEmpty()){
            root = node;
        }
        else{
            //traversing to reach the right position to add
            // new node, as well as keep track of parent
            Node<E> temp = root;
            Node<E> parent = null;
            while(temp != null){
                parent = temp;
                if(data.compareTo(temp.getData()) <= 0){
                    //traversing left sub tree
                    temp = temp.getLeft();
                }
                else{
                    //traversing right sub tree
                    temp = temp.getRight();
                }
            }
            if(data.compareTo(parent.getData()) <=0){
                //new node will become left child
                parent.setLeft(node);
            }
            else{
                //new node will become right child
                parent.setRight(node);
            }

        }
    }
    public void preOrder(Node<E> node){
        //base condition
        if(node == null){
            return;
        }
        else{
            //process the root, print
            System.out.print(node.getData() + ",");
            //process left sub tree
            preOrder(node.getLeft());
            //process right sub tree
            preOrder(node.getRight());
        }
        System.out.println();
    }
    public void inOrder(Node<E> node){
        if(node != null){
            //process left sub tree
            inOrder(node.getLeft());
            //process root
            System.out.print(node.getData() + ", ");
            //process right sub tree
            inOrder(node.getRight());
        }
    }









    private boolean isEmpty() {
        if(root == null){
            return true;
        }
        return false;

    }
    //search
    public boolean search(E searchElement){
        boolean response = false;
        //traverse
        Node<E> temp = root;
        while (temp != null){
            //equality
            if(searchElement.compareTo(temp.getData()) == 0){
                response = true;
                break;
            }
            //less than
            else if (searchElement.compareTo(temp.getData()) < 0){
                temp = temp.getLeft();
            }
            else{
                temp = temp.getRight();
            }

            //greater than
        }
        return response;
    }
    //try recursive

    //delete
    public  void delete(E deletingElement){
        //search the deleting element and keep track of parent
        Node<E> temp  = root;
        Node<E> parent = null;
        while(temp != null){
            if(compare(deletingElement, temp) == 0){
                break;
            }
            else{
                parent = temp;
                if(compare(deletingElement,temp) < 0){
                    temp = temp.getLeft();
                }
                else {
                    temp = temp.getRight();
                }
            }
        }
        if(temp != null){
            //deletion
            //case 1-leaf
            if(isLeaf(temp)){
                //root node
                if(parent == null){
                   root = null;
                }
                else{
                    if(compare(deletingElement, parent) < 0){
                        parent.setLeft(null);
                    }
                    else{
                        parent.setRight(null);
                    }
                }
            }

            //case 2-on child
            //left child
            else if(hasLeftChild(temp)){
                //root node
                if(parent == null){
                    root = root.getLeft();
                }
                else{
                    if(compare(deletingElement,parent) < 0){
                        parent.setLeft(temp.getLeft());
                    }
                    else{
                        parent.setRight(temp.getLeft());
                    }
                }
            }
                //root node
            //case 3- tow children
                //root node
        }
        else{
            throw new NoSuchElementException("element not present");
        }
    }

    private boolean hasLeftChild(Node<E> temp) {
        if(temp.getLeft() != null && temp.getRight() == null){
            return true;
        }
        return false;
    }

    private boolean isLeaf(Node<E> temp) {
        if(temp.getLeft() == null && temp.getRight() == null){
            return true;
        }
        return false;
    }

    private int compare(E deletingElement, Node<E> temp) {
        return deletingElement.compareTo(temp.getData());
    }
}
