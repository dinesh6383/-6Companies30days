package Amazon;
import java.util.*;

public class Valid_Sudoku {
    // Time complexity : O(1) | Space complexity : O(1)
    public static boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashMap<Character, Integer>> map = new HashMap<>();
        for(int i = 0; i < 9; i++) {
            map.put(i, new HashMap<>());
        }
        
        for(int i = 0; i <= 8; i++) {
            for(int j = 0; j <= 8; j++) {
                int box = (i / 3) * 3 + (j / 3);
                if(board[i][j] != '.') {
                    if(!map.get(box).containsKey(board[i][j])) {
                        map.get(box).put(board[i][j], 1); 
                    } else {
                        map.get(box).put(board[i][j], map.get(box).get(board[i][j]) + 1);
                    }
                }
            }
        }        

        System.out.println(map);

        for(int i = 0; i <= 8; i++) {
            for(int j = 0; j <= 8; j++) {
                char curr = board[i][j];
                int currBox = (i / 3) * 3 + (j / 3);
                if(curr != '.') {
                    boolean rowCheck = checkRow(board[i], j, curr);
                    boolean columnCheck = checkColumn(board, i, j, curr);
                    boolean boxCheck = map.get(currBox).get(board[i][j]) == 1;
                    
                    if(!rowCheck || !columnCheck || !boxCheck) return false;
                }
            }
        }

        return true;
    }

    public static boolean checkRow(char[] board, int col, char target) {
        for(int i = 0; i < board.length; i++) {
            if(i != col && board[i] == target) return false;
        }
        return true;
    }

    public static boolean checkColumn(char[][] board, int row, int col, char target) {
        for(int r = 0; r <= 8; r++) {
            if(r != row && board[r][col] == target) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board ={
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean result = isValidSudoku(board);
        System.out.println(result);
    }
}
