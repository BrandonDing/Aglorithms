package ag.basic;

/**
 * Created by Abner on 3/30/2017.
 */
public class LoopQueue<T> {

    private T[] a;
    private int head;
    private int tail;
    private int size;

    @SuppressWarnings("unchecked")
    public LoopQueue(int cap) {
        this.a = (T[]) new Object[cap];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull(){return size == a.length;}

    public T dequeue() {
        if (!isEmpty()) {
            T temp = a[head ++];
            size --;
            if(head > a.length - 1){
                head = 0;
            }
            return temp;
        }

        System.out.println("Empty Queue.");
        return null;
    }

    public boolean enqueue(T t) {
        if(!isFull() && t != null){
            a[tail++] = t;
            if(tail > a.length - 1){
                tail = 0;
            }
            size ++;
            return true;
        }
        return false;
    }

}
