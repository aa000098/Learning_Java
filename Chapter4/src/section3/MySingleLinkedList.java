package section3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySingleLinkedList<T> {
	// 첫 번째 노드의 주소를 멤버로 가지고 있어야 함
	private Node<T> head;
	public int size = 0;
	
	public MySingleLinkedList() {
		head = null;
		size = 0;
	}
	
	// inner class : 클래스 Node를 외부에서는 알 수 없게 됨 
	// 인터페이스와 구현의 분리
	private static class Node<T> {
		public T data;
		public Node<T> next;
		
		public Node(T item) {
			data = item;
			next = null;
		}
	}
	
	public Iterator<T> iterator() {
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<T> {
		private Node<T> nextNode;
		
		public MyIterator() {
			nextNode = head;
		}
		public boolean hasNext() {
			return nextNode != null;
		}
		public T next() {
			if (nextNode == null)
				throw new NoSuchElementException();
			T val = nextNode.data;
			nextNode = nextNode.next;
			return val;
		}
		public void remove() {	
			// 현재 가리키고 있는 Node는 n이라고 하면, 
			// remove는 n-1번 Node의 주소를 알아야 하기 때문에 조금 복잡함.
			
		}
 	}
	
	private void addFirst(T item) {	// insert
		Node<T> newNode = new Node<T>(item);	// T : type parameter
		// T t = new T();   -> 가상 클래스 타입의 객체를 만드는 것은 불가능함
		// T[] array = new T [100]   -> 가상 클래스 타입 배열도 불가능
		// T 타입 클래스 객체를 만드는 것은 가능함, 그런데 T 타입 클래스 배열은 안됨
		newNode.next = head;
		head = newNode;
		size++;
	}	// 연결리스트에서 가장 주의할 점은 일반적인 경우만이 아니라 
	// 특수하고 극단적 경우에도 작동하는지 확인해야 함, 노드가 아무것도 없어도 잘 작동함
	
	// 연결 리스트는 하나의 리스트를 표현하는 클래스이므로 리스트에서 많이 하게 되는 일들을 데이터 멤버로 명시
	
	private void addAfter(Node<T> before, T item) {
		Node<T> temp = new Node<T> (item);
		temp.next = before.next;
		before.next = temp;
		size++;
	}
	
	private T removeFirst() {		// delete
		if (head == null) return null;
		T temp = head.data; 
		head = head.next;
		size--;
		return temp;
	}
	
	private T removeAfter(Node<T> before) {
		if (before.next == null) return null;
		T temp = before.data;
		before.next = before.next.next;
		size--;
		return temp;
	}
	
	private Node<T> getNode(int index) {
		if (index < 0 || index >= size)
			return null;
		Node<T> p = head;
		for (int i=0; i<index; i++)
			p = p.next;
		return p;
	}
	
	public int indexOf(T item) {		// search
		Node<T> p = head;
		int index = 0;
		while (p != null) {
			if (p.data.equals(item))
				return index;
			p = p.next;	// p를 다음 노드로 이동
			index++;
		}
		return -1;
	}
	
	public T get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
//		Node<T> p = head;
//		for (int i=0; i<index; i++)
//			p = p.next;
//		return p.data;
		return getNode(index).data;
	}
	
	public void add(int index, T item) {
		if (index < 0 || index > size)		// 새로 추가하면 size까지 가능함
			throw new IndexOutOfBoundsException();
		if (index == 0) 
			addFirst(item);
		else
			addAfter(getNode(index-1), item);
	}
	
	public boolean remove (int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		if (index == 0) {
			T tmp = removeFirst();
			return tmp != null;
		}
		else {
			T tmp = removeAfter(getNode(index-1));
			return tmp != null;
		}
	}
	
	public boolean remove (T item) {
		Node <T> p = head;
//		int index = 0;
		Node<T> q = null;
		while (p.next == null && !p.data.equals(item)) {
			q = p;
			p = p.next;
//			index++;
		}
		if (p == null)
			return false;
//		return remove(index);
//		if (q==null) 
//			return removeFirst();
//		else
//			return removeAfter(q);
		if (q == null) {
			T tmp = removeFirst();
			return tmp != null;
		}
		else {
			T tmp = removeAfter(q);
			return tmp != null;
		}
	}
	
	public static void main(String[] args) {
		MySingleLinkedList<String> list = new MySingleLinkedList<>();
		list.add(0, "Saturday");	// S
		list.add(1, "Friday");		// S -> F
		list.add(0, "Monday");		// M -> S -> F
		list.add(2, "Tuesday");		// M -> S > T -> F
	
		String str = list.get(2);	// str = "Tuesday"
		list.remove(2);				// M, S, F
		int pos = list.indexOf("Friday");	// pos = 2
		for (int i=0; i<list.size; i++) 
			System.out.println(list.get(i));
	}
}
