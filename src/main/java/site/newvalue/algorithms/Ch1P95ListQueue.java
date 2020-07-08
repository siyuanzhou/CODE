package site.newvalue.algorithms;

import java.util.Iterator;

public class Ch1P95ListQueue<Item> implements Iterable<Item> {
    private Node<Item> first;//最早添加的节点
    private Node<Item> last;//列表尾
    private int N;//数目
    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        return N;
    }
    //入队列
    public void enqueue(Item item){
        Node<Item> node=new Node<>();
        node.item=item;
        if(isEmpty()){
            first=last=node;
        }
        last.next=node;
        last=last.next;
        N++;
    }
    public Item dequeue(){
        Item item=first.item;
        first=first.next;
        if(isEmpty()){
            last=null;
        }
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
        Ch1P95ListQueue<Integer> s=new Ch1P95ListQueue<>();
        System.out.println(s.isEmpty());
        s.enqueue(6);
        System.out.println(s.isEmpty());
        s.enqueue(7);
        s.enqueue(8);
        s.enqueue(9);
        System.out.println(s.dequeue());
        System.out.println(s.size());
        for(Integer i : s){
            System.out.println(i);
        }
    }

}
