import java.util.Arrays;

public class Wiggle_Sort_II {
    public static int[] wiggleSort(int[] nums) {
        int[] result = new int[nums.length];

        Arrays.sort(nums);
        int i = 1;
        int j = nums.length - 1;
        while(i < nums.length) {
            result[i] = nums[j];
            j--;
            i += 2;
        }

        i = 0;
        while(i < nums.length) {
            result[i] = nums[j];
            j--;
            i += 2;
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,2,2,3,1};
        int[] result = wiggleSort(nums);
        System.out.println(Arrays.toString(result));   
    }
}
