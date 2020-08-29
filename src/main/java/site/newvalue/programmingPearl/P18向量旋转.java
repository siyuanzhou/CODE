package site.newvalue.programmingPearl;


import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.StdOut;

import java.io.Console;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

public class P18向量旋转 {
    public static String reverse(String s,int i){
        StringBuilder sb =new StringBuilder();
        sb.append(new StringBuilder(s.substring(0,i)).reverse());
        sb.append(new StringBuilder(s.substring(i)).reverse());
        return sb.reverse().toString();
    }

    public static void swap(char [] s,int i,int j){
        char temp =s[i];
        s[i]=s[j];
        s[j]=temp;
    }
    public static char[] reverse(char[] s,int i){
        for(int z=0;z<i/2;z++){
            swap(s,z,i-z-1);
        }
        for(int z=i;z<i+(s.length-1-i)/2;z++){
            swap(s,z,s.length-1-(z-i));
        }
        for(int z=0;z<(s.length-1)/2;z++){
            swap(s,z,s.length-1-z);
        }
        return s;
    }


    public static void main(String[] args) {
        System.out.println(reverse("1234567890",4));
        char[] s={'1','2','3','4','5','6','7','8','9'};
        reverse(s,4);
        System.out.println(s);
        int a=1000;
        Long b=1L;
        a+=1L;
        a=(int)(6+b);
        int d=(int)(a+1.0);
        double m= Math.sqrt(-6.5);//m=NaN
        System.out.println(Double.isNaN(m));
        System.out.println(2.0-1.1); //0.8999999999999999
        System.out.println(new BigDecimal(2.0).add(new BigDecimal(1.1)));
        System.out.println(Math.floorMod(-1,12));//11
        int n=123456789;
        float f=n+1f;
        System.out.println(f);//精度丢失
        double x=3.142;
        System.out.println((int)x);//31 截断小数
        System.out.println((byte)(129));// -127 超出范围，只保留前两个字节
        int x1=1;
        x1+=3.14;//x1=x1+31.4;报错
        System.out.println(x1);//4 x1=(int)(x1+3.14)
        System.out.println(2<<35);//2<<(35%32)
        int [] cp="中速递圣诞节卡萨sjdj".codePoints().toArray();
        System.out.println(Arrays.toString(cp));
        System.out.println(new String(cp,0,cp.length));
        char ca="周思远".charAt(1);
        System.out.println(ca);
        System.out.println(Character.isSupplementaryCodePoint(ca));
        System.out.println("周思远".codePointAt(1));
        System.out.println("12345567888".replace("67",new StringBuffer("77777")));

    }

}
