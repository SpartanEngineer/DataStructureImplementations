package com.spartanengineer.datastructures;

import java.util.*;
import javafx.util.Pair;

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

    }

    public void insert(T data) {
		TreeNode<T> newNode = new TreeNode<T>(data);
		if(rootNode == null) {
			rootNode = newNode;
		} else {
			TreeNode<T> parentNode = rootNode;
			while(true) {
				if(data.compareTo(parentNode.data) <= 0) {
					if(parentNode.left == null) {
						parentNode.left = newNode;
						break;
					}
					parentNode = parentNode.left;
				} else {
					if(parentNode.right == null) {
						parentNode.right = newNode;
						break;
					}
					parentNode = parentNode.right;
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

    private Pair<TreeNode<T>, TreeNode<T>> getMaxNodeAndParent(TreeNode<T> parent, TreeNode<T> root) {
		if(root == null)
			return null;
	
		if(root.right != null)
			return getMaxNodeAndParent(root, root.right);
	
		return new Pair<TreeNode<T>, TreeNode<T>>(parent, root);
    }

    private Pair<TreeNode<T>, TreeNode<T>> getMinNodeAndParent(TreeNode<T> parent, TreeNode<T> root) {
		if(root == null)
			return null;
	
		if(root.left != null)
			return getMinNodeAndParent(root, root.left);
	
		return new Pair<TreeNode<T>, TreeNode<T>>(parent, root);
    }

    public boolean remove(T data) {
		if(rootNode == null)
			return false;
	
		if(data.compareTo(rootNode.data) == 0 && rootNode.left == null && rootNode.right == null) {
			size = 0;
			rootNode = null;
			return true;
		}
	
		TreeNode<T> parentNode = null;
		TreeNode<T> toDelete = rootNode;
		while(toDelete != null) {
			if(data.compareTo(toDelete.data) == 0) {
				//this is where we remove the node
				
				Pair<TreeNode<T>, TreeNode<T>> pair = getMaxNodeAndParent(toDelete, toDelete.left);
				TreeNode<T> toMove = null;
				TreeNode<T> toMoveParent = null;
	
				if(pair != null) {
					toMoveParent = pair.getKey();
					toMove = pair.getValue();
					if(toMoveParent.left == toMove)
						toMoveParent.left = toMove.left;
					else
						toMoveParent.right = toMove.left;
	
				} else {
					pair = getMinNodeAndParent(toDelete, toDelete.right);
					if(pair != null) {
						toMoveParent = pair.getKey();
						toMove = pair.getValue();
						if(toMoveParent.left == toMove)
							toMoveParent.left = toMove.right;
						else
							toMoveParent.right = toMove.right;
						}
				}
	
				if(toMove != null) {
					toMove.left = toDelete.left;
					toMove.right = toDelete.right;
				}
	
				if(parentNode != null) 
					if(parentNode.left == toDelete) 
						parentNode.left = toMove;
					else
						parentNode.right = toMove;
				else
					rootNode = toMove;
				size--;
				return true;
			} else if(data.compareTo(toDelete.data) < 0) {
				parentNode = toDelete;
				toDelete = toDelete.left;
			} else {
				parentNode = toDelete;
				toDelete = toDelete.right;
			}
		}
		return false;
    }

    private void toStringRecursive(TreeNode<T> node, StringBuilder s) {
		if(node == null)
			return;
		if(node.left != null) {
			toStringRecursive(node.left, s);
			s.append(", ");
		}
		s.append(node.data);
		if(node.right != null) {
			s.append(", "); 
			toStringRecursive(node.right, s);
		}
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        toStringRecursive(rootNode, s);
        s.append("]");
        return s.toString();
    }

}
