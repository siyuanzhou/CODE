package site.newvalue.leetcode;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int x) {
        val = x;
    }
}

class Pair{
    int l;
    int r;
    Pair(int l,int r){
        this.l=l;
        this.r=r;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "l=" + l +
                ", r=" + r +
                '}';
    }

    Pair(){}
}

public class Solution {

    public static void main(String[] args) {

    }

    //常用静态方法
    //打印链表
    public static void printList(ListNode L) {
        while (L != null) {
            System.out.print(L.val + "->");
            L = L.next;
        }
    }

    //数组构建链表
    public static ListNode constructList(int[] arr) {
        ListNode node = new ListNode(0);
        ListNode p = node;
        for (int i = 0; i < arr.length; i++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
        return node.next;
    }

    //数组构建二叉树
    public static TreeNode constructTree(Integer[] nums) {
        if (nums.length == 0){
            return new TreeNode(0);
        }
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        // 创建一个根节点
        TreeNode root = new TreeNode(nums[0]);
        nodeQueue.offer(root);
        TreeNode cur;
        // 记录当前行节点的数量（注意不一定是2的幂，而是上一行中非空节点的数量乘2）
        int lineNodeNum = 2;
        // 记录当前行中数字在数组中的开始位置
        int startIndex = 1;
        // 记录数组中剩余的元素的数量
        int restLength = nums.length - 1;

        while (restLength > 0) {
            // 只有最后一行可以不满，其余行必须是满的

            for (int i = startIndex; i < startIndex + lineNodeNum; i = i + 2) {
                // 说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                if (i == nums.length) {
                    return root;
                }
                cur = nodeQueue.poll();
                if (nums[i] != null) {
                    cur.left = new TreeNode(nums[i]);
                    nodeQueue.offer(cur.left);
                }
                // 同上，说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                if (i + 1 == nums.length) return root;
                if (nums[i + 1] != null) {
                    cur.right = new TreeNode(nums[i + 1]);
                    nodeQueue.offer(cur.right);
                }
            }
            startIndex += lineNodeNum;
            restLength -= lineNodeNum;
            lineNodeNum = nodeQueue.size() * 2;
        }
        return root;
    }

    // 用于获得树的层数
    public static int getTreeDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }

    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) {
            return;
        }
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.val);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) {
            return;
        }
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }

    //打印树
    public static void printTree(TreeNode root) {
        if (root == null){
            System.out.println("EMPTY!");
        }
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth / 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }

    // 中序遍历二叉搜索树
    public static void InorderTraversal(TreeNode root,LinkedList<Integer> l){
        if(root==null){
            return;
        }
        InorderTraversal(root.left,l);
        l.add(root.val);
        InorderTraversal(root.right,l);
    }


    //1 两数之和，给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int a=target-nums[i];
            if(map.containsKey(a)){
                return new int[]{map.get(a),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //2 两数相加
    //给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    //如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p=l1,q=l2;
        ListNode ans=new ListNode();
        ListNode n=ans;
        int carry=0;//进位
        while (p!=null||q!=null){
            int pval=(p==null)?0:p.val;
            int qval=(q==null)?0:q.val;
            int temp=(pval+qval+carry)%10;
            carry=(pval+qval+carry)/10;
            n.next=new ListNode(temp);
            n=n.next;
            if(p!=null){
                p=p.next;
            }
            if(q!=null){
                q=q.next;
            }
        }
        if(carry==1){
            n.next=new ListNode(1);
        }
        return ans.next;
    }

//    17. 电话号码的字母组合
//    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    //深度搜索
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map=new HashMap<Character,String>(){
            {
                put('2',"abc");
                put('3',"def");
                put('4',"ghi");
                put('5',"jkl");
                put('6',"mno");
                put('7',"pqrs");
                put('8',"tuv");
                put('9',"wxyz");
            }
        };
        List<String> ans=new ArrayList<String>();
        if(digits.length()==0){
            return ans;
        }
        dfsAppend(map,ans,digits,0,new StringBuilder());
        return ans;
    }
    public void dfsAppend(HashMap map, List<String> ans, String digits, int index, StringBuilder sb){
        if(index==digits.length()){
            ans.add(sb.toString());
        }
        else{
            char a=digits.charAt(index);
            String letter= (String) map.get(a);
            for(int i=0;i<letter.length();i++){
                sb.append(letter.charAt(i));
                dfsAppend(map,ans,digits,index+1,sb);
                sb.delete(index,sb.length());
            }
        }
    }
    //广度搜索
    public List<String> letterCombinations2(String digits) {
        //数组省内存
        Deque<Integer> path=new ArrayDeque<>();
        String[] map=new String[]{
                "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        Queue<String> queue=new LinkedList<String>();
        if(digits.length()==0){
            return new ArrayList<String>();
        }
        queue.offer("");
        for(int i=0;i<digits.length();i++){
            char c=digits.charAt(i);
            String letter=map[c-'2'];
            int size=queue.size();
            for(int z=0;z<size;z++){
                String tmp=queue.poll();
                for(int j=0;j<letter.length();j++){
                    queue.offer(tmp+letter.charAt(j));
                }
            }
        }
        return new ArrayList<String>(queue);
    }

    //20. 有效的括号
    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    //有效字符串需满足：
    //左括号必须用相同类型的右括号闭合。
    //左括号必须以正确的顺序闭合
    public boolean isValid(String s) {
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        LinkedList<Character> stack = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            Character ch=s.charAt(i);
            if(stack.isEmpty())
                stack.push(s.charAt(i));
            else {
                if(!ch.equals(map.get(stack.peek())))
                {
                    return false;
                }
                stack.pop();
            }
        }
        return true;
    }



    //28. 实现 strStr()
    //实现 strStr() 函数。
    //给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
    public int strStr(String haystack, String needle) {
        if(haystack.length()==0){
            return -1;
        }
        int m=haystack.length(),n=needle.length();
        int pn=0;
        while (pn<m-n+1){
            while (pn<m-n+1&&haystack.charAt(pn)!=needle.charAt(0)){
                pn++;
            }
            int pl=0,cur=pn;
            while (haystack.charAt(cur)==needle.charAt(pl)){
                pl++;
                cur++;
            }
            if(pl==n){
                return pn;
            }
            else {
                pn=pn+1;
            }
        }
        return -1;
    }

    //反转字符串
    //编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出
    public void reverseString(char[] s) {
        int l=s.length;
        for(int i=0;i<l/2;i++){
            char tmp=s[i];
            s[i]=s[l-i-1];
            s[l-i-1]=tmp;
        }
        Arrays.binarySearch(s,'a');
    }

//    46. 全排列
//    给定一个 没有重复 数字的序列，返回其所有可能的全排列。
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0){
            return ans;
        }
        int len=nums.length;
        Deque<Integer> stack=new ArrayDeque<>();
        boolean[] used=new boolean[len];
        dfs(nums,ans,len,used,0,stack);
        return ans;


    }
    public void dfs(int[] nums,List<List<Integer>> ans,int len,boolean[] used,int depth,Deque<Integer> stack){
        if(depth==len){
            ans.add(new ArrayList(stack));
            return;
        }
        for(int i=0;i<len;i++){
            if(used[i]==true){
                continue;
            }else{
                used[i]=true;
                stack.push(nums[i]);
                dfs(nums,ans,len,used,depth+1,stack);
                stack.pop();
                used[i]=false;
            }
        }
    }


//103. 二叉树的锯齿形层次遍历
//    给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return null;
        }
        List<List<Integer>> ans= new LinkedList<>();
        LinkedList<TreeNode> s1 =new LinkedList<TreeNode>();
        s1.push(root);
        LinkedList<TreeNode> s2=new LinkedList<TreeNode>();

        while(!s1.isEmpty()||!s2.isEmpty()){
            LinkedList<Integer> tmp=new LinkedList<>();
            TreeNode cur=null;
            if(!s1.isEmpty()){
                while(!s1.isEmpty()){
                    cur=s1.pop();
                    tmp.add(cur.val);
                    if(cur.right!=null){
                        s2.push(cur.right);
                    }
                    if(cur.left!=null){
                        s2.push(cur.left);
                    }
                }
            }else{
                while(!s2.isEmpty()){
                    cur=s2.pop();
                    tmp.add(cur.val);
                    if(cur.left!=null){
                        s1.push(cur.left);
                    }
                    if(cur.right!=null){
                        s1.push(cur.right);
                    }
                }
            }
            ans.add(tmp);
        }
        return ans;
    }



    //    201. 数字范围按位与
    //给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
    //最终我们可以将问题重新表述为：给定两个整数，我们要找到它们对应的二进制字符串的公共前缀。
    //右移两个数直到相等
    public int rangeBitwiseAnd(int m, int n) {
        int count=0;

        while (m<n){
            m=m>>1;
            n=n>>1;
            count++;
            
        }
        return n<<count;
    }

    //498. 对角线遍历
    //给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length==0){
            return new int[0];
        }
        int [] ans=new int[matrix.length*matrix[0].length];
        int z=0;
        LinkedHashMap<Integer,ArrayList<Integer>> map=new LinkedHashMap();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(map.containsKey(i+j)){
                    ArrayList<Integer> arrayList=map.get(i+j);
                    arrayList.add(matrix[i][j]);
                }
                else {
                    ArrayList<Integer> arrayList=new ArrayList<Integer>();
                    arrayList.add(matrix[i][j]);
                    map.put(i+j,arrayList);
                }
            }
        }
        for(Integer key :map.keySet()){
            if(key%2!=0){
                ArrayList<Integer> arrayList=map.get(key);
                for (Integer integer : arrayList) {
                    ans[z++] = integer;
                }
            }
            else {
                ArrayList<Integer> arrayList=map.get(key);
                for (int i=arrayList.size()-1;i>=0;i--) {
                    ans[z++] = arrayList.get(i);
                }
            }
        }
        return ans;
    }


    //229. 求众数 II
    //给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
    //说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
    //1、如果投A（当前元素等于A），则A的票数++;
    //2、如果投B（当前元素等于B），B的票数++；
    //3、如果A,B都不投（即当前与A，B都不相等）,那么检查此时A或B的票数是否减为0，如果为0,则当前元素成为新的候选人；如果A,B两个人的票数都不为0，那么A,B两个候选人的票数均减一。
    //最后会有这么几种可能：有2个大于n/3，有1个大于n/3，有0个大于n/3
    //遍历结束后选出了两个候选人，但是这两个候选人是否满足>n/3
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int cand1=0,count1=0;
        int cand2=0,count2=0;
        for(int num:nums){
            if(cand1==num){
                count1++;
                continue;
            }
            if(cand2==num){
                count2++;
                continue;
            }
            if (count1==0){
                cand1=num;
                count1++;
                continue;
            }
            if (count2==0){
                cand2=num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        count1=0;
        count2=0;
        for (int num:nums){
            if(cand1==num){
                count1++;
                continue;
            }
            if (cand2==num){
                count2++;
                continue;
            }
        }
        if(count1>=nums.length/3){
            ans.add(cand1);
        }
        if(count2>=nums.length/3){
            ans.add(cand2);
        }
        return ans;
    }
    
    //435 删除最小的区间，使区间不重叠
    public int eraseOverlapIntervals(int[][] intervals) {
        LinkedList<Pair> l=new LinkedList<Pair>();
        for(int i=0;i<intervals.length;i++){
            l.add(new Pair(intervals[i][0],intervals[i][1]));
        }
        Collections.sort(l, (Pair o1, Pair o2) -> (o1.r!=o2.r)?(o1.r-o2.r):(o1.l-o2.l));
        System.out.println(l.toString());
        Iterator<Pair> it=l.iterator();
        Pair pre=it.next();
        int cout=0;
        while (it.hasNext()){
            Pair cur=it.next();
            if(cur.l<pre.r){
                cout++;
            }
            else {
                pre=cur;
            }
        }
        return cout;
    }

    //455. 分发饼干
    //假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0,ans=0;
        while (i<g.length&&j<s.length){
            if(g[i]<=s[j]){
                ans++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return ans;
    }

    //1305. 两棵二叉搜索树中的所有元素 给你 root1 和 root2 这两棵二叉搜索树。
    //请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。
    //先中序搜索，得到有序的两个列表，后归并排序，得到最终结果
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> ans=new LinkedList<>();
        LinkedList<Integer> l1=new LinkedList<>();
        InorderTraversal(root1,l1);
        LinkedList<Integer> l2= new LinkedList<>();
        InorderTraversal(root2,l2);
        int i=0,j=0;
        for(;i<l1.size()&&j<l2.size();){
            if(l1.get(i)<=l2.get(j)){
                ans.add(l1.get(i));
                i++;
            }
            else if(l1.get(i)>l2.get(j)){
                ans.add(l2.get(j));
                j++;
            }
        }
        while (j<l2.size()){
            ans.add(l2.get(j));
            j++;
        }
        while (i<l1.size()){
            ans.add(l1.get(i));
            i++;
        }
        return ans;
    }

//    public static void main(String[] args) {
//        /*用于测试的树，
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
//        */
//        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
//        TreeNode root = constructTree(nums);
////        printTree(root);
//        LinkedList<Integer> l=new LinkedList<>();
//        InorderTraversal(root,l);
////        for (int i=0;i<l.size();i++){
////            System.out.println(l.get(i));
////        }
//        String s=new String();
//
//    }


}
