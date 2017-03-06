package com.spartanengineer.datastructures;

import java.util.*;

public class DynamicArray<T> {
	
	private T[] arr;
	private int maxSize = 8;
	private int size = 0;

	public DynamicArray() {
		newArray();
	}
	
	public void set(int index, T data) {
		if(index < 0)
			return; //error
		
		if(index >= maxSize) {
			int newSize = maxSize*2;
			while(newSize < index && newSize > 0) {
				newSize *= 2;
			}
			if(newSize < 0)
				newSize = Integer.MAX_VALUE;
			resizeArray(newSize);
		}
			
		arr[index] = data;
		if(index >= size)
			size = index+1;
		
	}
	
	public T get(int index) {
		
		if(index < 0 || index >= size) 
			return null; //error
		
		return arr[index];
		
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		if(size > 0) {
			s.append(" ");
			for(int i = 0; i < size; i++) {
				s.append(arr[i]);
				s.append(" ");
			}
		}
		s.append("]");
		return s.toString();
	}
	
	@SuppressWarnings("unchecked")
	public void newArray() {
		arr = (T[]) new Object[maxSize];
	}
	
	@SuppressWarnings("unchecked")
	public void resizeArray(int newSize) {
		T[] newArr = (T[]) new Object[newSize];
		
		int max = Math.min(size, newSize);
		
		for(int i = 0; i < max; i++)
			newArr[i] = arr[i];
		
		arr = newArr;
		maxSize = newSize;
		size = max;
		
	}

}
