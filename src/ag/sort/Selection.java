package ag.sort;

import java.util.concurrent.Callable;

/**
 * Created by Abner on 4/5/2017.
 */
public class Selection {

    public static void sort(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i;j < a.length; j++){
                if(less(a[j], a[min])){
                    min = j;
                }
            }
            exch(a, i ,min);
        }
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //check算法正确性
    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        String[] test = "A E F A a G H a s b m k i t G d S ".split(" ");
        System.out.println("Before Sorted:" + isSorted(test));
        show(test);
        sort(test);
        System.out.println("\nAfter Sorted:" + isSorted(test));
        show(test);
    }
}
