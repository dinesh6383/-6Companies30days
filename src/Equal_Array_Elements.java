import java.util.Arrays;

public class Equal_Array_Elements {
    public static void main(String[] args) {
        int[] nums = {1,10,2,9};
        int result = minMoves2(nums);
        System.out.println(result);
    }

    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        int mid_elem = nums[mid];
        int moves = 0;
        for(int i = 0; i < nums.length; i++) {
            int diff = Math.abs(nums[i] - mid_elem);
            moves += diff;
        }

        return moves;
    }
}
