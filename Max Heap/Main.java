
public class Main {

	public static void main(String[] args) {
		MaxBinaryHeap maxHeap = new MaxBinaryHeap();
		
		System.out.println(maxHeap.toString());
		
		maxHeap.insert(1);
		maxHeap.insert(2);
		maxHeap.insert(3);
		maxHeap.insert(4);
		maxHeap.insert(5);
		maxHeap.insert(6);
		maxHeap.insert(7);
		
		System.out.println(maxHeap.toString());
		
		maxHeap.extractMax();
		
		System.out.println(maxHeap.toString());
		
		maxHeap.extractMax();
		
		System.out.println(maxHeap.toString());

	}

}
