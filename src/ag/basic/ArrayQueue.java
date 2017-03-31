package ag.basic;

import java.util.Iterator;

public class ArrayQueue<T> implements Iterable<T> {

	private T[] a;
	private int head;
	private int tail;

	@SuppressWarnings("unchecked")
	public ArrayQueue(int cap) {
		this.a = (T[]) new Object[cap];
		this.head = 0;
		this.tail = 0;
	}

	public ArrayQueue(ArrayQueue<T> aq) {
		this.a = (T[]) new Object[aq.length()];
		this.head = aq.head;
		this.tail = aq.tail;
		for (int i = 0; i < tail - head; i++) {
			a[head + i] = aq.a[head + i];
		}
	}

	public int size() {
		return tail - head;
	}

	public int length() {
		return a.length;
	}

	public boolean isEmpty() {
		return tail == head;
	}

	public T dequeue() {
		if ((tail - head) < a.length / 4) {
			resize(a.length / 2);
		}
		if (tail > head) {
			return a[head++];
		} else {
			System.out.println("Empty Queue.");
			return null;
		}
	}

	public void enqueue(T t) {
		if (tail == a.length) {
			if (head == 0) {
				resize(a.length * 2);
			} else {
				reshape();
			}
		}
		a[tail++] = t;
	}

	@SuppressWarnings("unchecked")
	private void resize(int max) {
		T[] temp = (T[]) new Object[max];
		for (int i = 0; i < tail - head; i++) {
			temp[i] = a[i + head];
		}
		a = temp;
		tail = tail - head;
		head = 0;
	}

	@SuppressWarnings("unchecked")
	private void reshape() {
		T[] temp = (T[]) new Object[a.length];
		for (int i = 0; i < tail - head; i++) {
			temp[i] = a[head + i];
		}
		a = temp;
		tail = tail - head;
		head = 0;
	}

	//迭代器逻辑待更新
	private class QueueIterator implements Iterator<T> {
		private int i = tail - head;

		public boolean hasNext() {
			return i > 0;
		}

		public T next() {
			return a[head + 1];
		}

		public void remove() {
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new QueueIterator();
	}

	@Override
	public String toString(){
		String elements = "Size:" + size() + ";Elements:[" ;
		for (int i = 0; i < tail -head; i++) {
			elements = elements + a[head + i].toString() + ",";
		}
		if(tail -head > 0){
			elements = elements.substring(0, elements.length() - 1);
		}
		elements = elements + "]";
		return elements;
	}

	public static void main(String[] args) {
		ArrayQueue<String> fs = new ArrayQueue<String>(100);
		String expression = "to be or not to be - that is - - - a question - - - - - - - - - - to be or not to be - - ";
		for (String e : expression.split(" ")) {
			if (e.equals("-")) {
				System.out.println("\t\tPoping:" + fs.dequeue());
				System.out.println(fs.length());
			} else {
				fs.enqueue(e);
				System.out.println("Pushing:" + e);
				System.out.println(fs.length());
			}
		}

		ArrayQueue<String> copy = new ArrayQueue<String>(fs);
		System.out.println(copy.toString());

	}

}
