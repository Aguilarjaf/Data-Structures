/**
 * The class below is a stack data structure that adds and deletes 
 * values from a stack by pushing and popping them respectively.
 * 
 * The Big O runtime for this stack is:
 * Insertion - O(1)
 * Removal - O(1)
 * Searching - O(n)
 * Access - O(n)
 * 
 * @version April 5, 2020
 * */

import java.util.ArrayList;

public class stackClass {
	private Node first;
	private Node last;
	private int size;
	
	/**
	 * The method below is our constructor method for creating a stack
	 * */
	public stackClass() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	public void push(int val) {
		Node newNode = new Node(val); // Creates a node from the passed value
		
		// If the stack is empty, sets first and last to our new node
		if (this.first == null) {
			this.first = newNode;
			this.last = newNode;
		} else {
			Node temp = this.first; // Preserves the current top node
			this.first = newNode; // Makes the new node the new top node
			this.first.next = temp; // Links the new top node to the rest of the nodes below it
		}
		
		this.size++;
		
	}
	
	public int pop() {
		// Checks to see if our stack is empty
		if (this.first == null) System.out.println("Your stack is empty.");
		
		Node temp = this.first; // Creates a node variable to be returned
		
		// Checks to see if only one value exists in our stack
		if (this.first == this.last) {
			this.last = null;
		}
		
		// Makes the new top value equal to the one below the current top
		this.first = this.first.next;
		this.size--;
		
		System.out.println(temp.data); // Prints the value of the old top
		
		return temp.data; // Returns the value of the old top
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