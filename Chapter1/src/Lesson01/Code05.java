package Lesson01;

public class Code05 {

	public static void main(String[] args) {
		
		int [] grades;
		// grades라는 이름의 int형 배열 선언
		grades = new int[5];
		// 배열의 크기는 new int[n]을 통해 실제로 배열이 만들어짐
			
		grades[0] = 100;
		grades[1] = 76;
		grades[2] = 92;
		grades[3] = 95;
		grades[4] = 14;
		
		System.out.println(grades[0]);
		System.out.println(grades[1]);
		System.out.println(grades[2]);
		System.out.println(grades[3]);
		System.out.println(grades[4]);
	}

}
