package site.newvalue.algorithms;

public class Ch1Gcd {
    public static int gcd(int a,int b) {
        if (b == 0) {
            return a;
        }
        int r = a % b;
        return gcd(b, r);
    }

    public static void main(String[] args) {
        int a = gcd(16, 12 );
        System.out.println(a);
    }
}