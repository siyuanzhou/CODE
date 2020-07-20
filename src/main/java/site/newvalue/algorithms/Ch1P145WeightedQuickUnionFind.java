package site.newvalue.algorithms;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.IOException;

public class Ch1P145WeightedQuickUnionFind {
    private int []id;//连通分量id，其值为同一个分量另一个触点的地址
    private int []sz;//根节点的长度大小
    private int count;//连通分量数目
    Ch1P145WeightedQuickUnionFind(int N){
        count=N;
        id=new int [N];
        sz=new int[N];
        for(int i=0;i<N;i++){
            sz[i]=1; //初始都为根节点1
        }
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
        if(sz[pid]>sz[qid]){
            id[qid]=pid;
            sz[pid]+=sz[qid];
        }
        else {
            id[pid]=qid;
            sz[qid]+=sz[pid];
        }
        count--;
    }

    public static void main(String[] args) throws IOException {
        String file = Ch1P145WeightedQuickUnionFind.class.getClassLoader().getResource("data/largeUF.txt").getPath();
        System.setIn(new FileInputStream(file));
        int N= StdIn.readInt();
        System.out.println(N);
        Ch1P145WeightedQuickUnionFind uf=new Ch1P145WeightedQuickUnionFind(N);
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
