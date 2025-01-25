package Atlassian;

import java.util.HashMap;

public class Length_Of_Longest_Subarray_With_AtMost_K_Frequency {
    public static int maxSubArrayLength(int[] nums, int k) {
        int result = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        int i = 0, j = 0;
        int currLength = 0;

        while(j < nums.length) {
            int curr = nums[j];
            if(!freq.containsKey(curr) || freq.get(curr) < k) {
                if(freq.containsKey(curr)) freq.put(curr, freq.get(curr) + 1);
                if(!freq.containsKey(curr)) freq.put(curr, 1);
                currLength += 1;
            } else {
                while(i <= j && freq.get(curr) >= k) {
                    int temp = nums[i];
                    freq.put(temp, freq.get(temp) - 1);
                    i++;
                    currLength -= 1;
                }
                freq.put(curr, freq.get(curr) + 1);
                currLength += 1;
            }
            j++;
            result = Math.max(result, currLength);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {5,5,5,5,5,5,5,5,5,5,5};
        int k = 4;
        int result = maxSubArrayLength(nums, k);
        System.out.println(result);
    }
}
