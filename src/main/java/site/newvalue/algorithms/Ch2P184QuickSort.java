package site.newvalue.algorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ch2P184QuickSort {
    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int l, int r) {
        if(r<=l+2){
            Insertion.sort(a,l,r);
            return;
        }
        int j=partition(a,l,r);
        sort(a,l,j-1);
        sort(a,l+1,r);
    }

    private static int partition(Comparable[] a, int l, int r) {
        int i=l,j=r+1;
        Comparable v=a[l];
        while (true){
            while (less(a[++i],v)){
                if(i==r){
                    break;
                }
            }
            while (less(v,a[--j])){
                if(j==l){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            exch(a,i,j);
        }
        exch(a,l,j);
        show(a);
        return j;
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
        String file = Ch1P145WeightedQuickUnionFind.class.getClassLoader().getResource("data/tiny.txt").getPath();
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
