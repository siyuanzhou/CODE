package site.newvalue.leetcode;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    static class Tools {
        public static void printList(ListNode L) {
            while (L != null) {
                System.out.print(L.val + "->");
                L = L.next;
            }
        }

        public static ListNode arr2List(int[] arr) {
            ListNode node = new ListNode(0);
            ListNode p = node;
            for (int i = 0; i < arr.length; i++) {
                p.next = new ListNode(arr[i]);
                p = p.next;
            }
            return node.next;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("nihao");
        

    }

    // 1
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }

    // 1改
    public int[] twoSum2(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            if (map.containsKey(target - nums[j]) && map.get(target - nums[j]) != j) {
                ans[0] = j;
                ans[1] = map.get(target - nums[j]);
                return ans;
            }
        }

        return ans;
    }

    // 9
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            int num = 0;
            int cur = x;
            while (cur != 0) {
                num = num * 10 + cur % 10;
                cur /= 10;
            }
            return num == x;
        }
    }

    // 13
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<Character, Integer>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                ans -= romanMap.get(s.charAt(i));
            } else {
                ans += romanMap.get(s.charAt(i));
            }
        }
        ans += romanMap.get(s.charAt(s.length() - 1));
        return ans;

    }

    // 14
    public String longestCommonPrefix(String[] strs) {

        StringBuilder ans = new StringBuilder();
        if (strs.length == 0) {
            return ans.toString();
        }

        outer:
        for (int i = 0; i < strs[0].length(); i++) {
            char a = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length() || a != strs[j].charAt(i)) {
                    break outer;
                }
            }
            ans.append(a);
        }
        return ans.toString();
    }

    // 20
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((!stack.isEmpty()) && ((c == ')' && stack.peekFirst() == '(') || (c == ']' && stack.peekFirst() == '[')
                    || (c == '}' && stack.peekFirst() == '{'))) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    // 21
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode preHead = new ListNode(0);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 == null) {
            prev.next = l2;
        } else if (l2 == null) {
            prev.next = l1;
        }
        return preHead.next;
    }

    // 23
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                ans.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        Collections.sort(ans);
        ListNode node = new ListNode(0);
        ListNode p = node;
        for (int i = 0; i < ans.size(); i++) {
            p.next = new ListNode(ans.get(i));
            p = p.next;
        }
        Tools.printList(node.next);
        return node.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode preHead = new ListNode(0);
        ListNode prev = preHead;
        int min = Integer.MAX_VALUE;
        boolean flag = true;
        while (flag == true) {
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (lists[i].val < min) {
                    min = lists[i].val;
                }
            }
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (lists[i].val == min) {
                    prev.next = lists[i];
                    lists[i] = lists[i].next;
                    prev = prev.next;
                    min = Integer.MAX_VALUE;
                }
            }
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    flag = true;
                    break;
                }
                flag = false;
            }
        }
        Tools.printList(preHead.next);
        return preHead.next;
    }

    // 27
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    // 27改
    public int removeElement2(int[] nums, int val) {
        int ans = nums.length;
        for (int i = 0; i < ans; ) {
            if (nums[i] != val) {
                i++;
            } else {
                nums[i] = nums[ans - 1];
                ans--;
            }
        }
        return ans;
    }

    // 38
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            char pre = str.charAt(0);
            int count = 1;
            for (int j = 1; j < str.length(); j++) {
                if (pre == str.charAt(j)) {
                    count++;
                } else {

                    sb.append(count).append(pre);
                    pre = str.charAt(j);
                    count = 1;
                }
            }
            sb.append(count).append(pre);
            str = sb.toString();
        }

        return str;
    }

    // 100
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (q == null && p != null) || (p.val != q.val)) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    // 200
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int ans = 0;
        int rowlen = grid.length;
        int collen = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    grid[i][j] = '0';
                    Queue<Integer> q = new LinkedList<Integer>();
                    q.offer(i * collen + j);
                    while (!q.isEmpty()) {
                        int id = q.poll();
                        int row = id / collen;
                        int col = id % collen;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            q.offer((row - 1) * collen + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < rowlen && grid[row + 1][col] == '1') {
                            q.offer((row + 1) * collen + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            q.offer(id - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < collen && grid[row][col + 1] == '1') {
                            q.offer(id + 1);
                            grid[row][col + 1] = '0';
                        }
                    }

                }
            }
        }
        return ans;
    }

}
