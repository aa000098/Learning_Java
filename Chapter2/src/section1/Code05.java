package section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code05 {

	static MyRectangle1 [] rects = new MyRectangle1[100];
	static int n = 0;

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner (new File("data.txt"));
			while (in.hasNext()) {
				rects[n] = new MyRectangle1();	// ☆☆☆☆☆
				rects[n].lu = new MyPoint1();	// ☆☆☆☆☆
				
				rects[n].lu.x = in.nextInt();
				rects[n].lu.y = in.nextInt();
				rects[n].width = in.nextInt();
				rects[n].height= in.nextInt();
				n++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("NO data file");
			System.exit(1);
		}
		
		bubbleSort();
		
		for (int i = 0; i<n; i++) {
			System.out.println(rects[i].lu.x + " " + rects[i].lu.y + " " + rects[i].height + " " + rects[i].width);
		}
	}
	static void bubbleSort() {
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				if (calcArea(rects[i]) > calcArea(rects[j])) {
					MyRectangle1 tmp = rects[i];
					rects[i] = rects[j];
					rects[j] = tmp;
				}
			}	
		}
	}
	
	static int calcArea(MyRectangle1 r) {
		return r.height*r.width;
	}
}
