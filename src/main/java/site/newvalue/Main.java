package site.newvalue;



import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
     int val;
    TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Main{
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        int n=grid.length;
        if(grid==null||n==0){
            return ans;
        }
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)
                {
                    ans= Math.max(ans,dfs(grid,i,j));
                }
            }
        }
        return ans;
    }
    public static int dfs(int[][]grid,int i,int j){
        int n=grid.length;
        int m=grid[0].length;
        if(i<0||i>=n||j<0||j>=m||grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        return 1+dfs(grid,i-1,j)+ dfs(grid,i+1,j)+dfs(grid,i,j-1)+dfs(grid,i,j+1);
    }

    public static void main(String[] args) {
        int [][] grid=new int [][]
                {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        int a=new Main().maxAreaOfIsland(grid);
        System.out.println(a);
    }
}
