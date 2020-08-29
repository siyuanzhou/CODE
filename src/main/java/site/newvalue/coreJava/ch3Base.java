package site.newvalue.coreJava;

import com.sun.jmx.remote.internal.ArrayQueue;
import edu.princeton.cs.algs4.StdOut;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;


public class ch3Base {
    static String Decimal2Binary(int de){
        String numstr = "";
        while (de>0){
            int res = de%2; //除2 取余数作为二进制数
            numstr = res + numstr;
            de = de/2;
        }
        return  numstr;
    }
    public static void main(String[] args) throws IOException {
//        Console cons=System.console();
//        String username=cons.readLine("user: ");
//        char[] password=cons.readPassword("password: ");
//        System.out.println(username+":"+password);
        Scanner sc =new Scanner(Thread.currentThread().getContextClassLoader().getResourceAsStream("a.txt"),"utf-8");
//        Path path=Paths.get(Thread.currentThread().getContextClassLoader().getResource(".").getPath());
//        System.out.println(path);
        sc.hashCode();
        System.out.println(sc.nextInt());
        System.out.println(System.getProperties());
        System.out.println(new File(".").getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
        Random r=new Random(1L);
        System.out.println(r.nextInt());
        System.out.println(r.nextInt());
        int [] a={1,2,3,4,5,6,8,9};
        System.out.println(Arrays.binarySearch(a,7));
        int [][]c={{1,2},{3,4}};
        System.out.println(Arrays.deepToString(c));
        int d=9;
        int [][]b=new int[d][2];
        LocalDate date=LocalDate.now();
        System.out.println(date);
        System.out.println(date.minusDays(6));
        //System.setOut(new PrintStream(new File(Thread.currentThread().getContextClassLoader().getResource("b.txt").getPath())));
        System.out.println("2332");
        System.out.println("wsidno");
        Object[] objects=new Object[10];
        Integer[] integers=new Integer[10];
        integers[3]=new Integer(4);
        integers[3].hashCode();
        objects[3]=new Integer(4);
        int [] ints=new int[3];
        ints[0]=3;ints[1]=6;
        Object object=new Object();
        object.hashCode();
        System.out.println(Arrays.hashCode(ints));
        System.out.println(Objects.hash(ints[0]));
        date.hashCode();
        Long l=2000000000000000000L;
        System.out.println(l.hashCode());
        int [] an=new int[10];
        an[1]=1;
        int [] bn=an.clone();
        System.out.println(Arrays.toString(bn));
        Queue<String> queue=new ArrayDeque<>();
        queue.add("1");queue.add("1");
        queue.add("2");queue.add("2");
        queue.add("1");queue.add("1");
        queue.add("3");queue.add("3");
        System.out.println(queue.size());
        System.out.println(queue.remove(0));
        System.out.println(queue.toString());
        queue.poll();
        queue.poll();
        Iterator<String> it=queue.iterator();
        it.next();
        it.remove();
        it.next();
        it.remove();
        it.forEachRemaining(i-> System.out.println(i));
        System.out.println(queue);
        TreeMap<String,Integer> map=new TreeMap<>();
        map.put("123",null);
        map.put("234",null);
        map.put("345",null);
        map.put("456",null);
        map.put("567",null);
        System.out.println(map);
        map.forEach((K,V)-> map.put(K,1));
        System.out.println(map);
        System.out.println(Decimal2Binary(8));







    }
}
