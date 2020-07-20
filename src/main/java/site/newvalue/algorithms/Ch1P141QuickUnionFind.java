package site.newvalue.algorithms;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.IOException;

public class Ch1P141QuickUnionFind {
    private int []id;//连通分量id，其值为同一个分量另一个触点的地址
    private int count;//连通分量数目
    Ch1P141QuickUnionFind(int N){
        count=N;
        id=new int [N];
        for(int i=0;i<N;i++){
            id[i]=i;
        }
    }
    public int count(){
        return count;
    }


    public boolean isconnected(int p,int q){
        return find(p)==find(q);
    }

    //一直往上找，直到找到跟触点（p==id[p])
    public int find(int p){
        while (p!=id[p]){
            p=id[p];
        }
        return id[p];//返回的是跟触点
    }

    public void union(int p,int q){
        int pid=find(p);//找到p的跟触点
        int qid=find(q);
        if(pid==qid){
            return;
        }
        id[pid]=qid;
        count--;
    }

    public static void main(String[] args) throws IOException {
        String file = Ch1P141QuickUnionFind.class.getClassLoader().getResource("data/largeUF.txt").getPath();
        System.setIn(new FileInputStream(file));
        int N= StdIn.readInt();
        System.out.println(N);
        Ch1P141QuickUnionFind uf=new Ch1P141QuickUnionFind(N);
        while (!StdIn.isEmpty()){
            int p=StdIn.readInt();
            int q=StdIn.readInt();
            if(uf.isconnected(p,q)){
                continue;
            }
            uf.union(p,q);
            StdOut.println(p+" "+q);
        }
        StdOut.println("complate :"+uf.count());
    }


}
