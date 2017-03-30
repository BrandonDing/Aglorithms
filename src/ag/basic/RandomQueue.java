package ag.basic;

import ag.basic.Card;
/**
 * Created by Abner on 3/30/2017.
 */
public class RandomQueue<T> {

    private T[] a;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public RandomQueue(int cap) {
        a = (T[]) new Object[cap];
        head = 0;
        tail = 0;
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

    //随机出列
    public T dequeue() {
        if ((tail - head) < a.length / 4) {
            resize(a.length / 2);
        }
        if (tail > head) {
            int randNum = (int)(Math.random() * (tail - head)) + head;
            T temp = a[randNum];
            a[randNum] = a[head++];
            return temp;
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

    public static void main(String[] args) {
        String[] colors = new String[]{"heart", "spade", "diamond", "club"};
        RandomQueue<Card> rqs = new RandomQueue<>(100);
        for (int num = 1; num < 14; num++) {
            for(String color : colors){
                rqs.enqueue(new Card(color, num));
            }
        }
        rqs.enqueue(new Card("king", 0));
        rqs.enqueue(new Card("joker", 0));

        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                System.out.println("Player:" + i + "  get card:" + rqs.dequeue().toString());
            }
        }
    }
}
