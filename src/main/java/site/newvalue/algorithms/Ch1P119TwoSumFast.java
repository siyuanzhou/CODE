package site.newvalue.algorithms;


import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class Ch1P119TwoSumFast {
    public static int count(int []a){
        Arrays.sort(a);
        int N=a.length;
        int cnt=0;
        for(int i=0;i<N;i++){
            if(BinarySearch.indexOf(a,-a[i])>i){
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        String file = Ch1P119TwoSumFast.class.getClassLoader().getResource("data/4Kints.txt").getPath();
        //String file = Ch1P119TwoSumFast.class.getClassLoader().getResource("data/4Kints.txt").getPath();
        int [] a= In.readInts(file);
        System.out.println(count(a));
    }
}
