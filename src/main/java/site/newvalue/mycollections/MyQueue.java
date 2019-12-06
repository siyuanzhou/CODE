package site.newvalue.mycollections;

import java.util.ArrayList;

public class MyQueue {
    private ArrayList<Integer> data;
    private int start;

    public MyQueue() {
        // TODO Auto-generated constructor stub
        start = 0;
        data = new ArrayList<Integer>();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enQueue(5);
        q.enQueue(3);
        if (q.isEmpty() == false) {
            System.out.println(q.front());
        }
        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.front());
        }
        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.front());
        }
    }

    boolean isEmpty() {
        return start >= data.size();
    }

    boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    boolean deQueue() {
        if (!isEmpty()) {
            start++;
            return true;
        }
        return false;
    }

    int front() {
        return data.get(start);
    }

}
