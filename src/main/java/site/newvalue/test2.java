package site.newvalue;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test2 {
    static volatile int j=0;
    static volatile int flag=0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                while (j<100){
                    if(flag%3==0){
                        System.out.println(Thread.currentThread().getName()+":"+j);
                        j++;
                        flag=1;
                    }
                }

            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                while (j<100){
                    if(flag%3==1){
                        System.out.println(Thread.currentThread().getName()+":"+j);
                        j++;
                        flag=2;
                    }
                }

            }
        });
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                while (j<100){
                    if(flag%3==2){
                        System.out.println(Thread.currentThread().getName()+":"+j);
                        j++;
                        flag=3;
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
