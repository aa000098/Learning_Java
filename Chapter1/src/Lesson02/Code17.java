package Lesson02;

public class Code17 {

	public static void main(String[] args) {
		for (int i = 0; i<100000; i++) {
			if (isPrime(i))
				System.out.println(i);
		}

	}
	
	static boolean isPrime(int n) {
		if (n < 2) return false;
		for (int i = 2; i*i<n; i++) {
			if (n%i == 0)
				return false;
		}
		return true;
	}
}
