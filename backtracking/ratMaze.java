package backtracking;
import java.util.*;

public class ratMaze {

    public static void PrintArray(int maze[][]){
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[i].length;j++){
                System.out.print(maze[i][j]+" ");
                
                
            }
            System.out.println();
        }
    }
    public static void HighlightPath(int maze[][]){
        maze[maze.length-1][maze[0].length-1] = 2 ; 
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[i].length;j++){
                
                if(maze[i][j]==1 || maze[i][j]==0){
                    maze[i][j]=0;
                }
               if(maze[i][j]==2){
                    maze[i][j]=1; 
                }
                
            }
           
        }
        PrintArray(maze);
    }


    public static boolean isSafeInAnyDir(int maze[][],int currRow,int currCol){
         if(currCol-1>0 && maze[currRow][currCol-1]!=0 && maze[currRow][currCol-1]!=2 ){
                return true;
            }
         if(currRow-1>0 && maze[currRow-1][currCol]!=0 && maze[currRow-1][currCol]!=2){
               return true;
            }
        if(currCol+1<maze[currRow].length && maze[currRow][currCol+1]!=0 && maze[currRow][currCol+1]!=2){
                return true;
            }
        if(currRow+1<maze.length && maze[currRow+1][currCol]!=0 && maze[currRow+1][currCol]!=2){
                return true;
            }
        return false;
    }


    public static boolean isSafe(int maze[][],int currRow,int currCol,String direction)
        {
        if(direction == "L" || direction=="left"){
            if(currCol-1>0 ){
                if(maze[currRow][currCol-1]!=0 && maze[currRow][currCol-1]!=2){
                    return true;
                }
                    
            }
            
        }
        if(direction == "R" || direction=="right"){
            if(currCol+1<maze[currRow].length ){
                if(maze[currRow][currCol+1]!=0 && maze[currRow][currCol+1]!=2){
                    return true;
                }
                
            }
        }
        if(direction == "U" || direction=="up"){
            if(currRow-1>0 ){
                if(maze[currRow-1][currCol]!=0 && maze[currRow-1][currCol]!=2){
                    return true;
                }
                
            }
        }
        if(direction == "D" || direction=="down"){
            if(currRow+1<maze.length ){
                if(maze[currRow+1][currCol]!=0 && maze[currRow+1][currCol]!=2){
                    return true;
                }
               
            }
        }
        return false;
    }
    public static void SolveMaze(int maze[][], int currRow,int currCol){
        
        //base case:
        if(currRow == maze.length-1 && currCol==maze[currRow].length-1){
            System.out.println();
            System.out.println("reached solution!");
            return; 

        }
        // directions
        if(isSafe(maze,currRow,currCol,"left")){
            if(isSafeInAnyDir(maze,currRow,currCol-1)){
                maze[currRow][currCol]= 2;
                System.out.print("L");
                SolveMaze(maze,currRow,currCol-1);

            }
            else{
                maze[currRow][currCol] = 1; //making the path accessible again as there's no way to solve this from here;
            }
            
        }
        if(isSafe(maze,currRow,currCol,"right")){
            if(isSafeInAnyDir(maze,currRow,currCol+1)){
                maze[currRow][currCol]= 2;
                System.out.print("R");
                SolveMaze(maze,currRow,currCol+1);
            }
            else{
                maze[currRow][currCol] = 1; //making the path accessible again as there's no way to solve this from here;
            }
            
        }
        if(isSafe(maze,currRow,currCol,"up")){
            if(isSafeInAnyDir(maze,currRow-1,currCol)){
                maze[currRow][currCol]= 2;
                System.out.print("U");
                SolveMaze(maze,currRow-1,currCol);
            }
            else{
                maze[currRow][currCol] = 1; //making the path accessible again as there's no way to solve this from here;
            }
            
        }
        if(isSafe(maze,currRow,currCol,"down")){
            if(isSafeInAnyDir(maze,currRow+1,currCol)){
                maze[currRow][currCol]= 2;//highlighting the path taken as two
                System.out.print("D");
                SolveMaze(maze,currRow+1,currCol); //recursion
            }
            else{
                maze[currRow][currCol] = 1;
            }
            
        }
    }   
    
    public static void main(String args[]){
        int maze[][] = { 
        { 1, 0, 0, 0 },
        { 1, 1, 0, 1 },
        { 0, 1, 0, 0 },
        { 1, 1, 1, 1 } };

        SolveMaze(maze,0,0);
        HighlightPath(maze);
    }
}
