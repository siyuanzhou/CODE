package site.newvalue.algorithms;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Transaction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//优先队列，找出最大的M个整数
public class Ch2P196TopM {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc =new Scanner(System.in);
        int M =sc.nextInt();
        MinPQ<Transaction> pq =new MinPQ<>(M+1);
        String file = Ch1P145WeightedQuickUnionFind.class.getClassLoader().getResource("data/tinyBatch.txt").getPath();
        System.setIn(new FileInputStream(file));
        while (StdIn.hasNextLine()){
            pq.insert(new Transaction(StdIn.readLine()));
            if(pq.size()>M){
                pq.delMin();
            }
        }
        for(Transaction t : pq){
            System.out.println(t);
        }
    }
}
