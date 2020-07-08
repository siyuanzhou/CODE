package site.newvalue.algorithms;

import java.util.Iterator;

class Node<Item>{
    Item item;
    Node<Item> next;
}

public class Ch1P94LinkListStack <Item> implements Iterable<Item> {
    private Node<Item> first;//栈顶
    private int N;//数目
    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        return N;
    }
    public void push(Item item){
        Node<Item> node =new Node<>();
        node.item=item;
        node.next=first;
        first=node;
        N++;
    }
    public Item pop(){
        Item item = first.item;
        first=first.next;
        N--;
        return item;

    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            @Override
            public boolean hasNext() {
                return first!=null;
            }

            @Override
            public Item next() {
                Item item = first.item;
                first=first.next;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        Ch1P94LinkListStack<Integer> s=new Ch1P94LinkListStack<>();
        System.out.println(s.isEmpty());
        s.push(6);
        System.out.println(s.isEmpty());
        s.push(7);
        s.push(8);
        s.push(9);
        System.out.println(s.pop());
        System.out.println(s.size());
        for(Integer i : s){
            System.out.println(i);
        }
    }

}
