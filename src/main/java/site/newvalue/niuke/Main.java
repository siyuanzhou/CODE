package site.newvalue.niuke;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static int[] printMatrix(int[][] mat, int n, int m) {
        // write code here
        int[] temp = new int[n * m];
        int z = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    temp[z++] = mat[i][j];
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    temp[z++] = mat[i][j];
                }
            }
        }
        return temp;
    }

    public static int[][] flipChess(int[][] A, int[][] f) {
        // write code here
        int z = f.length;
        for (int i = 0; i < z; i++) {
            int a = f[i][0] - 1, b = f[i][1] - 1;
            if (a + 1 < 4) {
                A[a + 1][b] = (A[a + 1][b] == 0) ? 1 : 0;
            }
            if (a - 1 >= 0) {
                A[a - 1][b] = (A[a - 1][b] == 0) ? 1 : 0;
            }
            if (b + 1 < 4) {
                A[a][b + 1] = (A[a][b + 1] == 0) ? 1 : 0;
            }
            if (b - 1 >= 0) {
                A[a][b - 1] = (A[a][b - 1] == 0) ? 1 : 0;
            }
        }
        return A;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        LinkedList<Integer> l = new LinkedList<Integer>();
        for (int i = 0; i <= a; i++) {
            l.add(i);
        }
        while (l.size() != 1) {
            int len = l.size();
            l.remove(0);
            for (int i = 2; i < len; ) {
                l.remove(i);
                i = i + 2;
            }
        }
        System.out.println(l.getFirst());
    }

    public int findMaxDivision(int[] A, int n) {
        // write code here
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            if (A[i] < min) {
                min = A[i];
            }
        }
        int[] temp = new int[max - min + 1];
        for (int i = 0; i < n; i++) {
            temp[A[i] - min]++;

        }
        int ans = 0;
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                count++;
            } else {
                if (ans <= count) {
                    ans = count;
                }
                count = 0;
            }
        }
        return ans + 1;
    }

    public String formatString(String A, int n, char[] arg, int m) {
        // write code here
        int z = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '%' && A.charAt(i + 1) == 's') {
                i++;
                sb.append(arg[z++]);
            } else {
                sb.append(A.charAt(i));
            }
        }
        for (int i = z; i < m; i++) {
            sb.append(arg[i]);
        }
        return sb.toString();
    }

    public boolean checkWon(int[][] board) {
        // write code here
        if ((board[0][0] + board[1][1] + board[2][2] == 3) || (board[0][2] + board[1][1] + board[2][0] == 3)) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] + board[i][1] + board[i][2] == 3) || (board[0][i] + board[1][i] + board[2][i] == 3)) {
                return true;
            }
        }
        return false;
    }

    public String[] chkBlood(String father, String mother) {
        // write code here
        Map<String, String[]> map = new HashMap<String, String[]>();
        map.put("OO", new String[]{"O"});
        map.put("AO", new String[]{"A", "O"});
        map.put("AA", new String[]{"A", "O"});
        map.put("AB", new String[]{"A", "AB", "B", "O"});
        map.put("AAB", new String[]{"A", "AB", "B"});
        map.put("BO", new String[]{"B", "O"});
        map.put("BB", new String[]{"B", "O"});
        map.put("BAB", new String[]{"A", "AB", "B"});
        map.put("ABO", new String[]{"A", "B"});
        map.put("ABAB", new String[]{"A", "AB", "B"});
        String key = father + mother, key2 = mother + father;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (map.containsKey(key2)) {
            return map.get(key2);
        }
        return null;

    }

}
