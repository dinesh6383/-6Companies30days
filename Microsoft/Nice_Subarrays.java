public class Nice_Subarrays {
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;
        int result = numberOfSubArrays(nums, k);
        System.out.println(result);
    }

    public static int numberOfSubArrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    public static int helper(int[] nums , int k) {
        if(k < 0) return 0;

        int result = 0;
        int sum = 0;
        int left = 0, right = 0;

        while(right < nums.length) {
            sum += (nums[right] % 2);

            while(sum > k) {
                sum -= (nums[left] % 2);
                left++;
            }

            result = result + (right - left + 1);
            right++;
        }

        return result;
    }
}



























