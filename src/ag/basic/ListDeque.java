package ag.basic;

public class ListDeque<T> {

	private Node<T> head;
	private Node<T> tail;
	private int n;

	public ListDeque() {
		n = 0;
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public T popLeft() {
		if (n == 0) {
			return null;
		}
		Node<T> temp = head;
		head = head.next;
		n--;
		return temp.t;
	}

	public T popRight() {
		if (n == 0) {
			return null;
		}
		Node<T> temp = tail;
		tail = tail.previous;
		n--;
		return temp.t;
	}

	public void pushLeft(T t) {
		Node<T> newNode = new Node<T>();
		newNode.t = t;
		if (n == 0) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
		}
		n++;
	}

	public void pushRight(T t) {
		Node<T> newNode = new Node<T>();
		newNode.t = t;
		if (n == 0) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		}
		n++;
	}

	@SuppressWarnings("hiding")
	private class Node<T> {
		private T t;
		private Node<T> next;
		private Node<T> previous;
	}

	public static void main(String[] args) {
		ListDeque<String> fs = new ListDeque<String>();
		String expression = "to .be or not .to be - that is - > - a .question - - > - > - - > - > .to .be or not to be - - ";
		for (String e : expression.split(" ")) {
			if (e.equals("-")) {
				System.out.println("\t\tPoping Right:" + fs.popLeft());
				System.out.println(fs.size());
			} else if (e.equals(">")) {
				System.out.println("\t\tPoping Left:" + fs.popRight());
				System.out.println(fs.size());
			} else if (e.startsWith(".")) {
				fs.pushLeft(e.substring(1, e.length()));
				System.out.println("Pushing Left:" + e.substring(1, e.length()));
				System.out.println(fs.size());
			} else {
				fs.pushRight(e);
				System.out.println("Pushing Right:" + e);
				System.out.println(fs.size());
			}
		}
	}
}
