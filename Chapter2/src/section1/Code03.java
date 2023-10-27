package section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code03 {

	static Person1 [] members = new Person1 [100];
	static int n = 0;
	
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner (new File("input.txt"));
			while (in.hasNext()) {
				String nm = in.next();
				String nb = in.next();
				members[n] = new Person1();
				
				
				members[n].name = nm;
				members[n].number = nb;
				n++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("No data file");
		}
		bubbleSort();
		for (int i=0; i<n; i++)
			System.out.println(members[i].name + " : " + members[i].number);
	}
	
	static void bubbleSort() {
		for (int i = 0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				if(members[i].name.compareTo(members[j].name) > 0) {
					Person1 tmp = members[i];
					members[i] = members[j];
					members[j] = tmp;
				}
			}
		}
	}

}
