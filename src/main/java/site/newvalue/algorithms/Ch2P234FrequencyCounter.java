package site.newvalue.algorithms;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ch2P234FrequencyCounter {
    public static void main(String[] args) throws FileNotFoundException {
        int minlen=Integer.parseInt(new Scanner(System.in).next());
        String file = Ch1P145WeightedQuickUnionFind.class.getClassLoader().getResource("data/tale.txt").getPath();
        System.setIn(new FileInputStream(file));
        ST<String,Integer> st=new ST<>();
        while (!StdIn.isEmpty()){
            String word=StdIn.readString();
            if(word.length()<minlen){
                continue;
            }
            if(!st.contains(word)){
                st.put(word,1);
            }
            else {
                st.put(word,st.get(word)+1);
            }
        }
        String max="";
        st.put(max,0);
        for(String word:st.keys()){
            if(st.get(word)>st.get(max)){
                max=word;
            }
        }
        System.out.println(max+" "+st.get(max));
    }
}
