package section5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Scheduler {

//	private int capacity = 10;
	public ArrayList<Event> events = new ArrayList<>();
	// public Event [] events = new Event [capacity];
//	public int n = 0;
	Scanner kb = new Scanner(System.in);
	
	public void processCommand() {
		while (true) {
			System.out.print("$ ");
			String command = kb.next();
			if (command.equals("addevent")) {
				String type = kb.next();
				if (type.equalsIgnoreCase("oneday"))
					handleAddOneDayEvent();
				else if (type.equalsIgnoreCase("duration"))
					handleAddDuration();
				else if (type.equalsIgnoreCase("deadline"))
					handleAddDeadlinedEvent();
			}
			else if (command.equals("list")) {
				handleList();
			}
			else if (command.equals("show")) {
				handleShow();
			}
			else if (command.equals("sort")) {
				Collections.sort(events);
			}
			else if (command.equals("exit")) {
				break;
			}
		}
		kb.close();
	}
	
	private void handleShow() {
		String dateString = kb.next();
		MyDate theDate = parseDateString(dateString); 
		for (Event ev : events) {
			if(ev.isRelevant(theDate))	// event 타입에는 isRelevant가 없으므로 문제가 생김
				System.out.println("    " + ev.toString());	// toString은  Oject클래스에 toString이 있으므로 
				//	toString이 있다고 가정하고 진행해서 후에 타이나믹 바인딩이 실행되어 객체 안의 toString이 실행됨. 
		}
	}

	private void handleList() {
//		for (int i = 0; i<events.size(); i++)
		for (Event ev : events)	// enhanced for loop
			System.out.println("    " + ev.toString());	// dynamic binding
	}

	private void handleAddDeadlinedEvent() {
		System.out.print("When : ");
		String dateString = kb.next();
		System.out.print("Title : ");
		String title = kb.next();
		
		MyDate date = parseDateString (dateString);
		DeadlineEvent ev = new DeadlineEvent(title, date);
		addEvent(ev);
	}

	private void handleAddDuration() {
		System.out.print("begin : ");
		String beginString = kb.next();
		System.out.print("end : ");
		String endString = kb.next();
		System.out.print("Title : ");
		String title = kb.next();
		
		MyDate begin = parseDateString (beginString);
		MyDate end = parseDateString (endString);
		
		DurationEvent ev = new DurationEvent(title, begin, end);
		addEvent(ev);
	}

	private void handleAddOneDayEvent() {
		System.out.print("When : ");	// 문자열 쪼개기, Tokemizing, 2020/05/22 여기서 /는 구분자, str.split("/");
		String dateString = kb.next();
		
		MyDate date = parseDateString(dateString);
		System.out.print("Title : ");
		String title = kb.next();
		OneDayEvent ev = new OneDayEvent(title, date);
		// System.out.println(ev.toString());
		addEvent(ev);	// 배열 재할당을 위해 새로운 함수에서 배열 할당
	}

	private void addEvent(Event ev) {
//		if (n >= capacity)
//			reallocate();
		events.add(ev);	// 여기서 다형성이 적용됨. 
		// events는 event타입이지만 ev는 evnet타입의 서브클래스인 onedatevent 타입임
	}
/*
	private void reallocate() {
		Event[] tmp = new Event[capacity * 2];
		for (int i=0; i<n; i++)
			tmp[i] = events[i];
		events = tmp;
		capacity *= 2;
	}
*/
	private MyDate parseDateString(String dateString) {
		String [] tokens = dateString.split("/");
		/* 
		splitting a string 할 때 공백을 기준으로 단어를 자르는 것이 가장 많음 이때는 다음과 같이 하는 것이 좋음
		String [] tokens = str.split("[]+"); 이것은 다수의 공백을 구분자로 할 수 있음
		String [] tokens = str.split("\\s+"); 이것은 모든 white space를 포함
		.을 구분자로 사용하기 위해서는 \\.을 split 안에 넣어줘야 함. = str.split("\\.");
		이것을 알기 위해서는 regular expression 에 대해 공부하는 것이 좋음
		regular expression에서 \ 백슬레쉬는 escape character라고 부르는데 그 것은 다음 문자의 의미를 빼앗는다는 의미이다. 
		그런데 백슬레쉬가 두개인 것은 자바 스트링 안에서 백슬레쉬가 또 special character이기 때문에 하나 더 필요한 것이다.
		*/
		int year = Integer.parseInt(tokens[0]);	// integer에 parseInt는 문자열을 숫자로 만들어준다.
		int month = Integer.parseInt(tokens[1]);
		int date = Integer.parseInt(tokens[2]);
		MyDate MyMyDate =new MyDate(year, month, date);
		return MyMyDate;
	}
	
	

	public static void main(String[] args) {
		Scheduler app = new Scheduler();
		app.processCommand();
	}

}
