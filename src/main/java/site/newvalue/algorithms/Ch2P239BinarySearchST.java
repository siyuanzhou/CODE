package site.newvalue.algorithms;


import edu.princeton.cs.algs4.StdIn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Ch2P239BinarySearchST<Key extends Comparable<Key>,Value> {
    private Key[] keys;
    private Value[] values;
    private int N;//数目
    public Ch2P239BinarySearchST(int capacity){
        keys=(Key[])new Comparable[capacity];
        values=(Value[]) new Object[capacity];
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    //不大于key的最大位置
    public int rank(Key key){
        int l=0,r=N-1;
        while (l<=r){
            int mid=(r-l)/2+l;
            if(key.compareTo(keys[mid])>0){
                l=mid+1;
            }
            else if(key.compareTo(keys[mid])<0){
                r=mid-1;
            }
            else {
                return mid;
            }
        }
        return l;
    }
    public boolean contains(Key key){
        return get(key)!=null;
    }
    public Iterable<Key> keys(){
        LinkedList<Key> q=new LinkedList<>();
        for(int i=0;i<N;i++){
            q.add(keys[i]);
        }
        return q;
    }
    public Value get(Key key){
        if(isEmpty()){
            return null;
        }
        int j=rank(key);
        if(j<N&&key.compareTo(keys[j])==0){
            return values[j];
        }
        else {
            return null;
        }
    }
    public void put(Key key,Value value){
        int i=rank(key);
        if(i<N&&key.compareTo(keys[i])==0){
            values[i]=value;
            return;
        }else {
            for(int j=N;j>i;j--){
                keys[j]=keys[j-1];
                values[j]=values[j-1];
            }
            keys[i]=key;
            values[i]=value;
            N++;
        }
    }
    private static String getType(Object a) {
        return a.getClass().toString();
    }
    public static void main(String[] args) throws FileNotFoundException {
        int minlen=Integer.parseInt(new Scanner(System.in).next());
        String file = Ch1P145WeightedQuickUnionFind.class.getClassLoader().getResource("data/tinyTale.txt").getPath();
        System.setIn(new FileInputStream(file));
        Ch2P239BinarySearchST<String,Integer> st=new Ch2P239BinarySearchST<String,Integer>(50000);
        while (!StdIn.isEmpty()){
            String word=StdIn.readString();
            if(word.length()<minlen){
                continue;
            }
            if(!st.contains(word)){
                st.put(word,1);
            }
            else {
                st.put(word,st.get(word)+1);
            }
        }
        String max=st.keys().iterator().next();
        System.out.println(max);
        for(String word: st.keys()){
            System.out.println(word+" "+st.get(word));
            if(st.get(word)>st.get(max)){
                max=word;
            }
        }
        System.out.println(max+" "+st.get(max));
    }

}
