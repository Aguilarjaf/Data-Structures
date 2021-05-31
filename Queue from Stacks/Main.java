
public class Main {
	
	public static void main(String[] args) {
		
		stackClass s = new stackClass();
		stackClass s2 = new stackClass();
		queueClass q = new queueClass();
		int[] list = {4, 3, 6, 8, 2, 1, 9};
		
		for (int x : list) {
			q.enqueue(x);
			s.push(x);
		}
		
		System.out.println("Queue: " + q.toString());
		System.out.println("Stack: " + s.toString());
		
		while (s.getSize() > 0) 
			s2.push(s.pop());
		
		System.out.println("Queue from stack: " + s2.toString());
		
		
		
	}

}
