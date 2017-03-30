package ag.basic;

/**
 * Created by Abner on 3/30/2017.
 */
public class BufferCircle<T> {

    //环形缓冲区
    private LoopQueue<T> loop;

    //消息队列区
    private ArrayQueue<T> queue;


    @SuppressWarnings("unchecked")
    public BufferCircle(int cap) {
        this.loop = new LoopQueue<T>(cap);
        this.queue = new ArrayQueue<T>(100);
    }

    public T dequeue() {
        T temp = loop.dequeue();
        loop.enqueue(queue.dequeue());
        return temp;
    }

    public void enqueue(T t) {
        if(! loop.enqueue(t)){
            queue.enqueue(t);
        }
    }

    public static void main(String[] args) {
        BufferCircle<String> bc = new BufferCircle<String>(3);
        String expression = "to be or not to be - that is - - - a question - - - - - - - - - - to be or not to be - - ";
        for (String e : expression.split(" ")) {
            if (e.equals("-")) {
                System.out.println("\t\tDequeue:" + bc.dequeue());
            } else {
                bc.enqueue(e);
                System.out.println("Enqueue:" + e);
            }
        }
    }

}
