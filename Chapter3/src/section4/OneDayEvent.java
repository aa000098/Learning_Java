package section4;

public class OneDayEvent extends Event{
	public MyDate date;
	
	public OneDayEvent(String t, MyDate d) {
		super(t);
		date = d;
	}
	
	public boolean isRelevant(MyDate date) {
		// if(this.date.year == date.year && this.date.month == date.month && this.date.date == date.date)
		return this.date.compareTo(date) == 0;
	}
	
	public String toString() {
		return title + ", " + date.toString();
	}
	
	public MyDate getRepresentativeDate() {
		return date;
	}
} 
