package Walmart;

import java.util.*;

public class Largest_Divisible_Subset {
    public static List<Integer> answer = new ArrayList<>();
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        getSubSet(nums, 0, new ArrayList<>(), dp);
        return answer;
    }

    public static void getSubSet(int[] arr, int idx, ArrayList<Integer> bucket, int[] dp) {
        if(idx >= arr.length) {
            if(bucket.size() > answer.size()) {
                answer = new ArrayList<>(bucket);
            }
            return;
        }

        if(bucket.size() == 0 || arr[idx] % bucket.get(bucket.size() - 1) == 0 && dp[idx] < bucket.size() + 1) {
            dp[idx] = bucket.size() + 1;
            bucket.add(arr[idx]);
            getSubSet(arr, idx + 1, bucket, dp);
            bucket.remove(bucket.size() - 1);
        }
        getSubSet(arr, idx + 1, bucket, dp);
    }
    public static void main(String[] args) {
        int[] nums = {1,2,4,8};
        List<Integer> result = largestDivisibleSubset(nums);
        System.out.println(result);
    }
}
