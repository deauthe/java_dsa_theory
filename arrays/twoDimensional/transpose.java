package arrays.twoDimensional;

public class transpose {
    
    public static void main(String args[]){
        int Matrix[][] = {{1,2,3},{4,5,6}} ; 
        Transpose(Matrix);
        displayArray(Matrix);
        
    }

    public static void displayArray(int arr[][]){
        for(int i=0;i<arr.length; i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
                } 
                System.out.println() ; 
            }
    }
    public static void Transpose(int matrix[][]){
        int rows = matrix.length ; 
        int columns = matrix[0].length ; 
        int newMatrix[][] = new int[columns][rows] ; 
        for(int i=0; i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                newMatrix[j][i] = matrix[i][j] ; 

            }
        }
        displayArray(newMatrix);
    }
}
