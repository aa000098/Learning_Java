package Lesson01;

import java.util.Scanner;

public class Code12 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] data = new int [n];
		
		for (int i = 0; i < n; i++)
			data[i] = kb.nextInt();
		int nbr = 0;
		for (int i = 1; i <= n; i++)
			nbr += i;
		int [] max = new int [nbr];
		
		int index = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= n-i; j++) {
				int sum = 0;
				for (int k = j; k < j + i; k++)
					sum += data[k];
				max[index++] = sum;
			}
		}
		for (int i = 0; i < nbr - 1; i++) {
			if (max[i+1] < max[i])
				max[i+1] = max[i];
		}
		
		System.out.println("The max sum is " + max[nbr - 1]);
		
		kb.close();

	}

}
