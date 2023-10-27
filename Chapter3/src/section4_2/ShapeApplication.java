package section4_2;

import java.util.Arrays;
import java.util.Scanner;

public class ShapeApplication {

	private int capacity = 10;
	private Shape [] shapes = new Shape[capacity]; 
	private int n = 0;
	private Scanner kb = new Scanner(System.in);
	
	public void processCommand() {
		while (true) {
			System.out.print("$ ");
			String command = kb.next();
			if (command.equals("add"))
				handleAdd();
			else if (command.equals("show") || command.equals("showdetail"))
				handleShow(command.equals("showdetail"));
			else if (command.equals("sort"))
				Arrays.sort(shapes, 0, n);	// 자바 표준 라이브러리에서 제공
				// 다만 array.sort 메서드를 사용하려면 Comparable interface를 implements 하고, compareTo 메서드를 정의해야 함. (판정 규칙)
				// MyUtilities.bubbleSort(shapes, n);
			else if (command.equals("exit"))
				break;
		}
		kb.close();
	}
	
/*
	private void bubbleSort() {
		for (int i=0; i<n; i++) {
			for (int j = i; j<n-1; j++) {
				if (shapes[i].computeArea() > shapes[j].computeArea()) {
					Shape tmp = shapes[j];
					shapes[j] = shapes[i];
					shapes[i] = tmp;
				}
			}
		}
	}
	// bubbleSort 메서드는 generic하지 않다고 함
	// 이 메서드는 오직 shape 타입만 정렬할 수 있음
	// sorting 알고리즘은 만들어 놓고 어떤 것이든 정렬할 수 있게 만들면 generic하다고 함 -> 코드 재사용(reuse)
	// 그래서 그것을 위해 interface를 사용

	private void bubbleSort(MyComparable[] data, int size) {
		for (int i=0; i<size-1; i++) {
			for (int j = i; j<size; j++) {
				if (data[i].compareTo(data[j]) > 0) {
					MyComparable tmp = data[j];
					data[j] = data[i];
					data[i] = tmp;
				}
			}
		}
	}
*/
	
	private void handleShow(boolean detailed) {
		for (int i=0; i<n; i++) {
			System.out.println( (i + 1) + ". " + shapes[i].toString() );
			if (detailed) {
				System.out.println("    The area is " + shapes[i].computeArea() );
				System.out.println("    The perimeter is " + shapes[i].computePerimeter() );
			}
		}
		
	}

	private void handleAdd() {
		String type = kb.next();
		switch (type) {		// C언어에서는 비교 대상이 정수 실수 등 기본 타입이어야 함, 문자열에 대해 switch문은 사용할 수 없음
		case "R":
			addShape( new Rectangle ( kb.nextInt(), kb.nextInt() ) );
			break;
		case "C":
			addShape( new Circle (kb.nextInt() ) );
			break;
		case "T":
			addShape( new RtTriangle( kb.nextInt(), kb.nextInt() ) );
			break;
		}
	}

	private void addShape(Shape shape) {
		if (n >= capacity)
			reallocate();
		shapes[n++] = shape;
	}

	private void reallocate() {
		capacity *= 2;
		Shape[] tmp = new Shape[capacity];
		System.arraycopy(shapes, 0, tmp, 0, n);	// 배열 shapes의 0번째부터 복사해서 tmp에 0부터 n까지 붙여넣어라
		shapes = tmp;
	}

	public static void main(String[] args) {
		ShapeApplication app = new ShapeApplication();
		app.processCommand();
	}

}
