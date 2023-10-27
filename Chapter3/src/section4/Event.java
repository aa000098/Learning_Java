package section4;

public abstract class Event implements Comparable {	// 클래스 안에 추상 메서드가 있으면 클래스도 추상 클래스가 되어야 함.
	// event 클래스는 코드에서 만들지 않음. 우리는 event 객체를 만들지 않는다고 선언하는 것임
	public String title;
	public Event(String title) {
		this.title = title;
	}
	
	public abstract boolean isRelevant(MyDate date);
	// 이렇게 하위 클래스의 메서드를 사용하고 싶을 때 상위 클래스에서는 사용할 수 없다.
	// 이것을 하기 위해서는 추상 메서드, 추상 클래스를 사용해야 한다.
	// 이렇게 추상 클래스를 만들면 객체를 만들 수 없게 된다.
	
	public abstract MyDate getRepresentativeDate();
	
	public int compareTo(Object other) {
		MyDate mine = getRepresentativeDate();
		MyDate yours = ((Event)other).getRepresentativeDate();
		return mine.compareTo(yours);
	}
}
