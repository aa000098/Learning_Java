package Lesson01;

import java.util.Scanner;

public class Code09 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please type numbers : ");
		int a;
		int n = kb.nextInt();
		int [] data = new int [n];
		for (int i = 0; i < n; i++) {
			data[i] = kb.nextInt();
			a = data[i];
			data[i] = data[0];
			data[0] = a;
		}
		for (int i = 0; i < n; i++)
			System.out.println(data[i]);
		kb.close();
	}

}
