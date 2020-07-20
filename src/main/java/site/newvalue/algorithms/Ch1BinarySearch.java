package site.newvalue.algorithms;

import edu.princeton.cs.algs4.In;

import java.io.InputStream;
import java.util.Arrays;


public class Ch1BinarySearch {
    public static int binarySearch(int key,int[] arr){
        int l=0,r=arr.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(key>arr[mid]){
                l=mid+1;
            }
            else if(key<arr[mid]){
                r=mid-1;
            }
            else if(key==arr[mid]) {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int key,int[] arr,int l,int r){
        if(l>r){
            return -1;
        }
        int mid =(l+r)/2;
        if(key>arr[mid]){
            return binarySearchRecursive(key,arr,mid+1,r);
        }
        else if(key<arr[mid]){
            return binarySearchRecursive(key,arr,l,r-1);
        }
        else {
            return mid;
        }
    }

    public static void main(String[] args) {
        String file = Ch1BinarySearch.class.getClassLoader().getResource("data/tinyW.txt").getPath();
        int []a= In.readInts(file);
//        int []a={1,3,5,7,9,48,67,90,89};
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        Arrays.sort(a);
        int b=binarySearch(48,a);
        System.out.println(b);
    }
}
