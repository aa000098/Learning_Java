package section2;

public class OneDayEvent extends Event{
	public MyDate date;
	
	public OneDayEvent(String t, MyDate d) {
		super(t);
		date = d;
	}
	
	public String toString() {
		return title + ", " + date.toString();
	}
} 
