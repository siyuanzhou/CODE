package site.newvalue.concurrent;

import java.util.HashMap;
import java.util.UUID;

public class PutHashMapP155 {
    public static void main(String[] args) throws InterruptedException {
        final HashMap<String,String> map=new HashMap<>(2);
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(),"");
                        }
                    },"ftf"+i).start();
                }
            }
        });
        t.start();
        t.join();
        System.out.println(1);
//        System.out.println(map.toString());
//        for (Map.Entry e:map.entrySet()){
//            System.out.println(e.getKey()+"->"+e.getValue());
//        }
    }

}
