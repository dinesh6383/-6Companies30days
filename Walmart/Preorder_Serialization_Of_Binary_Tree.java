package Walmart;

public class Preorder_Serialization_Of_Binary_Tree {
    public static boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        int diff = 1;
        for(String node : arr) {
            diff -= 1; 
            if(diff < 0) return false;
            if(!node.equals("#")) diff += 2;
        }

        return diff == 0;
    }

    public static void main(String[] args) {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        boolean result = isValidSerialization(preorder);
        System.out.println(result);
    }
}
