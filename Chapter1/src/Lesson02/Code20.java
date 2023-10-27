package Lesson02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code20 {

	static String [] name = new String[100];
	static String [] number = new String[100];
	static int n = 0;
	
	public static void main(String[] args) {
		
		Scanner inFile;
		try {
			inFile = new Scanner(new File("input.txt"));
			
			while (inFile.hasNext()) {
				name[n] = inFile.next();
				number[n] = inFile.next();
				n++;
			}
			
			inFile.close();
		} catch (FileNotFoundException e) {
			System.out.println ("NO file");
			System.exit(1);
		}
		
		bubbleSort();
		
		for (int i = 0; i<n; i++) 
			System.out.println(name[i] + ": " + number[i]);

	}
	
	static void bubbleSort() {
		for (int i = 0; i<n; i++) {
			for (int j = i+1; j<n; j++) {
				if (name[i].compareTo(name[j]) > 0) {
					String tmp = name[i];
					name[i] = name[j];
					name[j] = tmp;
					
					tmp = number[i];
					number[i] = number[j];
					number[j] = tmp;
				}
			}
		}
	}

}
