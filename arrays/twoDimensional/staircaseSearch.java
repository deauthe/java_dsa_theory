package arrays.twoDimensional;
import java.util.Scanner;

public class staircaseSearch {
    //this is for a columnwise and rowwise sorted array
    public static void main(String args[] ){
    int matrix[][] =
    {
    {10,20,30,40},
    {15,25,35,45},
    {27,29,37,48},
    {32,33,39,50}
    }  ;

    System.out.println(matrix.length + " " + matrix[0].length);

    Scanner sc = new Scanner(System.in) ; 
    int number = sc.nextInt() ; 
    SortedSearch(matrix, number);

    }

    public static boolean SortedSearch(int arr[][], int n){
         
        int row=0 ;
        int column=arr[0].length-1 ; 
        
        while(column>=0 && row<arr[0].length ){
            if( arr[row][column]==n){
                System.out.println("your index is "+row+", "+column);
                return true ; 
            }
            if( n<arr[row][column] ){
                column--;
                
            }
            if(n>arr[row][column]){
                row++;
            }
            
            
        }
        System.out.print("key not found!!") ; 
        return false ; 
        
        
        
    }
}
