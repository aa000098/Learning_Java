package section3;

public class Test {
	public int a = 10;
	public double x = 1.23;
	
	
	public String toString() {
		return a + " " + x;
	}
	/*
	public boolean equals(Test other) {
		return a == other.a && x == other.x;
	}
	*/
	// 이것은 Object 클래스의 equals 클래스를 오버라이딩 한 것은 아니다.
	// Object 클래스의 equals 클래스는 매개변수로 Object 타입을 받지만 여기서는 Test 타입이다
	// equals를 오버라이딩 하는 것이 더 유용한데 왜인지는 나중에 설명
	
	public boolean equals(Object other) {
		Test other2 = (Test)other;	// type casting
		return a == other2.a && x == other2.x;
	}
	/*
	 * equals메서드 오버라이딩
	 public boolean equals (Object obj) {
	 	if(obj == this) return true;
	 	if(obj == null) return false;
	 	if(this.getClass() == obj.getClass()) {
	 		Person other = (Person) obj;
	 		return name.equals(other.name) && number.equals(other.number);
	 		// 두 객체의 동일성을 어떤 기준으로 할지 여기서 설정
	 	}
	 	else  {
	 		return false;
	 	}
	 }
	 */
	
	public static void main(String[] args) {
		Test test1 = new Test();
		Test test2 = new Test();
		// test2.a = 5;
		// test2.x = 1.29854;
		System.out.println(test1.toString());
		
		if (test2.equals(test1))
			System.out.println("yes");
		else
			System.out.println("no");
		
		Object[] array = new Object[100];
		int a = 20;
		Integer age = new Integer(a);	// wrapping
		array[0] = age;
		array[1] = 10;
		
		int b = age.intValue();	// unwrapping
		System.out.println(array[0] + " " + b);
		
		String str = "1234";
		int c = Integer.parseInt(str);
		int d = (Integer)array[1];
		System.out.println(c + " " + d);
		
	}
}
