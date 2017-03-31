package ag.basic;

/**
 * Created by Abner on 3/31/2017.
 */
public class MoveToFront<T> {

    private Node<T> first;
    private int n;

    public MoveToFront(){
        this.n = 0;
    }

    public boolean isEmpty(){return n == 0;}

    public int size(){return n;}

    public void insert(T t){
        delete(t);
        push(t);
    }

    //删除相关元素
    private void delete(T t){
        if(n > 0 &&first.t.equals(t)){
            n --;
            first = first.next;
            return;
        }
        if(n > 1){
            Node<T> head = first;
            Node<T> tail = first.next;
            while(tail != null){
                if(tail.t.equals(t)){
                    head.next = tail.next;
                    n --;
                    return;
                }else{
                    tail = tail.next;
                    head = head.next;
                }
            }
        }
    }

    //插入元素
    private void push(T t) {
        if (n == 0) {
            first = new Node<T>(t);
        } else {
            first = new Node<T>(t, first);
        }
        n++;
    }

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
    public String toString(){
        String elements = "Size:" + size() + ";Elements:[" ;
        Node<T> temp = first;
        while (temp != null){
            elements = elements + temp.t.toString() + ",";
            temp = temp.next;
        }
        if(n > 0){
            elements = elements.substring(0, elements.length() - 1);
        }
        elements = elements + "]";
        return elements;
    }

    public static void main(String[] args) {
        MoveToFront<String> mtf = new MoveToFront<String>();
        String expression = "to be or not to to to to be - that is - - - a question - - - - - - - - - - to be or not to be - - ";
        for (String e : expression.split(" ")) {
            if (e.equals("-")) {

            } else {
                System.out.println(mtf.toString());
                mtf.insert(e);
            }
        }
    }
}
