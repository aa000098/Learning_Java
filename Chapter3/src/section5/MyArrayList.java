package section5;

import java.util.Arrays;

public class MyArrayList<E> {
	private static final int INIT_CAPACITY = 10;
	private E[] theData;
	private int size;
	private int capacity = INIT_CAPACITY;
	
	public MyArrayList() {
		theData = (E [])new Object [INIT_CAPACITY];	
		// theData = new T [capacity]; 
		// 이렇게 new 명령어 다음 실제로 존재하지 않는 타입이 들어와서는 안됨
		size = 0;
	}
	
	public void add(int index, E anEntry) {
		if (index < 0 || index > size)		// error or exception 
			throw new ArrayIndexOutOfBoundsException(index);		
		// boolean 타입으로 함수를 만들고 return false;를 하는 것도 전형적

		if (size >= capacity)
			reallocate();
		for (int i=size-1; i>=index; i--)
			theData[i+1] = theData[i];
		theData[index] = anEntry;
		size++;
	}

	public void add(E enEntry) {	// 맨 뒤에 삽입하는 것
		add (size, enEntry);
	}
	
	private void reallocate() {
		capacity *= 2;
		theData = Arrays.copyOf(theData, capacity);
	}
	
	public int size() {
		return size;
	}
	
	public int indexOf(E anEntry) {		// 데이터가 리스트에 있는지 없는지
		for (int i=0; i<size; i++) {
			if ( theData[i].equals(anEntry) )	// E 타입은 theData[i] == anEntry 이 연산 수행 불가
				return i;					// equals 메서드는 Object 의 4가지 메서드중 하나이기 때문에 사용 가능하다
		}								// 다만 오버라이딩을 통해 의도한 내용을 지정해줘야 함
		return -1;
	}
	
	public E get (int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return theData[index];
	}
	
	public E set (int index, E newValue) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E oldValue = theData[index];
		theData[index] = newValue;
		return oldValue;
	}
	
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E returnValue = theData[index];
		for (int i=index + 1; i<size; i++) {
			theData[i-1] = theData[i];
		}
		size--;
		return returnValue;
	}
	/*
	public static void main (String [] args) {
		MyArrayList<String> test = new MyArrayList();
		
		try {
			test.add(1, "Hello");
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Error");
		}
		System.out.println("*****");
	}
	*/
}
