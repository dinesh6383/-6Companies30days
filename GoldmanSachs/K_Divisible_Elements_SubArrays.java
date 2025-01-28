package GoldmanSachs;

import java.util.HashSet;

public class K_Divisible_Elements_SubArrays {
    public static int countDistinct(int[] nums, int k, int p) {
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            String temp = "";
            int count = 0;
            for(int j = i; j < nums.length; j++) {
                temp = temp + "-" + nums[j];
                if(nums[j] % p == 0) count++;
                if(count <= k) set.add(temp);
            }
        }
        return set.size();
    }
    public static void main(String[] args) {
        int[] nums = {1,9,8,7,19};
        int k = 1;
        int p = 6;
        int result = countDistinct(nums, k, p);
        System.out.println(result);
    }
}
