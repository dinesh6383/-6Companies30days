package Amazon;

import java.util.Arrays;

public class Brackets_In_Matrix_Chain_Multiplication {
    public static String matrixChainOrderRecursive(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        char[][] order = new char[n][26];

        for(int [] temp : dp) {
            Arrays.fill(temp, -1);
        }

        getMinimumValue(arr, 1, n - 1, dp, order);
        String resulString = constructString(order, 1, n - 1);
        return resulString;
    }

    public static int getMinimumValue(int[] arr, int i, int j, int[][] dp, char[][] order) {
        if(i == j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int minRes = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            int currRes = arr[i - 1] * arr[j] * arr[k] + getMinimumValue(arr, i, k, dp, order) + getMinimumValue(arr, k + 1, j, dp, order);
            if(currRes < minRes) {
                minRes = currRes;
                order[i][j] = (char) ('A' + k - 1);
            }
        }
        return dp[i][j] = minRes;
    }

    public static String matrixChainOrderIterative(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        char[][] order = new char[n][26];
        
        for(int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        for(int i = n - 1; i >= 1; i--) {
            for(int j = i + 1; j < n; j++) {
                int minRes = (int) 1e9;
                for(int k = i; k < j; k++) {
                    int currRes = arr[i - 1] * arr[j] * arr[k] + dp[i][k] + dp[k + 1][j];
                    if(minRes > currRes) {
                        minRes = currRes;
                        order[i][j] = (char) ('A' + k - 1);
                    }
                }
                dp[i][j] = minRes;
            }
        }

        String resultString = constructString(order, 1, n - 1);
        return resultString;
    }

    public static String constructString(char[][] order, int i, int j) {
        if(i == j) return "" + (char)('A' + i - 1);

        String result = "";
        result += '(' + constructString(order, i, order[i][j] - 'A' + 1) + constructString(order, order[i][j] - 'A' + 2, j) + ')';
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {40,20,30,10,30};
        String result = matrixChainOrderRecursive(arr);
        System.out.println("Recursive: " + result);

        String result1 = matrixChainOrderIterative(arr);
        System.out.println("Iteartive: " + result1);
    }
}
