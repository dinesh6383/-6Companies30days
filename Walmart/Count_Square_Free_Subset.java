package Walmart;

import java.util.Arrays;

public class Count_Square_Free_Subset {
    public static int MOD = (int)1e9 + 7;
    public static int squareFreeSubsets(int[] nums) {
        int[][] dp = new int[1010][1 << 11];
        for (int[] d : dp) Arrays.fill(d, -1);

        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        
        int[] numsPrimeMask = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsPrimeMask[i] = computeMask(nums[i], primes);
        }

        return (dfs(0, 1, numsPrimeMask, dp) - 1 + MOD) % MOD;
    }

    public static int dfs(int pos, int productMask, int[] numsPrimeMask, int[][] dp) {
        if (pos >= numsPrimeMask.length) return 1;

        if (dp[pos][productMask] != -1) return dp[pos][productMask];


        int ans = dfs(pos + 1, productMask, numsPrimeMask, dp);

        if ((productMask & numsPrimeMask[pos]) == 0) {
            ans = (ans + dfs(pos + 1, productMask | numsPrimeMask[pos], numsPrimeMask, dp)) % MOD;
        }

        return dp[pos][productMask] = ans;
    }

    public static int computeMask(int x, int[] primes) {
        int mask = 0;
        for (int i = 0; i < primes.length; i++) {
            int p = primes[i];
            int cnt = 0;
            while (x % p == 0) {
                x /= p;
                cnt++;
            }

            if (cnt == 0) continue;
            if (cnt == 1) mask |= (1 << (i + 1));
            if (cnt >= 2) return -1;
        }
        return mask;
    }

    public static void main(String[] args) {
        int[] nums = {22,2,5,26,28,8,4,11,12,17,11,3,19,29,19,7,24,12,22,5,8,22};
        int result = squareFreeSubsets(nums);
        System.out.println(result); 
    }
}
