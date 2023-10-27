package section5;

public class MyDate {
	public int year;
	public int month;
	public int date;
	
	public MyDate(int y, int m, int d) {
		year = y;
		month = m;
		date = d;
	}
	
	public int compareTo(MyDate other) {
		if(year < other.year || year == other.month && month < other.month 
				|| year == other.year && month == other.month && date < other.date)
			return -1;
		else if(year > other.year || year == other.month && month > other.month 
				|| year == other.year && month == other.month && date > other.date)
			return 1;
		else
			return 0;
	}
	
	public String toString() {
		return year + "/" + month + "/" + date;
	}
}
