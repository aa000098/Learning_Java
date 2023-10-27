package section2;

public class DeadlineEvent extends Event{
	public MyDate deadline;
	
	public DeadlineEvent(String t, MyDate d) {
		super(t);
		deadline = d;
	}
	
	public String toSrting() {
		return title + ", " + deadline.toString();
	}
}
