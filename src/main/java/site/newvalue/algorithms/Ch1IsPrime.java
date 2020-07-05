package site.newvalue.algorithms;

public class Ch1IsPrime {
    public static boolean isPrime(int a){
        if(a<=2){
            return true;
        }
        for(int i=2;i*i<=a;i++){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(2));
        System.out.println(isPrime(9));
        System.out.println(isPrime(17));

    }
}
