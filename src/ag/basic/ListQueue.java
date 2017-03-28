package ag.basic;

import java.util.Iterator;

public class ListQueue<T> implements Iterable<T> {

	private Node<T> head;
	private Node<T> tail;
	private int n;

	public ListQueue() {
		this.n = 0;
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public T dequeue() {
		if (n == 0) {
			return null;
		}
		Node<T> temp = head;
		head = head.next;
		n--;
		return temp.t;
	}

	public void enqueue(T t) {
		Node<T> newNode = new Node<T>();
		newNode.t = t;
		if (n == 0) {
			head = tail = newNode;
			n++;
			return;
		}
		tail.next = newNode;
		tail = newNode;
		n++;
	}

	@SuppressWarnings("hiding")
	private class Node<T> {
		private T t;
		private Node<T> next;
	}

	//迭代器逻辑待更新
	private class QueueIterator implements Iterator<T> {
		private int i = n;

		public boolean hasNext() {
			return i > 0;
		}

		public T next() {
			return head.next.t;
		}

		public void remove() {
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new QueueIterator();
	}

	public static void main(String[] args) {
		ListQueue<String> fs = new ListQueue<String>();
		String expression = "to be or not to be - that is - - - a question - - - - - - - - - - to be or not to be - - ";
		for (String e : expression.split(" ")) {
			if (e.equals("-")) {
				System.out.println("\t\tPoping:" + fs.dequeue());
				System.out.println(fs.size());
			} else {
				fs.enqueue(e);
				System.out.println("Pushing:" + e);
				System.out.println(fs.size());
			}
		}
	}
}
