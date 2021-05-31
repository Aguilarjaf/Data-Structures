/**
 * The class below is a queue data structure that adds and deletes 
 * values from a queue by enqueing and dequeing them respectively.
 * 
 * The Big O runtime for this queue is:
 * Insertion - O(1)
 * Removal - O(1)
 * Searching - O(n)
 * Access - O(n)
 * 
 * @version April 5, 2020
 * */

import java.util.ArrayList;

public class queueClass {
	private Node first;
	private Node last;
	private int size;
	
	/**
	 * The method below is our constructor method for creating a stack
	 * */
	public queueClass() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	public void enqueue(int val) {
		
		Node newNode = new Node(val);
		
		if (this.first == null) {
			this.first = newNode;
			this.last = newNode;
		} else {
			this.last.next = newNode;
			this.last = newNode;
		}
		
		this.size++;
		
	}
	
	public int dequeue() {
		
		if (this.first == null) {
			System.out.println("Your queue is empty.");
			// Breaks the rest of the method and returns -1 to indicate the queue is empty
			return -1; 
		}
		
		Node temp = this.first;
		
		if (this.first == this.last) {
			this.last = null;
		}
		
		this.first = this.first.next;
		
		this.size--;
		
		System.out.println(temp.data);
		
		return temp.data;
	}
	
	public String toString() {
		ArrayList<Integer> listArray = new ArrayList<>();
		
		Node current = this.first;
		Node newTail = current;
		
		if (size == 0) {
			
			return "Your linked list is empty";
			
		} else {
			
			for (int i = 0; i < this.size; i++) {
				newTail = current;
				listArray.add(newTail.data);
				current = current.next;
			}
			
		}
		
		return listArray.toString();
	}
}

class Node {
	Node next;
	int data;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}