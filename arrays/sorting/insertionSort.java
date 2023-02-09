package arrays.sorting;

public class insertionSort {
    public static void main(String args[]){
        int numbers[] = {5,4,7,3,2,1} ; 
        InsertionSort(numbers);
        displayArray(numbers);
    }
    public static void displayArray(int array[]){
        System.out.print("sorted array is : ");
        for(int i= 0; i<array.length; i++)
        {
            System.out.print( array[i] + " ");
        }
    //     System.out.print("length of array is :" + array.length);
     }
     public static void InsertionSort(int array[]){
        int n = array.length; 
        for(int i=1; i<n; i++)
        {

            int key = array[i] ;
            int j = i-1; //important line
            while( j>=0 && array[j] > key) 
            {
                array[j+1] = array[j];//imp
                j-- ;


            }
            array[j+1] = key ; //imp
        }    
        }
}
