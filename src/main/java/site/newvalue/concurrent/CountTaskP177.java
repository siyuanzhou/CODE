package site.newvalue.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class CountTaskP177 extends RecursiveTask<Integer> {
    private static final int THRESHOLD=10;
    private int start;
    private int end;
    public CountTaskP177(int start,int end){
        this.start=start;
        this.end=end;
    }

    @Override
    protected Integer compute() {
        int sum=0;
        boolean canCompute=(end-start)<= THRESHOLD;
        if(canCompute){
            for(int i=start;i<=end;i++){
                sum+=i;
            }
        }else {
            int middle=(start+end)/2;
            CountTaskP177 left=new CountTaskP177(start,middle);
            CountTaskP177 right=new CountTaskP177(middle+1,end);
            left.fork();
            right.fork();
            sum=left.join()+ right.join();
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ForkJoinPool pool=new ForkJoinPool();
        CountTaskP177 task=new CountTaskP177(0,100000);
        Future<Integer> result=pool.submit(task);
        System.out.println(result.get());
    }
}
