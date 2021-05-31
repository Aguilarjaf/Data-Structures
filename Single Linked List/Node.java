import java.util.ArrayList;

public class Node {
	Node next;
	int data;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class SinglyLinkedList {
	
	private Node head;
	private Node tail;
	private int length = 0;
	
	/**
	 * The method below returns the head of the linked list
	 * */
	public Node getHead() {
		return this.head;
	}
	
	/**
	 * The method below returns the tail of the linked list
	 * */
	public Node getTail() {
		return this.tail;
	}
	
	/**
	 * The method below adds nodes to our linked list.
	 * */
	public void push(int val) {
		Node newNode = new Node(val);
		
		if (this.head == null) {
			this.head = newNode;
			this.tail = this.head;
		} else {
			this.tail.next = newNode;
			this.tail = newNode;
		}
		
		this.length++;
	}
	
	/**
	 * The method below removes the last node of our linked list.
	 * */
	public int pop() {
		if(this.head == null) throw new IllegalArgumentException("There are no more values to pop.");
		Node current = this.head;
		Node newTail = current;
		
		while (current.next != null) {
			newTail = current;
			current = current.next;
		}
		
		this.tail = newTail;
		this.tail.next = null; // Severs the link to the returned node
		this.length--;
		
		if (this.length == 0) {
			this.head = null;
			this.tail = null;
		}
		return current.data;
	}
	
	/**
	 * The method below inserts a value into a given index in our liked list
	 * */
	public void insert(int index, int val) {

		// Checks if the index provided is bigger or smaller than our linked list
		if (index < 0 || index >= this.length) {
			throw new IllegalArgumentException("This index is either less than zero or greater than our linked list size.");		
		}
		
		// The if statements below call other methods if the provided index is
		// at the end or beginning of the linked list
		if (index == this.length) this.push(val);
		if (index == 0) this.newHead(val);
		
		Node newNode = new Node(val); // Creates a new node of the provided value
		
		// Gets the node at the location before the provided index for which our 
		// new node must be inserted
		Node prev = this.getNodeAtIndex(index - 1);
		
		// Links the previous node to our new node, and then links
		// our new node to the rest of the linked list
		Node temp = prev.next; // Keeps the link to the rest of the linked list
		prev.next = newNode;
		newNode.next = temp;
		
		this.length++;
			
	}
	
	/**
	 * The method below removes a node at a given index
	 * */
	public void remove(int index) {
		
		// Checks if the index provided is bigger or smaller than our linked list
		if (index < 0 || index >= this.length) {
			
			throw new IllegalArgumentException("This index is either less than zero or greater than our linked list size.");	
			
		}
		
		// The if statements below call other methods if the provided index is
		// at the end or beginning of the linked list
		if (index == 0) {
			
			this.shift(); // Removes at beginning
			
		} else if (index == this.length - 1) {
			
			this.pop(); // Removes at end
			
		} else {
			
			// The remove method works by getting the node before the one at our provided 
			// index and linking it to the node after our provided index. This then
			// allows us to remove the node at our provided index
			Node previousNode = this.getNodeAtIndex(index - 1);
			Node toRemove = previousNode.next;
			previousNode.next = toRemove.next;
			
			toRemove = null; // Restores memory by setting removed node to null
			this.length--;
		}
		
	}
	
	/**
	 * The method below shifts the head of the linked list, assigning the 
	 * new head to that of the next node of the current head.
	 * 
	 * In other words, this method removes the head of our linked list
	 * */
	public int shift() {
		if (this.head == null) throw new IllegalArgumentException("Your head pointer is null");
		Node currentHead = this.head;
		this.head = currentHead.next;
		this.length--;
		
		if(this.length == 0) {
			this.tail = null;
		}
		return currentHead.data;
	}
	
	/**
	 * The method below adds a new head to our linked list.
	 * */
	public String newHead(int val) {
		Node newNode = new Node(val);
		if (this.head == null) {
			this.head = newNode;
			this.tail = this.head;
		} else {
			newNode.next = this.head;
			this.head = newNode;
		}
		
		this.length++;
		
		return this.toString();
	}
	
	/**
	 * The method below returns a value at a given index.
	 * */
	public int getIndex(int index) {

		// Base case
		if (index < 0 || index >= this.length) {
			throw new IllegalArgumentException("This index is either less than zero or greater than our linked list size.");
		}
		
		Node current = this.head;
		
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		
		return current.data;
	}
	
	/**
	 * The method below returns the node at a given index
	 * */
	public Node getNodeAtIndex(int index) {
		// Base case
		if (index < 0 || index >= this.length) {
			throw new IllegalArgumentException("This index is either less than zero or greater than our linked list size.");
		}
		
		Node current = this.head;
		
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		
		return current;
	}
	
	/**
	 * The method below sets the value at an index of our linked list. This 
	 * method was intended to work with the get method above, but because the
	 * get method returns an int, we must copy over the code and only extract
	 * the node that is found at the given index.
	 * */
	public boolean set(int index, int value) {
		
		// Base case
		if (index < 0 || index >= this.length) {
			throw new IllegalArgumentException("This index is either less than zero or greater than our linked list size.");	
		}
		
		Node current = this.head;
				
		for (int i = 0; i < index; i++) {
			current = current.next;	
		}
		
		Node foundNode = current;
		
		if (foundNode != null) {
			foundNode.data = value;
			return true;
		}
		
		return false;
	}
	
	/**
	 * The method below makes our entire linked list empty
	 * */
	public void empty() {
		for (int i = this.length - 1; i >= 0; i--) {
			this.remove(i);
		}
	}
	
	/**
	 * The method below allows us to reverse our list
	 * */
	public void reverse() {
		Node node = this.head;
		this.head = this.tail; // Makes the head equal to the tail
		this.tail = node; // Makes the tail equal to the head
		Node next;
		Node prev = null;
		
		// The for loop below allows our reverse to happen
		for (int i = 0; i < this.length; i++) {
			// Pass 1: 2 | Pass 2: 3 | Pass 3: 4 | Pass 4: 5...
			next = node.next;
			
			// Pass 1: null | Pass 2: 1 | Pass 3: 2 | Pass 4: 3... 
			node.next = prev;
			
			// Pass 1: 1 | Pass 2: 2 | Pass 3: 3 Pass 4: 4... 
			prev = node;
			
			// Pass 1: 2 | Pass 2: 3 | Pass 3: 4 | Pass 4: 5... 
			node = next;
		}
	}
	
	/**
	 * The method below returns our linked list as a string
	 * */
	public String toString() {
		
		ArrayList<Integer> listArray = new ArrayList<>();
		
		Node current = this.head;
		Node newTail = current;
		if (length == 0) {
			return "Your linked list is empty";
		} else {
			for (int i = 0; i < this.length; i++) {
				newTail = current;
				listArray.add(newTail.data);
				current = current.next;
			}
		}
		
		return listArray.toString();
	}

}