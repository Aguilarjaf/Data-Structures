import java.util.LinkedList;

public class HashTable {
	
	private int Size = 5;
	private LinkedList<Node>[] keyMap;
	
	@SuppressWarnings("unchecked")
	HashTable(){
		keyMap = new LinkedList[Size];
	}
	
	private int hash(String key){
		int total = 0;
		int primeNumber = 31;
		
		for(int i = 0; i < Math.min(key.length(), 100); i++) {
			char c = key.charAt(i);
			int value = c - 96;
			total = (total * primeNumber + value) % this.keyMap.length;
		}
	
		return total;
	}
	
	public void set (String key, String value) {
		
		int index = Math.abs(hash(key));
		Node keyValPair = new Node(key, value);
		
		if (this.keyMap[index] == null) {
			this.keyMap[index] = new LinkedList<Node>();
		}
		this.keyMap[index].add(keyValPair);
	}
	
	public String get(String key) {
		int index = Math.abs(this.hash(key));
		
		if (this.keyMap[index] != null) {
			for (int i = 0; i < this.keyMap[index].size(); i++) {
				if (key == this.keyMap[index].get(i).key) {
					return this.keyMap[index].get(i).value;
				}
			}
		}
		
		return null;
	}
	
	public String toString() {
		StringBuilder string = new StringBuilder();
		int i;
		int j;
		
		string.append("[");
		
		for (i = 0; i < keyMap.length - 1; i++) {
			
			if (keyMap[i] == null) {
				string.append("[],   ");
			}
			
			else {
				string.append("(");
				for (j = 0; j < keyMap[i].size() - 1; j++) {
					string.append( "[" + keyMap[i].get(j).key + ": " + keyMap[i].get(j).value + "], ");
				}
				string.append( "[" + keyMap[i].get(j).key + ": " + keyMap[i].get(j).value + "]");
				
				string.append("),   ");
			}
			
		}
		
		if (keyMap[i] == null) {
			string.append("[]]");
		}
		
		else {
			string.append("(");
			for (j = 0; j < keyMap[i].size() - 1; j++) {
				string.append( "[" + keyMap[i].get(j).key + ": " + keyMap[i].get(j).value + "], ");
			}
			string.append( "[" + keyMap[i].get(j).key + ": " + keyMap[i].get(j).value + "]");
			
			string.append(")]");
		}
		
		return string.toString();
	}

}

class Node {
	
	String key;
	String value;
	
	Node(String k, String v){
		this.key = k;
		this.value = v;
	}
}
