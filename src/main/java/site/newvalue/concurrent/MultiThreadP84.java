package site.newvalue.concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThreadP84 {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean= ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos=threadMXBean.dumpAllThreads(false,false);
        for(ThreadInfo t:threadInfos){
            System.out.println(t.getThreadId()+"->"+t.getThreadName());
        }
    }
}
