package com.spartanengineer.datastructures;

public class MyStack<T> {
	
	private class Node<U> {
		public U data;
		public Node<U> next;
		
		public Node(U data) {
			this.data = data;
			next = null;
		}
	}
	
	private Node<T> head;
	private int size;
	
	public MyStack() {
		head = null;
		size = 0;
	}
	
	public void add(T data) {
		Node<T> newNode = new Node<T>(data);
		if(head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}
	
	public T peek() {
		if(head == null)
			return null;
		
		return head.data;
	}
	
	public T pop() {
		if(head == null)
			return null;
		
		T result = head.data;
		head = head.next;
		size--;
		return result;
	}
	
	public int getSize() {
		return size;
	}
	
	public void clear() {
		if(head != null) {
			head = null;
			size = 0;
		}
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		if(head != null) {
			Node<T> n = head;
			while(n != null) {
				s.append(n.data);
				if(n.next != null)
					s.append(", ");
				n = n.next;
			}
		}
		s.append("]");
		return s.toString();
	}

}
