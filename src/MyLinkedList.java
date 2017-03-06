import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
	
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
	
	public MyLinkedList() {
		head = null;
		size = 0;
	}
	
	public void add(T data) {
		
		Node<T> newNode = new Node<T>(data);
		if(head == null) {
			head = newNode;
		} else {
			Node<T> n = head;
			while(n.next != null)
				n = n.next;
			n.next = newNode;
		}
		
		size++;
	}
	
	public void addEnd(T data) {
		add(data);
	}
	
	public void addBeginning(T data) {
		insert(0, data);
	}
	
	public T remove() {
		if(head == null)
			return null;
		
		T result;
		if(head.next == null) {
			result = head.data;
			head = null;
		} else {
			Node<T> n = head.next;
			Node<T> prev = head;
			while(n.next != null) {
				n = n.next;
				prev = prev.next;
			}
				
			prev.next = null;
			result = n.data;
		}
		
		size--;
		return result;
	}
	
	public T get(int index) {
		if(index < 0)
			return null;
		
		if(head == null)
			return null;
		
		if(index == 0)
			return head.data;
		
		int position = 0;
		Node<T> n = head.next;
		while(n != null) {
			position++;
			if(position == index)
				break;
			n = n.next;
		}
		
		if(position == index)
			return n.data;
		
		return null;
	}
	
	public void insert(int index, T data) {
		
		if(index < 0)
			return;
		
		Node<T> newNode = new Node<T>(data);
		
		if(index == 0) { //add it to the beginning of the list
			newNode.next = head;
			head = newNode;
			size++;
			return;
		}
		
		if(head == null)
			return;
		
		int position = 0;
		Node<T> n = head.next;
		Node<T> prev = head;
		while(n != null) {
			position++;
			if(position == index)
				break;
			n = n.next;
			prev = prev.next;
		}
		
		if(n == null && position == index-1) { //add it to the end
			prev.next = newNode;
			size++;
		} else if(position == index) { //add it to the correct spot in the middle of the list
			prev.next = newNode;
			newNode.next = n;
			size++;
		}
			
	}
	
	public void clear() {
		if(head != null) {
			head = null;
			size = 0;
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		if(head != null) {
			Node<T> n = head;
			while(n != null) {
				s.append(n.data.toString());
				if(n.next != null)
					s.append(", ");
				n = n.next;
			}
		}
		s.append("]");
		return s.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new MyLinkedListIterator<T>();
	}
	
	@SuppressWarnings("hiding")
	private class MyLinkedListIterator<T> implements Iterator<T> {
		
		@SuppressWarnings("rawtypes")
		private Node curr = head;

		@Override
		public boolean hasNext() {
			return curr != null;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			T data = (T) curr.data;
			curr = curr.next;
			return data;
		}
		
	}

}
