package Lesson01;

public class Code07 {

	public static void main(String[] args) {
		int [] grades = new int[5];
		// 변수의 크기를 꼭 상수로 안넣어도 되고 변수로 넣어도 됨.
		// 이걸 variable length array 라고 함.
		
		grades[0] = 100;
		grades[1] = 76;
		grades[2] = 92;
		grades[3] = 95;
		grades[4] = 14;
		
		int i = 0;
		while (i < grades.length) {
			// 배열의 크기를 .length를 통해 편하게 구할 수 있다.
			System.out.println(grades[i++]);
		}
			

	}

}
