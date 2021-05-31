import java.util.ArrayList;

public class Node {
	Node next;
	Node prev;
	int data;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

class DoublyLinkedList {
	private Node head;
	private Node tail;
	private int length;
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public void push(int val) {
		Node newNode = new Node(val);
		
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.next = newNode;
			newNode.prev = this.tail;
			this.tail = newNode;
		}
		
		this.length++;
	}
	
	public Node pop() {
		if (this.head == null) throw new IllegalArgumentException();
		Node poppedNode = this.tail;
		
		if (this.length == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.tail = poppedNode.prev;
			this.tail.next = null;
			poppedNode.prev = null;
		}
		
		this.length--;
		
		return poppedNode;
	}
	
	public Node shift() {
		if (this.head == null) throw new IllegalArgumentException();
		
		Node oldHead = this.head;
		
		if(this.length == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = oldHead.next;
			this.head.prev = null;
			oldHead.next = null;
		}
		
		this.length--;
		
		return oldHead;
	}
	
	public void unshift(int val) {
		Node newNode = new Node(val);
		
		
		if (this.length == 0) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.head.prev = newNode;
			newNode.next = this.head;
			this.head = newNode;
		}
		
		this.length++;
	}
	
	public Node get(int index) {
		if (index < 0 || index >= this.length) throw new IllegalArgumentException();
		
		int count;
		Node current;
		
		if(index  <= this.length / 2) { // Working from the start
			System.out.println("Working from start");
			
			count = 0;
			current = this.head;
			
			while (count != index) {
				current = current.next;
				count++;
			}

		} else { // Working from the end
			System.out.println("Working from end");
			
			count = this.length - 1;
			current = this.tail;
			
			while (count != index) {
				current = current.prev;
				count--;
			}
		}
		
		return current;
		
	}
	
	public Boolean set(int index, int val) {
		
		Node foundNode = this.get(index);
		
		if(foundNode != null) {
			foundNode.data = val;
			return true;
		}
		
		return false;

	}
	
	public void insert(int index, int val) {
		if (index < 0 || index > this.length) throw new IllegalArgumentException();
		if (index == 0)  this.unshift(val);
		if (index == this.length)  this.push(val);
		
		Node newNode = new Node(val);
		Node beforeNode = this.get(index-1);
		Node afterNode = beforeNode.next;
		
		beforeNode.next = newNode; newNode.prev = beforeNode;
		newNode.next = afterNode; afterNode.prev = newNode;
		
		this.length++;
	}
	
	public void remove(int index) {
		if (index < 0 || index > this.length) throw new IllegalArgumentException();
		if (index == 0) this.shift();
		if (index == this.length - 1) this.pop();
		
		Node removedNode = this.get(index);
		
		removedNode.prev.next = removedNode.next;
		removedNode.next.prev = removedNode.prev;
		
		removedNode.next = null;
		removedNode.prev = null;
		
		this.length--;
		
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