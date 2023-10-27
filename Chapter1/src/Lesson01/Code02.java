package Lesson01;

import java.util.Scanner;

public class Code02 {

	public static void main(String[] args) {
		int number = 123;
		
		Scanner keyboard = new Scanner(System.in);
		// Scanner를 사용하기 위해 라이브러리를 import 해줘야 한다.
		// Source의 Organize import를 눌러주면 자동으로 추가할 수 있다.
		// 스캐너가 닫히지 않았다는 오류가 뜨는게 그건 keyboard.close();
		// 를 마지막에 넣으면 된다.
		// 이는 마치 C에서 파일을 열고 닫는 것과 마찬가지다. 
		
		System.out.print("Please enter an integer : ");
		// System.out.print 여기에 ln을 붙이지 않으면 줄을 안바꿈
		
		int input = keyboard.nextInt();
		// nuxtInt() 는 마치 scanf("%d", &a); 처럼 숫자를 입력받는다.
		
		if(input == number) {
			System.out.println("Numbers match! :-)");
		}
		else
			System.out.println("Numbers do not match! : -(");
		keyboard.close();
	}

}
