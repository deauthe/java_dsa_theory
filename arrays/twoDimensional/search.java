package arrays.twoDimensional;

import java.util.Scanner;

import javax.swing.text.StyledEditorKit.BoldAction;

public class search {
    public static void main(String agrs[]){
        Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[3][3] ; 
        for(int i=0;i<matrix.length; i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j] = sc.nextInt() ; 
            }
        }
        System.out.println("this is your array :");
        displayArray(matrix);

        System.out.print("what number do you wanna know the index of :") ;
        int number = sc.nextInt();
        Search(matrix, number) ;

    }
    public static Boolean Search(int arr[][], int number){
        for(int i=0;i<arr.length; i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] == number)
                {
                    System.out.print("the numbers exists on index ("+i+","+j+")");
                    return true;
                }
                } 
            }
        
        System.out.print("this number doesnt exist in this array") ; 
        return false ; 
    }
    public static void displayArray(int arr[][]){
        for(int i=0;i<arr.length; i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
                } 
                System.out.println() ; 
            }
    }
}
