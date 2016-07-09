package site.newvalue.algorithms;

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
        int []a={1,2,4,5,7,9,13,15};
        int b=binarySearchRecursive(7,a,0,a.length-1);
        System.out.println(b);
    }
}
