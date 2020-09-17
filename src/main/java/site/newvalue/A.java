package site.newvalue;

import edu.princeton.cs.algs4.StdIn;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.*;

public class A {
    class Ain{
        int c;
    }
    private int a;
    private int b;

    public A(){}

    public A(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "A"+super.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.printf("dskal %s\n","zsy");
        System.out.println("zsy123".matches("//d+"));
        System.out.println(new File(Thread.currentThread().getContextClassLoader().getResource("").getPath()));
        Scanner sc=new Scanner(new File(Thread.currentThread().getContextClassLoader().getResource("").getPath().toString()+"/"+"a.txt"));
        System.out.println(sc.nextInt());
    }
}
