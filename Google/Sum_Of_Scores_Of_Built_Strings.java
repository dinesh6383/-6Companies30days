package Google;

public class Sum_Of_Scores_Of_Built_Strings {
    public static long sumScores(String s) {
        int[] zAlgo = zAlgorithm(s);
        long result = 0;
        
        for(int num : zAlgo) {
            result += num;
        }

        result += s.length();
        return result;
    }

    public static int[] zAlgorithm(String s) {
        int n = s.length();
        int[] z = new int[n];
        
        int left = 0, right = 0;
        for(int i = 1; i < n; i++) {
            // if pointer is within the z-window
            if(i < right) {
                z[i] = Math.min(right - i, z[i - left]);
            }

            while(i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }

            if(i + z[i] > right) {
                left = i;
                right = i + z[i];
            }
        }

        return z;
    }
    public static void main(String[] args) {
        String s = "babab";
        long result = sumScores(s);
        System.out.println(result);
    }
}
