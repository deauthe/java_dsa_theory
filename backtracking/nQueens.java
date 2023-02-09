package backtracking;

import java.util.Scanner;

public class nQueens {
    public static boolean isSafe(char board[][],int row,int column){
        //vertical up
        for(int i =row-1;i>=0;i--){
            if(board[i][column]=='Q'){
                return false;

            }

        }
        
        //left diagonal up:
        for(int i =row-1,j=column-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;                
            }
        }

        
        //right diagonal up:
        for(int i =row-1,j=column+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;                
            }
        }
        return true;

    }


    public static void PrintBoard(char board[][]){
        System.out.println("----------chessBoard-----------");
        for(int i = 0;i<board.length;i++){
            for(int j= 0;j<board.length;j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println("");
        }
    }
    static int count=0;//important is the static keyword where it doesnt get destroyed when function is returned.
    public static void nQueens(char board[][],int row){
        //base case:
        if(row==board.length){
            PrintBoard(board);
            count++;
            
            return;
        }
        
        for(int j = 0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j]= 'Q';
                nQueens(board, row+1);//function call
                board[row][j] = 'x';//backtracking
            }

        }
    }
    public static void  nQueensJustOneSolution(char board[][],int row){
        //base case:
        if(row==board.length){
            if(count<1){
                PrintBoard(board);
                count++;
                
                return;
            }
           
        }
         for(int j = 0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j]= 'Q';
                nQueens(board, row+1);//function call
                board[row][j] = 'x';//backtracking
            }

        }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() ; 
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = 'x' ; 
            }
            
        }
        
        nQueens(board, 0);
        System.out.println("the number of ways this can be done is : " + count);
        nQueensJustOneSolution(board,0) ; 
    }
}
