package section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IndexMaker {

/*	
  	static String [] words = new String [100000]; 
	static int [] count = new int [100000]; 
*/	
	static Item [] items = new Item[100000];

	static int n = 0;
	
	public static void main(String[] args) {
		Scanner kb = new Scanner (System.in);
		while (true) {
			System.out.print("$ ");
			String command = kb.next();
			if (command.equals("read")) {
				String fileName = kb.next();
				makeIndex( fileName );
			}
			else if (command.equals("find")) {
				String str = kb.next();
				int index = findword(str);
				if (index != -1)
					System.out.println("The word " + items[index].word + " appears " + items[index].count + " times.");
				else
					System.out.println("The word " + str + " does not appear.");
			}
			else if (command.equals("saves")) {
				String fileName = kb.next();
				saveAs(fileName);
			}
			else if (command.equals("exit")) {
				break;
			}
		}
		kb.close();
	}
	
	static void saveAs(String fileName) {
		PrintWriter outFile;
		try {
			outFile = new PrintWriter(new FileWriter(fileName));
			for (int i=0; i<n; i++)
				outFile.println(items[i].word + " " + items[i].count);
			outFile.close();
		} catch (IOException e) {
			System.out.println("Save failed");
			e.printStackTrace();
		}
	}
	
	static void makeIndex(String fileName) {
		try {
			Scanner inFile = new Scanner(new File(fileName));
			
			while (inFile.hasNext()) {
				String str = inFile.next();
				String trimmed = trimming(str); 
				if (trimmed != null) {
					String t = trimmed.toLowerCase();
					addWord(t);
				}
			}
			
			inFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("No file");
			return;
		}
	}
	
	static String trimming(String str) {
		int i = 0, j = str.length() - 1;
		while (i < str.length() && !Character.isLetter(str.charAt(i)))
			i++;	
		while (j >= 0 && !Character.isLetter(str.charAt(j)))
			j--;
		if (i > j)
			return null;
		String trimmed = str.substring(i, j+1);
		return trimmed;
	}

	static void addWord(String str) {
		int index = findword(str);  // returns -1 if not found
		if (index != -1) { // exists 
			items[index].count++;
		}
		else {  // not exists
			int i = n - 1;
			while (i >= 0 && items[i].word.compareTo(str) > 0) {
			items[i+1] = items[i];
			i--;
			}
			items[i+1] = new Item();
			items[i+1].word = str;
			items[i+1].count = 1;
			n++;
		}
	}
	
	static int findword(String str) {
		for (int i = 0; i < n; i++) {
			if (items[i].word.equals(str))
				return i;
		}
		return -1;
	}
}
