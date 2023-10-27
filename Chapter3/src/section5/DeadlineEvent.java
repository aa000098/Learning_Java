package section5;

public class DeadlineEvent extends Event{
	public MyDate deadline;
	
	public DeadlineEvent(String t, MyDate d) {
		super(t);
		deadline = d;
	}
	
	public boolean isRelevant(MyDate date) {
		return deadline.compareTo(date) >= 0;
	}
	
	public String toString() {
		return title + ", " + deadline.toString();
	}
	
	public MyDate getRepresentativeDate() {
		return deadline;
	}
}
