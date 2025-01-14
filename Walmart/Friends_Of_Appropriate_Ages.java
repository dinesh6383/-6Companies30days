package Walmart;


public class Friends_Of_Appropriate_Ages {
    // Time complexity : O(n) | Space complexity : O(120) => O(1)
    public static int numFriendRequests(int[] nums) {
        int[] peopleCount = new int[121];
        for(int age : nums) {
            peopleCount[age]++;
        }
        
        int[] prefixAges = new int[121];
        prefixAges[1] = peopleCount[1];
        for(int i = 2; i < 121; i++) {
            prefixAges[i] = prefixAges[i - 1] + peopleCount[i];
        }

        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            int validAges = ((int) (nums[i] * 0.5) + 7);
            int tempCount = (prefixAges[nums[i]] - prefixAges[validAges] - 1);
            System.out.println(nums[i] + " " + validAges + " " + tempCount);
            if(tempCount > 0) result += tempCount;
        }
        return result;
    } 
    public static void main(String[] args) {
        int[] ages = {108,115,5,24,82};
        int result = numFriendRequests(ages);
        System.out.println(result);
    }
}


// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
// 0 0 0 0 0 0 0 0 0 0  0  0  0  0  0  1  1  1  1  2  0  1  0  1  1 
// 0 0 0 0 0 0 0 0 0 0  0  0  0  0  0  1  2  3  4  6  6  7  7  8  9  

// 9 - 4 - 1 = 4
// 1 - 0 - 1 = 0

// 16 : [17]
// 17 : [16] [18] [19]
// 18 : [17] [19] [20.1] [20.2]
// 19 : [17, 18] [20.1] [20.2]
// 20.1 : [18] [19] [22] [24] [25]
// 20.2 : [18] [19] [22] [24] [25]
// 22 : [19] [20.1] [20.2] [24] [25]
// 24 : [22] [20.1] [20.2] [25]
// 25 : [20.1] [20.2] [22] [24]