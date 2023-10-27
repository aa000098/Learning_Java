package section2;

public class MyDate {
	public int year;
	public int month;
	public int date;
	
	public MyDate(int y, int m, int d) {
		year = y;
		month = m;
		date = d;
	}
	
	public String toString() {
		return year + "/" + month + "/" + date;
	}
}
