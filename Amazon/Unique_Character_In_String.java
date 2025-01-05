package Amazon;

public class Unique_Character_In_String {
    public static int firstUniqChar(String s) {
        int minimumIndex = Integer.MAX_VALUE;

        for(char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);

            if(index != -1 && index == s.lastIndexOf(c)) {
                minimumIndex = Math.min(index, minimumIndex);
            }
        }

        return minimumIndex == Integer.MAX_VALUE ? -1 : minimumIndex;
    }
    public static void main(String[] args) {
        String s = "leetcode";
        int result = firstUniqChar(s);
        System.out.println(result);
    }
}
