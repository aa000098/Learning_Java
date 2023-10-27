package Lesson01;

import java.util.Scanner;

public class Code03 {

	public static void main(String[] args) {
		String str = "Hello world";
		String input = null;
		// = null 은 string 타입에서는 안해도 된다.
		
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Please type a string : ");
		input = kb.next();
		// 여기서 .next는 문자열을 입력받는다.
		// 하지만 첫 번째 단어만 입력을 받는다
		// 따라서 .next로는 띄어쓰기로 구분된 단어를 검사할 수 없다.
		
		if (str.equals(input)) // == 연산자는 프리미티브 타입 끼리만 적용 가능
			System.out.println("String match ! : -)");
		else
			System.out.println("String do not match : -(");
		
		kb.close();
	}

}
