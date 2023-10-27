package Lesson02;

import java.util.Scanner;

public class Code16 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int a = kb.nextInt();
		int b = kb.nextInt();
		
		int result = power(a, b);
		
		System.out.println(result);

		kb.close();
	}

	static int power(int a, int b) 
	{
		int prod = 1;
		for (int i = 0; i<b; i++)
			prod *= a;
		return prod;
	}
}
