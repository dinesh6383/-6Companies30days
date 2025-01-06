package Amazon;
import java.util.*;

public class Maximum_Sum_Distinct_Subarray_Length_K {
    // Time complexity : O(n) | Space complexity : O(k)
    public static long maximumSubArraySum(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        int n = nums.length;
        long resultantSum = 0;
        long tempSum = 0;

        for(int i = 0; i < k; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
            tempSum += nums[i];
        }
        
        if(frequency.size() == k) resultantSum = tempSum;

        int p1 = 1, p2 = p1 + k - 1;
        while(p1 <= p2 && p2 < n) {
            int removable = nums[p1 - 1];
            int addable = nums[p2];

            tempSum -= removable;
            tempSum += addable;

            // decrementing in frequency
            if(frequency.containsKey(removable)) {
                frequency.put(removable, frequency.get(removable) - 1);
                if(frequency.get(removable) <= 0) frequency.remove(removable);
            }

            // adding in frequency
            frequency.put(addable, frequency.getOrDefault(addable, 0) + 1);

            // if statisfies the condition compare with result.
            if(frequency.size() == k) resultantSum = Math.max(resultantSum, tempSum);

            p1++;
            p2 = p1+k-1;
        }

        return resultantSum;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        int k = 1;
        long result = maximumSubArraySum(nums, k);
        System.out.println(result);
    }
}
