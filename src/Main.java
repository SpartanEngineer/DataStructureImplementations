import java.util.*;


public class Main {

	public static void main(String[] args) {
		
		DynamicArray<Integer> dArray = new DynamicArray<Integer>();
		for(int i = 1; i <= 25; i++)
			dArray.set(i-1, i);
		dArray.set(101, 100);
		System.out.println(dArray.toString());
		
		System.out.print("[ ");
		for(int i = 0; i < 25; i++)
			System.out.print("" + dArray.get(i) + " ");
		System.out.println("]");
		System.out.println("");
		System.out.println("");
		
		MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
		System.out.println(linkedList.toString());
		for(int i = 0; i < 10; i++)
			linkedList.add(i);
		System.out.println(linkedList.toString());
		System.out.println("size: " + linkedList.getSize());
		for(int i = 0; i < 10; i++)
			System.out.print(linkedList.get(i) + " ");
		System.out.println("");
		System.out.println("removed: " + linkedList.remove());
		System.out.println("removed: " + linkedList.remove());
		linkedList.insert(5, 25);
		linkedList.insert(9, 45);
		linkedList.addBeginning(80);
		linkedList.addEnd(100);;
		System.out.println(linkedList.toString());
		System.out.println("size: " + linkedList.getSize());
		linkedList.clear();
		System.out.println(linkedList.toString());
		System.out.println("");
		System.out.println("");
		
		MyStack<Integer> stack = new MyStack<Integer>();
		System.out.println(stack.toString());
		for(int i = 0; i < 10; i++)
			stack.add(i);
		System.out.println(stack.toString());
		System.out.println("size: " + stack.getSize());
		System.out.println("popped: " + stack.pop());
		System.out.println("popped: " + stack.pop());
		System.out.println("peek: " + stack.peek());
		System.out.println("popped: " + stack.pop());
		System.out.println(stack.toString());
		System.out.println("size: " + stack.getSize());
		stack.clear();
		System.out.println(stack.toString());
		System.out.println("");
		System.out.println("");
		
		MyQueue<Integer> queue = new MyQueue<Integer>();
		System.out.println(queue.toString());
		for(int i = 0; i < 10; i++)
			queue.add(i);
		System.out.println(queue.toString());
		System.out.println("size: " + queue.getSize());
		System.out.println("popped: " + queue.pop());
		System.out.println("popped: " + queue.pop());
		System.out.println("peek: " + queue.peek());
		System.out.println("popped: " + queue.pop());
		System.out.println(queue.toString());
		System.out.println("size: " + queue.getSize());
		stack.clear();
		System.out.println(stack.toString());
		System.out.println("");
		System.out.println("");
		
		
		MyHashMap<Integer, String> map = new MyHashMap<Integer, String>();
		System.out.println(map.toString());
		map.add(0, "a");
		map.add(1, "b");
		map.add(2, "c");
		map.add(3, "d");
		map.add(4, "e");
		System.out.println(map.toString());
		System.out.println(map.getSize());
		map.remove(2);
		map.remove(3);
		System.out.println(map.toString());
		System.out.println(map.getSize());
		for(int i = 4; i < 100; i++)
			map.add(i, "z");
		System.out.println(map.toString());
		System.out.println(map.getSize());
		map.clear();
		System.out.println(map.toString());
		System.out.println("");
		System.out.println("");
		
		MyHashMap<String, Integer> map2 = new MyHashMap<String, Integer>();
		System.out.println(map2.toString());
		for(int i = 0; i < 100; i++)
			map2.add("a"+i, i);
		System.out.println(map2.toString());
		System.out.println(map2.getSize());
		map2.clear();
		System.out.println(map2.toString());
		
		int[] arr = new int[10];
		for(int i = 0; i < 10; i++)
			arr[i] = i;
		
		int size = arr.length;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < size; i++) {
			if(arr[i] > max)
				max = arr[i];
		}
		System.out.println("max: " + max);
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		int[] arr2 = new int[0];
		System.out.println("max: " + getMax(arr));
		
		String[] arr3 = {"A", "B", "C"};
		System.out.println(contains(arr3, "A"));
		System.out.println(contains(arr3, "B"));
		System.out.println(contains(arr3, "C"));
		System.out.println(contains(arr3, "D"));
		System.out.println(contains(arr3, "E"));
		System.out.println(contains(arr3, null));
		System.out.println(contains(arr3, ""));
		
		MyLinkedList<Integer> test = new MyLinkedList<Integer>();
		for(int i = 200; i < 210; i++)
			test.add(i);
		for(Integer i : test)
			System.out.println(i);

		List<Integer> test2 = new ArrayList<Integer>();
		for(int i = 300; i < 310; i++)
			test2.add(i);
		test2.stream().filter(i -> i >= 305).forEach(i -> System.out.println(i));
	}
	
	public static int getMax(int[] arr) {
		if(arr == null)
			return Integer.MIN_VALUE;
		
		int size = arr.length;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < size; i++) {
			if(arr[i] > max)
				max = arr[i];
		}
		
		return max;
	}
	
	public static int getSum(int[] arr) {
		if(arr == null)
			return 0;
		
		int size = arr.length;
		int sum = 0;
		
		for(int i = 0; i < size; i++)
			sum += arr[i];
		
		return sum;
	}
	
	public static boolean contains(String[] arr, String s) {
		if(s == null)
			return false;
		
		int size = arr.length;
		for(int i = 0; i < size; i++)
			if(arr[i].equals(s))
				return true;
		
		return false;
	}

}