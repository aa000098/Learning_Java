package Lesson02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code21 {

	static int n;
	static int [][]grid;
	
	public static void main(String[] args) {
		try {
			Scanner inFile = new Scanner(new File("data.txt"));
					
			n = inFile.nextInt();
			grid = new int [n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) 
					grid[i][j] = inFile.nextInt();
			}
			inFile.close();
		
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++) {
					for (int dir = 0; dir < 8; dir++) {
						for (int length = 1; length <= n; length++) {
							int value = computeValue(x, y, dir, length);
							if (value != -1 && isPrime(value))
								System.out.println(value);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		}
	}
	
	static int computeValue(int x, int y, int dir, int len) {
		int value = 0;
		for (int i = 0; i < len; i++) {
			int digit = getDigit(x, y, dir, i);
			if (digit == -1)
				return -1;
			value = value*10+digit;
		}
		return value;
	}
	
	static int getDigit(int x, int y, int dir, int k) {
		int newX = x, newY = y;
		switch(dir) {
		case 0: newY -= k; break;
		case 1: newX += k; newY -= k; break;
		case 2: newX += k; break;
		case 3: newX += k; newY += k; break;
		case 4: newY += k; break;
		case 5: newX -= k; newY += k; break;
		case 6: newX -= k; break;
		case 7: newX -= k; newY -= k; break;
		}
		if (newX < 0 || newX >= n || newY < 0 || newY >= n)
			return -1;
		return grid[newX][newY];
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
