package ag.basic;

/**
 * Created by Abner on 3/29/2017.
 */
public class ArrayDeque<T> {

    private T[] a;
    private int head;
    private int tail;

    public ArrayDeque(int cap){
        a = (T[]) new Object[cap];
        tail = head = cap / 2;
    }

    public int size(){
        return tail - head;
    }


    public boolean isEmpty(){
        return (tail - head) == 0;
    }


    public void pushRight(T t){
        if(tail == a.length){
            resize((tail - head) * 2);
        }
        a[tail ++] = t;
    }

    public void pushLeft(T t){
        if(head == 0){
            resize((tail - head) * 2);
        }
        if(isEmpty()){
            a[head] = t;
        }else{
            a[-- head] = t;
        }
    }

    public T popRight(){
        T temp = null;
        if(tail - head > 0){
            temp = a[-- tail];
            if((tail - head) < a.length/4){
                resize((tail - head) * 2);
            }
        }
        return temp;
    }

    public T popLeft(){
        T temp = null;
        if(tail - head > 0){
            temp = a[head ++];
            if((tail - head) < a.length/4){
                resize((tail - head) * 2);
            }
        }

        return temp;
    }

    public void resize(int newSize){
        T[] temp = (T[]) new Object[newSize];
        for (int i = 0; i < tail - head; i++) {
            temp[newSize/4 + i] = a[head + i];
        }
        a = temp;
        tail = newSize / 4 + tail - head;
        head = newSize / 4;
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
        ArrayDeque<String> fs = new ArrayDeque<String>(100);
        String expression = "to .be or not .to be - that is - > - a .question - - > - > - - > - > .to .be or not to be - - ";
        for (String e : expression.split(" ")) {
            if (e.equals("-")) {
                System.out.println(fs.toString());
                System.out.println("Poping Left:" + fs.popLeft());
            } else if (e.equals(">")) {
                System.out.println(fs.toString());
                System.out.println("\t\tPoping Right:" + fs.popRight());
            } else if (e.startsWith(".")) {
                System.out.println(fs.toString());
                fs.pushLeft(e.substring(1, e.length()));
                System.out.println("Pushing Left:" + e.substring(1, e.length()));
            } else {
                System.out.println(fs.toString());
                fs.pushRight(e);
                System.out.println("\t\tPushing Right:" + e);
            }
        }
    }
}
