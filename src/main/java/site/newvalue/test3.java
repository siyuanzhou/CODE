package site.newvalue;




import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class test3 {
    public static void main(String[] args) throws Exception {
        Scanner in =new Scanner(System.in);
        long num=in.nextLong();
        int numThread=in.nextInt();
        long start=System.currentTimeMillis();
        long ans1=0L;
        for(int i=0;i<num;i++){
            ans1+=i;
        }
        System.out.println(ans1);
        System.out.println(System.currentTimeMillis()-start);
        long start1 = System.currentTimeMillis();
        List<Future<Long>> ans =new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(numThread);
        for(int i=0;i<numThread;i++){
            Future<Long> a=executor.submit(new SumThread(i*(num/numThread),(i+1)*(num/numThread)));
            ans.add(a);
        }
        Long res=0L;
        for(Future<Long> a:ans){
            res+=a.get();
        }
        System.out.println(res);
        System.out.println(System.currentTimeMillis()-start1);
    }
}

class SumThread implements Callable<Long>{

    private long start;
    private long end;

    public SumThread(long start, long end){
        this.start = start;
        this.end = end;
    }

    @Override
    public Long call() throws Exception {
        Long sum=0L;
        for(long i=start;i<end;i++){
            sum+=i;
        }
        return sum;
    }
}
