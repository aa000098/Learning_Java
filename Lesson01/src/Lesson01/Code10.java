package Lesson01;

import java.util.Scanner;

public class Code10 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		
		boolean isPrime = true;
		for (int i=2; i*i < n && isPrime; i++) {
			// sqrt(n) 은 루트 n 이다.
			if (n % i == 0)
				isPrime = false;
		}
		if (isPrime)
			System.out.println("It is Prime");
		else
			System.out.println("It is not Prime");
		kb.close();
	}

}
