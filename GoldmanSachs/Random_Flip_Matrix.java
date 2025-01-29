package GoldmanSachs;

import java.util.*;

class Solution {
    int row;
    int col;
    int total;
    Random randomNumber;
    HashMap<Integer, Integer> flipped;

    public Solution(int m, int n) {
        row = m;
        col = n;
        total = m * n;
        randomNumber = new Random();
        flipped = new HashMap<>();
    }

    public int[] flip() {
        int randomIndex = randomNumber.nextInt(total);
        total--;

        int pos = flipped.getOrDefault(randomIndex, randomIndex);
        flipped.put(randomIndex, flipped.getOrDefault(total, total));

        return new int[] {pos / col, pos % col};
    }

    public void reset() {
        flipped.clear();
        total = row * col;
    }
}
public class Random_Flip_Matrix {
    public static void main(String[] args) {
        Solution solution = new Solution(3, 1);
        System.out.println(Arrays.toString(solution.flip()));
        solution.reset();
    }
}
