package arrays.twoDimensional;

public class spiralMatrix {
   public static void main(String args[]){
    int matrix[][] = {{1,2,3,4,},
    {5,6,7,8},
    {9,10,11,12},
    {13,14,15,16}}  ;

    Spiral(matrix) ; 
    displayArray(matrix);
   }
   public static void displayArray(int arr[][]){
      for(int i=0;i<arr.length; i++){
          for(int j=0;j<arr[0].length;j++){
              System.out.print(arr[i][j] + " ");
              } 
              System.out.println() ; 
          }
  }

   public static void Spiral( int arr[][]){
    int startRow = 0 ;
    int endRow = arr.length-1 ;
    int startCol = 0;
    int endCol = arr[0].length -1;
    
    while(startCol<=endCol && startRow<=endRow){
      //top
      for(int j = startCol;j<=endCol;j++){
         System.out.print(arr[startRow][j]+ " ") ; 
      }
      //right
      for(int i=startRow+1; i<=endCol; i++){
         System.out.print(arr[i][endCol]+ " ");

         }

      //bottom
      for(int j = endCol - 1;j>=startCol; j--){
         System.out.print(arr[endRow][j]+" ") ; 
      }

      //left
      for(int i = endRow -1; i>=startRow+1;i-- ){
         System.out.print(arr[i][startCol]+" ") ; 
      }

      startCol++ ; 
      startRow ++;
      endCol--;
      endRow--;
      
      System.out.println() ;
      }

    }
   }
    


