package site.newvalue.algorithms;

import edu.princeton.cs.algs4.In;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ch2P156SelectionSort {
    public static void sort(Comparable[] a){
        int N=a.length;
        for(int i=0;i<N;i++){
            int min=i;
            for(int j=i;j<N;j++){
                if(less(a[j],a[min])){
                    min=j;
                }
            }
            exch(a,i,min);
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
        String file = Ch1P145WeightedQuickUnionFind.class.getClassLoader().getResource("data/words3.txt").getPath();
        System.setIn(new FileInputStream(file));
        String[] a= In.readStrings();
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
