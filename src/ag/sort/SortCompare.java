package ag.sort;

import ag.utils.StdRandom;
import ag.utils.StopWatch;

import java.util.Scanner;

/**
 * Created by Abner on 4/5/2017.
 */
public class SortCompare {

    private static double runTime(String alg, Double[] a){
        StopWatch sw = new StopWatch();
        if(alg.equals("Insertion")) Insertion.sort(a);
        if(alg.equals("Selection")) Selection.sort(a);
        if(alg.equals("Shell")) Shell.sort(a);
//        if(alg.equals("Merge")) Merge.sort(a);
//        if(alg.equals("Quick")) Quick.sort(a);
//        if(alg.equals("Heap")) Heap.sort(a);
        return sw.elapsedTime();
    }

    public static double timeRandomInput(String alg, int arraySize, int testTimes){
        double total = 0;
        Double[] a = new Double[arraySize];
        for(int t = 0; t < testTimes; t++){
            for(int i = 0; i < arraySize; i ++){
                a[i] = StdRandom.uniform();
            }
            total = total + runTime(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.println("请输入算法1 算法2 测试长度 测试次数：");
            String lin = s.nextLine();
            if(lin.equals("exit")) break;
            String[] cmds = lin.split(" ");
            String alg1 = cmds[0];
            String alg2 = cmds[1];
            int arraySize = Integer.parseInt(cmds[2]);
            int testTimes = Integer.parseInt(cmds[3]);
            double t1 = timeRandomInput(alg1, arraySize, testTimes);
            double t2 = timeRandomInput(alg2, arraySize, testTimes);
            System.out.println("For " + arraySize + " random doubles: " + alg1 + " is " + t2/t1 + " times faster than " + alg2 + ".");
        }
    }

}
