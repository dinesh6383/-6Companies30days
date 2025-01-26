package GoldmanSachs;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> bucket = new ArrayList<>();
        getValidCombinations(1, 0, n,  k, bucket, result);
        return result;
    }

    public static void getValidCombinations(int num, int sum, int target, int k, List<Integer> bucket, List<List<Integer>> result) {
        if(num >= 10) {
            if(sum == target && bucket.size() == k) result.add(new ArrayList<>(bucket));
            return;
        }

        bucket.add(num);
        sum += num;
        getValidCombinations(num + 1, sum, target, k, bucket, result);
        bucket.remove(bucket.size() - 1);
        sum -= num;
        getValidCombinations(num + 1, sum, target, k, bucket, result);
    }
    public static void main(String[] args) {
        int k = 4;
        int n = 1;
        List<List<Integer>> result = combinationSum3(k, n);
        System.out.println(result);
    }
}

/*
  [1,2,3,4,5,6,7,8,9] => 
*/
