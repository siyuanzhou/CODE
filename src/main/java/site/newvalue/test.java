package site.newvalue;

import edu.princeton.cs.algs4.In;
import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class test {
    public static int[] twoSum(int[] numbers, int target) {
        int [] ans=new int[2];
        int index=0;
        for(int i=0;i<=numbers.length/2;i++){
            if((index=Arrays.binarySearch(numbers,i+1,numbers.length,target-numbers[i]))>0){
                ans[0]=i+1;
                ans[1]=index+1;
            }
        }
        return ans;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(numRows==0){
            return ans;
        }
        List<Integer> arr=new ArrayList<>();
        arr.add(1);
        ans.add(arr);
        for(int i=1;i<numRows;i++){
            List<Integer> arr2=new ArrayList<>();
            arr2.add(1);
            List<Integer> pre=ans.get(i-1);
            for(int j=0;j<pre.size()-1-1;j++){
                arr2.add(pre.get(j)+pre.get(j-1));
            }
            arr2.add(1);
            ans.add(arr2);
            arr2=null;
        }
        return ans;

    }
    public String reverseWords(String s) {
        String [] strs=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(String s1:strs){
            sb.append(new StringBuilder(s1).reverse()).append(" ");
        }
        return sb.toString().trim();
    }
    public static void main(String[] args) throws IOException {
        System.out.println(42==42.0);
        int [] numbers={5,25,75};
        System.out.println(Arrays.toString(twoSum(numbers,100)));
        Set<Integer> set=new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Set<Integer> s=Collections.unmodifiableSet(set);
        System.out.println(s.equals(set));
        Collection<Integer> s1= Collections.unmodifiableCollection(set);
        System.out.println(s1.equals(set));
        Properties properties=new Properties();
        String path = Thread.currentThread().getContextClassLoader().getResource("a.propertites").getPath();
        System.out.println(path);
        properties.load(new FileInputStream(new File(path)));
        properties.setProperty("zsy","123");
        System.out.println(properties);
        properties.store(new FileWriter(new File(path)),"sa");
        int n=2000000;
        BitSet b=new BitSet(n+1);
        int count=0;
        for(int i=0;i<n;i++){
            b.set(i);
        }
        for(int i=2;i<=n;i++){
            if(b.get(i)){
                count++;
                for(int k=i*2;k<=n;k=k+i){
                    b.clear(k);
                }
            }
        }
        System.out.println(b.get(11));

        System.out.println(count);



    }
}
