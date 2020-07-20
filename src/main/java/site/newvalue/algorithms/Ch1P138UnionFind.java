package site.newvalue.algorithms;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.*;

public class Ch1P138UnionFind {
    private int []id;//连通分量id
    private int count;//连通分量数目
    Ch1P138UnionFind(int N){
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

    public int find(int p){
        return id[p];
    }

    public void union(int p,int q){
        int pid=find(p);
        int qid=find(q);
        if(pid==qid){
            return;
        }
        for(int i=0;i<id.length;i++){
            if(qid==id[i]){
                id[i]=pid;
            }
        }
        count--;
    }

    public static void main(String[] args) throws IOException {
        String file = Ch1P138UnionFind.class.getClassLoader().getResource("data/largeUF.txt").getPath();
        System.setIn(new FileInputStream(file));
        int N= StdIn.readInt();
        System.out.println(N);
        Ch1P138UnionFind uf=new Ch1P138UnionFind(N);
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
