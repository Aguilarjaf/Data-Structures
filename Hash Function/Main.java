
public class Main {
	
	public static void main(String[] args) {
		
		HashTable h = new HashTable();
		h.set("Yellow", "555");
		h.set("Blue", "111");
		h.set("Red", "222");
		h.set("Red", "222");
		h.set("Orange", "333");
		h.set("Purple", "Dog");
		
		System.out.println(h.toString());
		System.out.println(h.get("Purple"));
	}
}
