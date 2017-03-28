package ag.basic;

import java.util.Iterator;

public class ListBag<T> implements Iterable<T> {

	private Node<T> first;

	public ListBag() {

	}

	private void add(T t) {
		Node<T> newNode = new Node<T>();
		newNode.t = t;
		first.next = newNode;
		first = newNode;
	}

	@SuppressWarnings("hiding")
	private class Node<T> {
		private T t;
		private Node<T> next;
	}

	//迭代器逻辑待更新
	private class BagIterator implements Iterator<T> {

		private Node<T> node = first;

		public boolean hasNext() {
			return node != null;
		}

		public T next() {
			return node.next.t;
		}

		public void remove() {
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new BagIterator();
	}

	public static void main(String[] args) {
		ListBag<String> fs = new ListBag<String>();
		String expression = "to be or not to be - that is - - - a question - - - - - - - - - - to be or not to be - - ";
		for (String e : expression.split(" ")) {
			if (!e.equals("-")) {
				fs.add(e);
				System.out.println("Adding:" + e);
			}
		}
	}
}
