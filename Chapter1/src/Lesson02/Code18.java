package Lesson02;

import java.util.Scanner;

public class Code18 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int []data = new int [n];
		for (int i = 0; i < n; i++) 
			data[i] = kb.nextInt();
		bubbleSort (data, n);
		kb.close();
		for (int i = 0; i < n; i++) 
			System.out.print(data[i] + " ");
	}
	static void bubbleSort(int [] data, int n) {
		for (int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(data[i] > data[j]) {
					int a = data[i];
					data[i] = data[j];
					data[j] = a;
				}
			}
		}
	}
	// static void swap(int a, int b) {} 
}
