package com.spartanengineer.datastructures;

import java.util.*;

public class MyBinarySearchTree<T> {

    private class TreeNode<U> {
        public TreeNode<U> left = null;
        public TreeNode<U> right = null;
        public U data = null;

        public TreeNode(U data) {
            this.data = data;
        }

    }

    private TreeNode<T> rootNode = null;
    private int size = 0;

    public MyBinarySearchTree() {
        //TODO- implement constructor
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        //TODO- implement to string method
        s.append("]");
        return s.toString();
    }

}
