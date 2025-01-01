public class Bulls_And_Cows {
    public static String getHint(String secret, String guess) {
        int[] freq = new int[10];

        for(char ch : secret.toCharArray()) {
            int curr = ch - '0';
            freq[curr]++;
        }

        int bulls = calculate(guess, secret, freq, true);
        int cows = calculate(guess, secret, freq, false);
        return bulls + "A" + cows + "B";
    }

    public static int calculate(String guess, String secret, int[] freq, boolean isBull) {
        int count = 0;
        for(int i = 0 ; i < guess.length() ; i++) {
            char ch = guess.charAt(i);
            int curr = ch - '0';

            if(isBull && secret.charAt(i) == ch) {
                count++;
                freq[curr]--;
            }

            if(!isBull && secret.charAt(i) != ch && freq[curr] > 0) {
                count++;
                freq[curr]--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String secret = "1122";
        String guess = "1222";
        String result = getHint(secret, guess);
        System.out.println(result);
    }
}
