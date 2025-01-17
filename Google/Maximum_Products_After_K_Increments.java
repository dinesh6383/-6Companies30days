package Google;

import java.util.PriorityQueue;

public class Maximum_Products_After_K_Increments {
    public static int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.add(num);
        }

        int i = k;
        while(i > 0) {
            int curr = pq.poll();
            pq.add(curr + 1);
            i--;
        }

        long MOD = 1000000007;
        long result = pq.poll();
        while(!pq.isEmpty()) {
            result = (result * pq.poll()) % MOD;
        }

        return (int) result;
    }
    public static void main(String[] args) {
        int[] nums = {24,5,64,53,26,38};
        int k = 54;
        int result = maximumProduct(nums, k);
        System.out.println(result);
    }
}
