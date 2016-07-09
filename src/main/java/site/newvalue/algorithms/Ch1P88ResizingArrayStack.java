package site.newvalue.algorithms;

import java.util.Iterator;

public class Ch1P88ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a=(Item [])new Object[3];
    private int N=0;//当前长度
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }

    public void resize(int max){
        Item[] temp=(Item[])new Object[max];
        for(int i=0;i<a.length;i++){
            temp[i]=a[i];
        }
        a=temp;
    }

    public void push(Item item){
        if(N==a.length){
            resize(a.length*2);
        }
        a[N]=item;
        N++;
    }

    public Item pop(){
        Item item=a[N-1];
        a[N]=null;
        N--;
        if(N>0&&N<a.length/4){
            resize(a.length/2);
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int i=N;
            @Override
            public boolean hasNext() {
                return i>0;
            }

            @Override
            public Item next() {
                return a[--i];
            }
        };
    }

    public static void main(String[] args) {
        Ch1P88ResizingArrayStack s=new Ch1P88ResizingArrayStack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.size());
        System.out.println(s.pop());
        for (Object i :s) {
            System.out.println(i);
        }
    }

}
