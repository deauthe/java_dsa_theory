package backtracking;

import java.util.Scanner;

public class gridWays {
    public static int GridWays(int i,int j,int m, int n){
        //base class
        if(i==n-1 && j==m-1){
            return 1;
        }
        else if(i==n || j==m){ //for exceeding the grid
            return 0;
        }

        //recursion
        int w1 = GridWays(i+1, j, m, n);
        int w2 = GridWays(i, j+1, m, n);

        return w1 + w2 ; 
    }

//time complexity is O(2^(m*n))

public static void main(String args[]){
     
    Scanner sc= new Scanner(System.in);
    System.out.print("enter rows and columns: ");
    int m = sc.nextInt();
    int n = sc.nextInt();
    int ans=GridWays(0, 0, m, n);
    System.out.print(ans);
}
}