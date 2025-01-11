package Walmart;

import java.util.*;

public class Largest_Divisible_Subset {
    public static int[] maxSubSequence(int[] nums, int k) {
        int[] result = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++) {
            pq.add(new int[] {nums[i], i});
        }

        while(!pq.isEmpty() && k > 0) {
            pq1.add(pq.poll()[1]);
            k--;
        }

        int idx = 0;
        while(!pq1.isEmpty()) {
            result[idx] = nums[pq1.poll()];
            idx++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2,3,4};
        int k = 3;
        int[] result = maxSubSequence(nums, k);
        System.out.println(Arrays.toString(result));
    }   
}
