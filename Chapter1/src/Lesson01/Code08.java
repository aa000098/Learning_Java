package Lesson01;

import java.util.Scanner;

public class Code08 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please type the numbers : ");
		int n = kb.nextInt();
		int [] data = new int [n];
		
		for (int i = 0; i < n; i++)
			data[i] = kb.nextInt();
		kb.close();
		
		int sum = 0;
		int max = data[0];
		for (int i = 0; i < n; i++) {
			sum += data[i];
			if (data[i] > max)
				max = data[i];
		}
		System.out.println("This sum is " + sum);
		System.out.println("This max is " + max);

	}

}
