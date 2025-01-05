package Amazon;

public class Excel_Sheet_Column_Title {
    public static String convertToString(int columnNumber) {
        String result = "";
        int temp = columnNumber;

        while(temp > 0) {
            int remainder = (temp - 1) / 26;
            int quotient = (temp - 1) % 26;
            char curr = (char) (quotient + 'A');
            result = curr + result;
            temp = remainder;
        }

        return result;
    }
    public static void main(String[] args) {
        int columnNumber = 2;
        String result = convertToString(columnNumber);
        System.out.println(result);
    }
}
