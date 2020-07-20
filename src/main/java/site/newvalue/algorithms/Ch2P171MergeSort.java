package site.newvalue.algorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;

public class Ch2P171MergeSort {
    private static Comparable[] aux;
    public static void sort(Comparable[] a){
        aux=new Comparable[a.length];
        sort(a,0,a.length-1);
    }
    public static void sortBU(Comparable[] a){
        aux=new Comparable[a.length];
        int N=a.length;
        for(int sz=1;sz<=N;sz=sz+sz){
            for(int l=0;l<N-sz;l+=sz+sz){
                merge(a,l,l+sz-1,Math.min(l+2*sz-1,N-1));
            }
        }
    }
    private static void sort(Comparable[] a, int l, int r) {
        if (r <= l) {
            return;
        }
        int mid=l+(r-l)/2;
        sort(a,l,mid);
        sort(a,mid+1,r);
        merge(a,l,mid,r);
    }

    private static void merge(Comparable[] a, int l, int mid, int r) {
        int i=l,j=mid+1;
        for(int k=l;k<=r;k++){
            aux[k]=a[k];//将要归并的复制进数组
        }
        for(int k=l;k<=r;k++){
            if(i>mid){
                a[k]=aux[j];
                j++;
            }
            else if(j>r){
                a[k]=aux[i];
                i++;
            }
            else if(less(aux[i],aux[j])){
                a[k]=aux[i];
                i++;
            }
            else {
                a[k]=aux[j];
                j++;
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
        String file = Ch1P145WeightedQuickUnionFind.class.getClassLoader().getResource("data/words3.txt").getPath();
        System.setIn(new FileInputStream(file));
        String[] a= In.readStrings();
        show(a);
        Stopwatch timer=new Stopwatch();
        sortBU(a);
//        sort(a);

        System.out.println(timer.elapsedTime());
        assert isSorted(a);
        show(a);
    }
}
