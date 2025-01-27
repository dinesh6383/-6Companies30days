package GoldmanSachs;


public class Number_Following_A_Pattern {
    public static String printMinimumNumberForPattern(String S) {
        int[] result = {Integer.MAX_VALUE};
        boolean[] visited = new boolean[10];

        for(int i = 1; i <= 9; i++) {
            visited[i] = true;
            getPatterns(S, 0, i, i, visited, result);
            visited[i] = false;
        }

        return result[0] + "";
    }

    public static void getPatterns(String str, int index, int curr, int bucket, boolean[] visited, int[] result) {
        if(index >= str.length()) {
            result[0] = Math.min(result[0], bucket);
            return;
        }

        char order = str.charAt(index);
        if(order == 'I') {
            for(int i = curr + 1; i <= 9; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    getPatterns(str, index + 1, i, bucket * 10 + i, visited, result);
                    visited[i] = false;
                }
            }
        }
        
        if(order == 'D') {
            for(int i = curr - 1; i >= 1; i--) {
                if(!visited[i]) {
                    visited[i] = true;
                    getPatterns(str, index + 1, i, bucket * 10 + i, visited, result);
                    visited[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        String S = "IIDDD";
        String result = printMinimumNumberForPattern(S);
        System.out.println(result);
    }
}
