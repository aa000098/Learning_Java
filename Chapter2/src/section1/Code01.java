package section1;

public class Code01 {

	public static void main(String[] args) {
		Person1 first = new Person1();	// new가 생성하는 것을 객체라고 한다.
		
		first.name = "John";
		first.number = "010-1111-1111";
		
		Person1 [] members = new Person1[10];
		
		members[0] = first;
		members[1] = new Person1();

		Person1 second = first;
		second.name = "Tom";
		second.number = "010-2222-2222";
		System.out.println("Name : " + first.name + ", Number : " + first.number);

		System.out.println("Name : " + second.name + ", Number : " + second.number);
	}
}
