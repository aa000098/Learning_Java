package section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code09 {

	static MyRectangle2 [] rects = new MyRectangle2[100];
	static int n = 0;

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner (new File("data.txt"));
			while (in.hasNext()) {
				rects[n++] = new MyRectangle2(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());	// ☆☆☆☆☆
			}
		} catch (FileNotFoundException e) {
			System.out.println("NO data file");
			System.exit(1);
		}
		
		bubbleSort();
		
		for (int i = 0; i<n; i++) {
			System.out.println(rects[i].toString());
		}
	}
	
	static void bubbleSort() {
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				if (rects[i].calcArea() > rects[j].calcArea()) {
					MyRectangle2 tmp = rects[i];
					rects[i] = rects[j];
					rects[j] = tmp;
				}
			}
		}
	}
}
