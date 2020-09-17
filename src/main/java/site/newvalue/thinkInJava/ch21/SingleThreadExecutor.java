package site.newvalue.thinkInJava.ch21;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec= Executors.newFixedThreadPool(3);//SingleThreadExecutor
        for(int i=0;i<5;i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
class LiftOff implements Runnable{
    protected int countDown=10;
    private static int taskCount=0;
    private final int id=taskCount++;

    LiftOff(){}
    LiftOff(int countDown){
        this.countDown=countDown;
    }

    public String status(){
        return "#"+id+"("+(countDown>0?countDown:"liftOff!")+")";
    }

    @Override
    public void run() {
        while (countDown>=0){
            System.out.println(status());
            countDown--;
            Thread.yield();
        }
    }
}
