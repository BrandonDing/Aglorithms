package ag.basic;

import java.util.Iterator;

public class ListStack<T> implements Iterable<T> {

	private Node<T> first;
	private int n;

	public ListStack() {
		this.n = 0;
	}

	public ListStack(T t) {
		this.n = 1;
		this.first = new Node<T>(t);
	}

	public ListStack(ListStack<T> ls) {
		if(ls.first == null){
			this.n = 0;
			this.first = null;
		}else{
			this.n = ls.size();
			this.first = new Node<T>(ls.first.t, null);
			Node<T> from = ls.first;
			Node<T> to = this.first;
			while(from.next != null){
				from = from.next;
				Node<T> temp = new Node<T>(from.t, null);
				to.next = temp;
				to = temp;
			}
		}
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(T t) {
		if (n == 0) {
			first = new Node<T>(t);
		} else {
			first = new Node<T>(t, first);
		}
		n++;
	}

	public T pop() {
		if (n == 0) {
			return null;
		}
		Node<T> out = first;
		first = first.next;
		n--;
		return out.t;
	}

	@SuppressWarnings("hiding")
	private class Node<T> {
		private T t;
		private Node<T> next;

		public Node(T t) {
			this.t = t;
			this.next = null;
		}

		public Node(T t, Node<T> n) {
			this.t = t;
			this.next = n;
		}
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
			return first.next.t;
		}

		public void remove() {
		}
	}

	public static void main(String[] args) {
		ListStack<String> ls = new ListStack<String>();

		ListStack<String> copy1 = new ListStack<String>(ls);
		System.out.println("end");

		String expression = "to be or not to be - that is - - - a question - - - - - - - to be or not to be - - - ";
		for (String e : expression.split(" ")) {
			if (e.equals("-")) {
				if (!ls.isEmpty()) {
					System.out.println(ls.pop());
					System.out.println(ls.size());
				}
			} else {
				ls.push(e);
				System.out.println(ls.size());
			}
		}

		ListStack<String> copy2 = new ListStack<String>(ls);
		System.out.println("end");
	}

}
