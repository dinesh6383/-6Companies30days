package Walmart;

import java.util.*;

public class K_Diff_Pair_In_Array {
    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;

        int i = 0, j = 0;
        int n = nums.length;
        while(j < n) {
            int diff = nums[j] - nums[i];
            if(j == i || diff < k) {
                j++;
            } else if(diff > k) {
                i++;
            } else {
                result++;
                i++;
                j++;
                // removing duplicates.
                while(j < n && nums[j] == nums[j - 1]) {
                    j++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {3,1,4,1,5};
        int k = 2;
        int result = findPairs(nums, k);
        System.out.println(result);
    }
}
