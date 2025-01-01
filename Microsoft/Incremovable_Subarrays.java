import java.util.*;

public class Incremovable_Subarrays {
    public static void main(String[] args) {
        int[] nums = {6,5,7,8};
        int result = incremovableSubArrayCount(nums);
        System.out.println(result);
    }

    public static int incremovableSubArrayCount(int[] nums) {
        int n = nums.length;
        int result = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = i ; j < n ; j++) {
                if(isIncreasing(nums, i, j)) {
                    result++;
                }
            }
        }
        return result;
    }

    public static boolean isIncreasing(int[] arr, int start, int end) {
        int prev = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            if(i <= end && i >= start) continue;
            if(arr[i] <= prev) return false;
            else prev = arr[i];
        }
        return true;
    }
}
