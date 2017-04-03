package com.spartanengineer.datastructures;

import java.util.*;

public class MyHashMap<T, U> {
	
	private class HashPair<R, S> {
		public R key;
		public S value;
		
		public HashPair(R key, S value) {
			this.key = key;
			this.value = value;
		}
		
	}
	
	private int maxCapacity = 1 << 30;
	
	private int capacity = 2;
	private float loadFactor = 0.75f;
	private int size = 0;
	
	private List<List<HashPair<T, U>>> map;
	
	public MyHashMap() {
		initHashMap();
		size = 0;
	}
	
	private void initHashMap() {
		map = new ArrayList<List<HashPair<T, U>>>();
		for(int i = 0; i < capacity; i++)
			map.add(null);
	}
	
	private void resizeIfNecessary() {
		if(capacity < maxCapacity) {
			float currentLoadFactor = size/capacity;
			if(currentLoadFactor >= loadFactor) {
				int oldCapacity = capacity;
				capacity *= 2;
				List<List<HashPair<T, U>>> newMap = new ArrayList<List<HashPair<T, U>>>();
				for(int i = 0; i < capacity; i++)
					newMap.add(null);
				
				for(int i = 0; i < oldCapacity; i++) {
					List<HashPair<T, U>> list = map.get(i);
					if(list != null) {
						for(HashPair<T, U> p : list) {
							addToHashMap(p.key, p.value, newMap);
						}
					}
				}
				map = newMap;
			}
		}
	}
	
	public void add(T key, U value) {
		if(addToHashMap(key, value, map)) {
			size++;
			resizeIfNecessary();
		}
	}
	
	private boolean addToHashMap(T key, U value, List<List<HashPair<T, U>>> theMap) {
		int index = getHashIndex(key);
		if(index < 0 || index >= capacity) {
			//this should never happen if we have a good hash function
			return false;
		}
		
		List<HashPair<T, U>> list = theMap.get(index);
		if(list == null) {
			list = new LinkedList<HashPair<T, U>>();
			HashPair<T, U> pair = new HashPair<T, U>(key, value);
			list.add(pair);
			theMap.set(index, list);
		} else {
			for(HashPair<T, U> p : list) {
				if(p.key.equals(key)) {
					//this hash-map already contains this key
					return false;
				}
			}
			HashPair<T, U> pair = new HashPair<T, U>(key, value);
			list.add(pair);
		}
		
		return true;
	}
	
	public boolean contains(T key) {
		int index = getHashIndex(key);
		if(index < 0 || index >= capacity) {
			//this should never happen if we have a good hash function
			return false;
		}
		
		List<HashPair<T, U>> list = map.get(index);
		if(list != null) {
			for(HashPair<T, U> p : list) {
				if(p.key.equals(key))
					return true;
			}
		}
		
		return false;
	}

	public U get(T key) {
		int index = getHashIndex(key);
		if(index < 0 || index >= capacity) {
			//this should never happen if we have a good hash function
			return null;
		}
		
		List<HashPair<T, U>> list = map.get(index);
		if(list != null) {
			for(HashPair<T, U> p : list) {
				if(p.key.equals(key))
					return p.value;
			}
		}
		
		return null;
	}
	
	public U remove(T key) {
		int index = getHashIndex(key);
		if(index < 0 || index >= capacity) {
			//this should never happen if we have a good hash function
			return null;
		}
		
		List<HashPair<T, U>> list = map.get(index);
		if(list != null) {
			HashPair<T, U> pair = null;
			for(HashPair<T, U> p : list) {
				if(p.key.equals(key)) {
					pair = p;
					break;
				}
			}
			if(pair != null) {
				U value = pair.value;
				list.remove(pair);
				size--;
				return value;
			}
		}
		
		return null;
	}
	
	public void clear() {
		if(getSize() > 0) {
			for(int i = 0; i < capacity; i++)
				map.set(0, null);
			size = 0;
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		int theSize = getSize();
		if(theSize > 0) {
			int counter = 0;
			for(int i = 0; i < capacity; i++) {
				List<HashPair<T, U>> list = map.get(i);
				if(list != null) {
					for(HashPair<T, U> p : list) {
						s.append("{");
						s.append(p.key);
						s.append(", ");
						s.append(p.value);
						s.append("}");
						counter++;
						if(theSize != counter)
							s.append(", ");
					}
				}
			}
		}
		s.append("]");
		return s.toString();
	}
	
	private int getHashIndex(T key) {
		return key.hashCode() % capacity;
	}

}
