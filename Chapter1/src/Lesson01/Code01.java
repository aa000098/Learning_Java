package Lesson01;

public class Code01 {
	
	static int num;
	
	public static void main(String[] args) {
		int anotherNum = 5;
		num = 2;

		System.out.println(num + anotherNum);
		// 여기서 +는 숫자와 숫자를 더하는 기능
		System.out.println("Num :" + num);
		// 여기서 +는 왼쪽 오른쪽 중 하나라도 문자열이면 숫자를 문자열로 변환
		System.out.println("AnotherNum : " + anotherNum);
		System.out.println("Sum : " + num + anotherNum);
		/* 
		여기서 진행 순서가 앞에 문자열 + 숫자가 먼저 진행된다.
		그럼 Sum : + num 이기 때문에 Sum : 2 가 먼저 출력되고
		그럼 Sum : 2 + anotherNum 이 진행되는데 이때도 문자열 + 숫자이므로
		Sum : 25 가 출력되게 된다. 
		숫자 덧셈을 먼저 하기 위해서는 숫자끼리 괄호를 해주면 된다.
		*/
		System.out.println("Sum : " + (num + anotherNum));
	}
}

/*

*/
