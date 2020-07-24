package site.newvalue.algorithms;


import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Transaction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//对顶为最大元素，子节点比父节点小
public class Ch2P202MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;//存数据
    public void getpq(){
        for (int i=0;i<pq.length;i++){
            System.out.print(pq[i]);
        }
        System.out.println();
    }

    private int N=0;//堆大小
    public Ch2P202MaxPQ(int MaxN){
        pq=(Key[]) new Comparable[MaxN+1];
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public void insert(Key key){
        pq[++N]=key;
        swim(N);//将新加入节点上浮
    }
    public Key delMax(){
        Key key=pq[1];
        exch(1,N);//交换堆头与末尾
        N--;
        pq[N+1]=null;
        sink(1);//将堆头下沉到合适位置
        return key;
    }
    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }

    private void sink(int k) {
        while (2*k<N){
            int j=2*k;
            //找子节点中大的
            if(j<N&&less(j,j+1)){
                j++;
            }
            if(!less(k,j)){
                break;
            }
            exch(k,j);
            k=j;
        }
    }

    private void exch(int i, int j) {
        Key temp=pq[i];
        pq[i]=pq[j];
        pq[j]=temp;
    }

    private void swim(int k) {
        while (k>1&&less(k/2,k)){
            exch(k,k/2);
            k=k/2;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc =new Scanner(System.in);
        int M =sc.nextInt();
        Ch2P202MaxPQ<Transaction> pq =new Ch2P202MaxPQ<>(M+1);
        String file = Ch1P145WeightedQuickUnionFind.class.getClassLoader().getResource("data/tinyBatch.txt").getPath();
        System.setIn(new FileInputStream(file));
        while (StdIn.hasNextLine()){
            pq.insert(new Transaction(StdIn.readLine()));
            if(pq.size()>M){
                pq.delMax();
            }
        }
        for(int i=0;i<M;i++){
            System.out.println(pq.delMax());
//            pq.getpq();
        }
    }

}
