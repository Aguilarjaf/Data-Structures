
public class client {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.push(5);
		list.push(4);
		list.push(3);
		list.push(2);
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		
		System.out.println(list.toString());

	}

}
