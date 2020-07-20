package site.newvalue.algorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ch2P157InsertionSort {
    public static void sort(Comparable[] a){
        int N=a.length;
        for(int i=1;i<N;i++){
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
    }
    private static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }
    private static void exch(Comparable[]a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    public static void show(Comparable[]a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String file = Ch1P145WeightedQuickUnionFind.class.getClassLoader().getResource("data/32Kints.txt").getPath();
        System.setIn(new FileInputStream(file));
        String[] a= In.readStrings();
        show(a);
        Stopwatch timer=new Stopwatch();
        sort(a);
        System.out.println(timer.elapsedTime());
        assert isSorted(a);
        show(a);
    }
}
