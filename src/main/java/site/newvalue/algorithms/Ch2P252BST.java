package site.newvalue.algorithms;

import sun.reflect.generics.tree.Tree;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Ch2P252BST<Key extends Comparable<Key>,Value> {
    private Node root;
    private class Node{
        private Key key;
        private Value value;
        private Node left,right;
        private int N;
        public Node(){}
        public Node(Key key,Value value,int N){
            this.key=key;
            this.value=value;
            this.N=N;
        }
    }
    public int size(){
        return size(root);
    }
    private int size(Node x){
        if(x==null){
            return 0;
        }
        return x.N;
    }
    //查找
    public Value get(Key key){
        return get(root,key);
    }

    private Value get(Node root, Key key) {
        if(root==null){
            return null;
        }
        if(key.compareTo(root.key)>0){
            return get(root.right,key);
        }
        else if(key.compareTo(root.key)<0){
            return get(root.left,key);
        }
        else {
            return root.value;
        }
    }
    //插入
    public void put(Key key,Value value){
        root=put(root,key,value);
    }

    private Node put(Node root, Key key, Value value) {
        if(root==null){
            return new Node(key,value,1);
        }
        if(key.compareTo(root.key)>0){
            root.right=put(root.right,key,value);
        }
        else if(key.compareTo(root.key)<0){
            root.left=put(root.left,key,value);
        }
        else{
            root.value=value;
        }
        root.N=size(root.left)+size(root.right)+1;
        return root;
    }

    public Key min(){
        return min(root).key;
    }

    private Node min(Node n) {
        if(n.left==null){
            return n;
        }
        return min(n.left);
    }

    public Key max(){
        return max(root).key;
    }

    private Node max(Node n) {
        if(n.right==null){
            return n;
        }
        return max(n.right);
    }

    //找到键为key的排序
    public int rank(Key key){
        return rank(key,root);
    }

    private int rank(Key key, Node x) {
        if(x==null){
            return 0;
        }
        int cmp=key.compareTo(x.key);
        if(cmp>0){
            return size(x.left)+1+rank(key,x.right);
        }
        else if(cmp<0){
            return rank(key,x.left);
        }
        else {
            return size(x.left);
        }
    }

    //删除最小的节点
    public void deleteMin(){
        root=deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if(x.left==null){
            return x.right;
        }
        x.left=deleteMin(x.left);
        x.N=size(x.left)+1+size(x.right);
        return x;
    }

    //中序打印
    public void print(){
        print(root);
    }
    private void print(Node x){
        if(x==null){
            return;
        }
        print(x.left);
        System.out.println(x.key+":"+x.value);
        print(x.right);
    }


    public static void main(String[] args) {
        Ch2P252BST<String,Integer> bst=new Ch2P252BST<>();
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.next();
            Integer b=sc.nextInt();
            bst.put(s,b);
        }
        bst.print();
        System.out.println(bst.get("J"));
        System.out.println(bst.min());
        System.out.println(bst.max());
        System.out.println(bst.rank("W"));
    }

}
