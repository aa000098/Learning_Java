package section2;

public class DurationEvent extends Event{
	public MyDate begin;
	public MyDate end;
	
	public DurationEvent(String t, MyDate b, MyDate e) {
		super(t);
		begin = b;
		end = e;
	}
	
	public String toSrting() {
		return title + ", " + begin.toString() + " ~ " + end.toString();
	}
}
