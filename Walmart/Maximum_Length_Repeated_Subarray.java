package Walmart;


public class Maximum_Length_Repeated_Subarray {
    public static int findLength(int[] nums1, int[] nums2) {
        int result = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for(int i = 1; i <= nums1.length; i++) {
            for(int j = 1; j <= nums2.length; j++) {
                if(nums1[i - 1] == nums2[j - 1]) {
                    if(dp[i - 1][j - 1] > 0) dp[i][j] = dp[i - 1][j - 1] + 1;
                    else dp[i][j] = 1;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {0,0,0,0,0};
        int[] nums2 = {0,0,0,0,0};
        int result = findLength(nums1, nums2);
        System.out.println(result);
    }
}