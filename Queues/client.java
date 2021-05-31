
public class client {
	
	public static void main(String[] args) {
		queueClass q = new queueClass();
		
		q.enqueue(5);
		q.enqueue(4);
		q.enqueue(3);
		q.enqueue(2);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		
		System.out.println(q.toString());
		
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
	}
}
