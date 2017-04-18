package com.spartanengineer.datastructures;

import java.util.*;

public class MyBinarySearchTree<T extends Comparable<T>> {

    private class TreeNode<U extends Comparable<U>> {
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

    public void insert(T data) {
	TreeNode<T> newNode = new TreeNode<T>(data);
	if(rootNode == null) {
		rootNode = newNode;
	} else {
		TreeNode<T> parentNode = rootNode;
		while(true) {
			if(data.compareTo(rootNode.data) <= 0) {
				if(rootNode.left == null) {
					rootNode.left = newNode;
					break;
				}
				rootNode = rootNode.left;
			} else {
				if(rootNode.right == null) {
					rootNode.right = newNode;
					break;
				}
				rootNode = rootNode.right;
			}
		}
	}
	size++;
    }

    public boolean contains(T data) {
	TreeNode<T> node = rootNode;
	while(node != null) {
		if(data.compareTo(node.data) == 0)
			return true;
		else if(data.compareTo(node.data) < 0)
			node = node.left;
		else
			node = node.right;
	}
	return false;
    }

    public boolean remove(T data) {
	//TODO- implement this
	return false;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        //TODO- implement to string method
        s.append("]");
        return s.toString();
    }

}
