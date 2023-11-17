package leetcode;

public class sudoku {
    public int[][] findBoundary(int row, int col){
        int minRow = (row/3)*3;
        int minCol = (col/3)*3;
        int maxRow = minRow+2;
        int maxCol = minCol+2;
        int boundary[][] = {{minRow,minCol},{maxRow,maxCol}};
        return boundary;


    }
    public boolean isSafe(char[][] board,boolean [][]modifiable, int row, int col, int num){
        int boundary[][] = findBoundary(row, col); //top left cell, bottom right cell
        //vertical check 
        for(int i=0;i<board.length;i++){
            if(board[i][col]==num){
                return false;
            }
        }
        //horizontal check
        for(int j=0;j<board.length;j++){
            if(board[row][j]==num){
                return false;
            }
        }

        int minCol = boundary[0][1];
        int minRow = boundary[0][0];
        int maxRow= boundary[1][0];
        int maxCol = boundary[1][0];

        for(int i= minRow;i<=maxRow;i++){
            for(int j=minCol;j<=maxCol;j++){
                if(board[i][j]==num){
                    return false;
                }
            }
        }
        return true;

    }

    
    
    public void sudokuHelper(char[][] board, boolean[][] canChange, int row,int col){

    }

    public void markModifiable(char[][] board, boolean[][] modifiable){
        for(int i= 0;i<board.length;i++){
            for(int j=0 ; j<board.length;j++){
                
            }
        }
    }
    

    public void solveSudoku(char[][] board) {
        if(board)
    }
}
