package backtracking; 

public class sudoku {

    public static void PrintSudoku(int sudoku[][]){
        for(int i=0;i<=8;i++){
            for(int j=0;j<=8;j++){
                System.out.print(sudoku[i][j]+" ");
                if((j+1)%3==0){
                    System.out.print("| "); //vertical segregation lines
                }
                
            }
        System.out.println();
        if((i+1)%3==0){
            for(int k =1; k<=24;k++){
                System.out.print("-") ;//horizontal segregation lines
                
            }
            System.out.println() ; 
                  
        }
        
        
        }

    }

    public static boolean isSafe(int sudoku[][],int row,int col,int digit){
        for(int i=0;i<9;i++){
            if(sudoku[i][col]==digit){//vertical check
                return false;
            }       
        }
        for(int j=0;j<9;j++){
            if(sudoku[row][j]==digit){//horizontal check
                return false;
            }       
        }


        //grid check:
        int SR = (row/3)*3;
        int SC = (col/3)*3;
        for(int i= SR; i<SR+3;i++){
            for(int j=SC; j<SC+3;j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }

        //since everything passes:
        return true;
    }

    public static boolean SudokuSolver(int sudoku[][], int row,int col){
        //base case
        if(row == 9 ){
            return true;
        }
        
        //recursion:
        int nextrow = row;
        int nextcol = col+1 ;  
        if(col+1 == 9){
            nextcol = 0;
            nextrow = row+1;
        }

        //checking for valid elements:
        if(sudoku[row][col]!=0){
            //element is fixed so go to next iteration
            return SudokuSolver(sudoku, nextrow, nextcol);
        }

        
        //above conditions make sure that an element has to be placed here
        for(int digit = 1; digit<=9;digit++){
            if(isSafe(sudoku,row,col,digit)){
                sudoku[row][col] = digit;           
                if(SudokuSolver(sudoku, nextrow, nextcol)){//if board can be solved 
                    return true;
                }
                else{
                    sudoku[row][col] = 0; 
                }
                //replacing the placed digit back to zero if there is no way to solve things after filling that
                //backtracking step
        }
            
        }
        return false;
    }





    public static void main(String args[]){
        int sudoku[][] ={
        {3, 0, 6, 5, 0, 8, 4, 0, 0},
        {5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0} } ;
        if(SudokuSolver(sudoku,0,0)){
            System.out.println("solution exists");
            PrintSudoku(sudoku);
        }
        
    }
}
