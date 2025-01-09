package Amazon;

import java.util.HashMap;

public class Number_Of_Ways_To_Reach_K_Stair {
    public static HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> dp = new HashMap<>();
    public static int waysToReachStair(int k) {
        return getPossibleWays(1, 0, k, 0);
    }

    public static int getPossibleWays(int currStep, int jump, int targetStep, int isDownJump) {
        if(currStep > targetStep + 1) return 0;

        if(dp.containsKey(currStep) && dp.get(currStep).containsKey(isDownJump) && dp.get(currStep).get(isDownJump).containsKey(jump)) {
            return dp.get(currStep).get(isDownJump).get(jump);
        }

        int ans = 0;
        if(currStep == targetStep) ans = 1;
        ans += getPossibleWays(currStep + (1 << jump), jump + 1, targetStep, 0);

        if(currStep != 0 && isDownJump == 0) {
            ans += getPossibleWays(currStep - 1, jump, targetStep, 1);
        }

        HashMap<Integer, Integer> temp1 = new HashMap<>();
        temp1.put(jump, ans);

        HashMap<Integer, HashMap<Integer, Integer>> temp2 = new HashMap<>();
        temp2.put(isDownJump, temp1);

        dp.put(currStep, temp2);
        return ans;
    }

    public static void main(String[] args) {
        int k = 8388599;
        int result = waysToReachStair(k);
        System.out.println(result);
    }
}
