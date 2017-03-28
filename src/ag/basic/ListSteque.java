package ag.basic;

public class ListSteque<T> {

	private Node<T> head;
	private Node<T> tail;
	private int n;

	public ListSteque() {
		n = 0;
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public T pop() {
		if (n == 0) {
			return null;
		}
		Node<T> temp = head;
		head = head.next;
		n--;
		return temp.t;
	}

	public void push(T t) {
		Node<T> newNode = new Node<T>();
		newNode.t = t;
		if (n == 0) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		n++;
	}

	public void enqueue(T t) {
		Node<T> newNode = new Node<T>();
		newNode.t = t;
		if (n == 0) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		n++;
	}

	@SuppressWarnings("hiding")
	private class Node<T> {
		private T t;
		private Node<T> next;
	}
	
	public static void main(String[] args) {
		ListSteque<String> fs = new ListSteque<String>();
		String expression = "to .be or not .to be - that is - - - a .question - - - - - - - - - - .to .be or not to be - - ";
		for (String e : expression.split(" ")) {
			if (e.equals("-")) {
				System.out.println("\t\tPoping:" + fs.pop());
				System.out.println(fs.size());
			} else if(e.startsWith(".")){
				fs.push(e.substring(1, e.length()));
				System.out.println("Pushing:" + e.substring(1, e.length()));
				System.out.println(fs.size());
			} else {
				fs.enqueue(e);
				System.out.println("Enqueue:" + e);
				System.out.println(fs.size());
			}
		}
	}
}
