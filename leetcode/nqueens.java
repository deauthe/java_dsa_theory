package leetcode;
import java.util.*;



class Solution {

    public boolean isSafe(char board[][], int row, int col){
        //vertical check
        for(int i = row;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //diag left
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //diag right
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    static int count= 0;

    public void nQueen(char board[][], int row, List<List<String>> ans){
        if(row==board.length){
            count++;
            ans.add(construct(board));
            return;
        }
        
        for(int col = 0;col<board.length;col++){
            if(isSafe(board, row, col)){
                board[row][col]= 'Q';
                nQueen(board, row+1, ans);
                board[row][col] = '.';
            }
        }

    }
    static List<String> construct(char[][] board) {

        List<String> internal = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            internal.add(row);
        }
        return internal;
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i= 0;i<board.length;i++){
            for(int j= 0;j<board.length;j++){
                board[i][j]= '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        nQueen(board, 0, ans);
        return ans;
    }
}