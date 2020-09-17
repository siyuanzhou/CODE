package site.newvalue.thinkInJava.ch21;

import java.util.ArrayList;
import java.util.concurrent.*;

//从任务中返回值
public class P21TaskWithResult implements Callable {
    private int id;
    P21TaskWithResult(){}
    P21TaskWithResult(int id){
        this.id=id;
    }
    @Override
    public String call() throws Exception {
        return "#"+id;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec= Executors.newFixedThreadPool(5);
        ArrayList<Future<String>> results=new ArrayList<>();
        for(int i=0;i<10;i++){
            results.add(exec.submit(new P21TaskWithResult(i)));
        }
        for(Future<String> fs:results){
            System.out.println(fs.isDone());
            System.out.println(fs.get());
        }
        exec.shutdown();
    }
}
