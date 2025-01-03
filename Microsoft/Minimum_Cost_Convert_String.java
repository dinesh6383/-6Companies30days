import java.util.*;

public class Minimum_Cost_Convert_String {
    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int INT = (int) 1e9 + 7;
        long result = 0;
        int[][] minCost = new int[26][26];

        for(int i = 0; i < minCost.length; i++) {
            Arrays.fill(minCost[i], INT);
            minCost[i][i] = 0;
        }

        for(int i = 0; i < original.length; i++) {
            int rowIdx = (original[i] - 0) - 97;
            int colIdx = (changed[i] - 0) - 97;
            
            minCost[rowIdx][colIdx] = Math.min(minCost[rowIdx][colIdx], cost[i]);
        }

        for(int via = 0 ; via < 26 ; via++) {
            for(int from = 0; from < 26; from++) {
                for(int to = 0; to < 26; to++) {
                    minCost[from][to] = Math.min(minCost[from][via], minCost[from][via] + minCost[via][to]);
                }
            }
        }

        for(int i = 0; i < source.length(); i++) {
            int src = source.charAt(i) - 97;
            int tgt = target.charAt(i) - 97; 
            int dist = minCost[src][tgt];

            if(dist == INT) return -1;
            result += dist;
        }

        return result;
    }
    public static void main(String[] args) {
        String source = "abcdz";
        String target = "abcea";
        char[] original = {'a'};
        char[] changed = {'e'};
        int[] cost = {10000};

        long result = minimumCost(source, target, original, changed, cost);
        System.out.println(result);
    }
}
