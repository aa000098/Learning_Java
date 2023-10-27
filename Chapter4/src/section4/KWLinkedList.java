package section4;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class KWLinkedList <E> {
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	private static class Node<T> {
		public T data;
		public Node<T> next;
		public Node<T> previous;
		
		public Node(T item) {
			data = item;
			next = null;
		}
	}
	
	public Iterator<E> iterator(){
		return new KWListIterator(0);
	}
	
	public ListIterator<E> listiterator() {
		return new KWListIterator(0);
	}
	
	public ListIterator<E> listiterator(int index) {
		return new KWListIterator(index);
	}
	
	private class KWListIterator implements ListIterator<E> {

		// data member and constructor
		private Node<E> nextItem;	// 자신의 next node를 참조
		private Node<E> lastItemReturned; // remove와 set을 위해 구현, history dependancy 구현
		private int index;	// nextItem의 index
		
		public KWListIterator(int i) {
			if (i < 0 || i > size) {
				throw new IndexOutOfBoundsException("Invalid index " + i);
			}
			lastItemReturned = null;
			if (i == size) {
				index = size;
				nextItem = null;
			}
			else {
				nextItem = head;
				for (index = 0; index < i; index++) {
					nextItem = nextItem.next;
				}
			}
		}
		
		@Override
		public boolean hasNext() {
			return nextItem != null;
		}

		@Override
		public E next() {
			 if (!hasNext())
				 throw new NoSuchElementException();
			 lastItemReturned = nextItem;
			 nextItem = nextItem.next;
			 index++;
			return lastItemReturned.data;
		}

		@Override
		public boolean hasPrevious() {
			return (nextItem == null && size != 0) || nextItem.previous != null;
		}

		@Override
		public E previous() {
			if (!hasPrevious())
				 throw new NoSuchElementException();
			if (nextItem == null)
				nextItem = tail;
			else 
				nextItem = nextItem.previous;
			lastItemReturned = nextItem;
			index--;
			return lastItemReturned.data;
		}

		@Override
		public int nextIndex() {
			return index;
		}

		@Override
		public int previousIndex() {
			return index - 1;
		}

		@Override
		public void remove() {
		
			
		}

		@Override
		public void set(E e) {
		
			
		}

		@Override
		public void add(E e) {
			if (head == null) {
				head = new Node<E>(e);
				tail = head;
			}
			else if (nextItem == head) {
				Node<E> newNode = new Node<E>(e);
				newNode.next = nextItem;
				nextItem.previous = newNode;
				head = newNode;
			}
			else if (nextItem == null) {
				Node<E> newNode = new Node<E>(e);
				tail.next = newNode;
				newNode.previous = tail;
				tail = newNode;
			}
			else {
				Node<E> newNode = new Node<E>(e);
				newNode.previous = nextItem.previous;
				nextItem.previous.next = newNode;
				newNode.previous = nextItem;
				nextItem.previous = newNode;
			}
			index++;
			size++;
		}
	}
	
	public int indexOf(E item) {
		int index = 0;
		ListIterator<E> iter = listiterator();
 		while (iter.hasNext()) {
			if (iter.next().equals(item))
				return index;
			index++;
		}
		return -1;
	}
	
	public void add (int index, E item) {
		listiterator(index).add(item);
	}
	
	public E get(int index) {
		return listiterator(index).next();
	}
	
	public E remove (int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		ListIterator<E> iter = listiterator(index);
		E result = iter.next();
		iter.remove();
		return result;
	}
	
	public void remove(E obj) {
		
		int i = indexOf(obj);
	}
	
	public int size() {
		return size;
	}
}
