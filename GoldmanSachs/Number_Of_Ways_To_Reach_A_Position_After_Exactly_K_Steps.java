package GoldmanSachs;

import java.util.*;

public class Number_Of_Ways_To_Reach_A_Position_After_Exactly_K_Steps {
    public static int MOD = (int) Math.pow(10, 9) + 7;
    public static int numberOfWays(int startPos, int endPos, int k) {
        HashMap<String, Integer> cache = new HashMap<>();
        int ans = getPosWays(startPos, endPos, k, cache);
        return ans;
    }

    public static int getPosWays(int start, int end, int k, HashMap<String, Integer> cache) {
        String key = start + "-" + k;

        if(cache.containsKey(key)) return cache.get(key);
        if(start == end && k == 0) return 1;
        if(k == 0) return 0;

        int left = getPosWays(start - 1, end, k - 1, cache) % MOD;
        int right = getPosWays(start + 1, end, k - 1, cache) % MOD;
        cache.put(key, (left + right) % MOD);
        return cache.get(key);
    }
    public static void main(String[] args) {
        int startPos = 2;
        int endPos = 5;
        int k = 10;
        int result = numberOfWays(startPos, endPos, k);
        System.out.println(result);
    }
}
