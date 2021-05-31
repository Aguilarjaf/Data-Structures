
public class client {

	public static void main(String[] args) {
		stackClass s = new stackClass();
		
		s.push(5);
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		
		System.out.println(s.toString());
		
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		
		System.out.println(s.toString());
	}

}
