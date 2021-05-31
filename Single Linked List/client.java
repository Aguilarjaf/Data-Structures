
public class client {

	public static void main(String[] args) {
		var linkedList = new SinglyLinkedList();
		linkedList.push(5);
		linkedList.push(4);
		linkedList.push(3);
		linkedList.push(2);
		linkedList.push(1);
		
		System.out.println(linkedList.toString());
		
		linkedList.reverse();
		
		System.out.println(linkedList.getTail().data);
		
		System.out.println(linkedList.toString());
		
		

	}

}
