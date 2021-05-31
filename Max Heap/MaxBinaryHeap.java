import java.util.Arrays;

public class MaxBinaryHeap {
	
	private int[] values = new int[0];
	
	public MaxBinaryHeap() {
	}
	
	public void insert(int element) {
		int[] newHeap = new int[this.values.length + 1];
		
		int i;
		for (i = 0; i < this.values.length; i++) {
			newHeap[i] = this.values[i];
		}
		
		newHeap[i] = element;
		
		this.values = newHeap;
		
		
		this.bubbleUp();
	}
	
	private void bubbleUp() {
		// index is set to the end, indiciating the newest element
		int index = this.values.length - 1;
		int element = this.values[index];
		
		// while the element is not at index 0
		while (index > 0) {
			
			// Find the parent of the newly added children element
			int parentIndex = (index - 1) / 2;
			int parent = this.values[parentIndex];
			
			// If element is <= parent it is in the right spot
			if (element <= parent) break;
			
			// If the element is not <= parent, we swap the parent and the element
			this.values[parentIndex] = element;
			this.values[index] = parent;
			
			// The child index is now set to the old parent index, allowing it to compare to any other parent nodes if they exist
			index = parentIndex;
		}
		
	}
	
	public void extractMax() {
		
		if (this.values.length == 0) return;
		
		//int max = this.values[0]; // Store the value of the max
		
		// Store the end value
		int endIndex = this.values.length - 1;
		int end = this.values[endIndex];
		
		int[] newHeap = new int[endIndex];
		
		for (int i = 0; i < endIndex; i++) {
			newHeap[i] = this.values[i];
		}
		
		this.values = newHeap;
		
		if (this.values.length > 0) {
			this.values[0] = end;
			this.sinkDown();
		}
		
	}
	
	private void sinkDown() {
		int index = 0;
		int length = this.values.length;
		int element = this.values[0];
		
		while (true) {
			int leftChildIndex = 2 * index + 1; 
			int rightChildIndex = 2 * index + 2;
			int leftChild = 0;
			int rightChild = 0;
			
			int swap = 0;
			
			if (leftChildIndex < length) {
				leftChild = this.values[leftChildIndex];
				
				if (leftChild > element) {
					swap = leftChildIndex;
				}
			}
			
			if (rightChildIndex < length) {
				rightChild = this.values[rightChildIndex];
				
				if (swap == 0 && rightChild > element || swap != 0 && rightChild > leftChild) {
					swap = rightChildIndex;
				}
			}
			
			if (swap == 0) break;
			
			// swap
			this.values[index] = this.values[swap];
			this.values[swap] = element;
			index = swap;
			
		}
	}
	
	public String toString() {
		return Arrays.toString(this.values);
	}

}
