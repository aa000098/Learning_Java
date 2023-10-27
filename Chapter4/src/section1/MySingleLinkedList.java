package section1;

public class MySingleLinkedList<T> {
	// 첫 번째 노드의 주소를 멤버로 가지고 있어야 함
	public Node<T> head;
	public int size = 0;
	
	public MySingleLinkedList() {
		head = null;
		size = 0;
	}
	
	public void addFirst(T item) {	// insert
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
	
	public void addAfter(Node<T> before, T item) {
		Node<T> temp = new Node<T> (item);
		temp.next = before.next;
		before.next = temp;
		size++;
	}
	
	public T removeFirst() {		// delete
		if (head == null) return null;
		T temp = head.data; 
		head = head.next;
		size--;
		return temp;
	}
	
	public T removeAfter(Node<T> before) {
		if (before.next == null) return null;
		T temp = before.data;
		before.next = before.next.next;
		size--;
		return temp;
	}
	
	public Node<T> getNode(int index) {
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
			return null;
//		Node<T> p = head;
//		for (int i=0; i<index; i++)
//			p = p.next;
//		return p.data;
		return getNode(index).data;
	}
	
	public void add(int index, T item) {
		if (index < 0 || index > size)		// 새로 추가하면 size까지 가능함
			return;
		if (index == 0) 
			addFirst(item);
		else
			addAfter(getNode(index-1), item);
	}
	
	public T remove (int index) {
		if (index < 0 || index >= size)
			return null;
		if (index == 0)
			return removeFirst();
		else
			return removeAfter(getNode(index-1));
	}
	
	public T remove (T item) {
		Node <T> p = head;
//		int index = 0;
		Node<T> q = null;
		while (p.next == null && !p.data.equals(item)) {
			q = p;
			p = p.next;
//			index++;
		}
		if (p==null)
			return null;
//		return remove(index);
		if (q==null)
			return removeFirst();
		else
			return removeAfter(q);
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
