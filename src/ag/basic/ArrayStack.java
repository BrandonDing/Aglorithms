package ag.basic;

import java.util.Iterator;

public class ArrayStack<T> implements Iterable<T> {

	private T[] a;
	private int n;

	@SuppressWarnings("unchecked")
	public ArrayStack(int cap) {
		this.a = (T[]) new Object[cap];
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	public int length() {
		return a.length;
	}

	public void push(T s) {
		if (n == a.length) {
			resize(2 * a.length);
		}
		a[n++] = s;
	}

	public T pop() {
		T t = a[--n];
		a[n] = null;
		if (n > 0 && n <= a.length / 4) {
			resize(a.length / 2);
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	private void resize(int max) {
		T[] temp = (T[]) new Object[max];
		for (int i = 0; i < n; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	@Override
	public Iterator<T> iterator() {
		return new StackIterator();
	}

	//迭代器逻辑待更新
	private class StackIterator implements Iterator<T> {
		private int i = n;

		public boolean hasNext() {
			return i > 0;
		}

		public T next() {
			return a[i--];
		}

		public void remove() {
		}
	}

	public static void main(String[] args) {
		ArrayStack<String> fs = new ArrayStack<String>(100);
		String expression = "to be or not to be - that is - - - a question - - - - - - - to be or not to be";
		for (String e : expression.split(" ")) {
			if (e.equals("-")) {
				if (!fs.isEmpty()) {
					System.out.println(fs.pop());
					System.out.println(fs.length());
				}
			} else {
				fs.push(e);
				System.out.println(fs.length());
			}
		}
	}

}
