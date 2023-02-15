package arrays.sorting;

public class bubbleSort {
    
    public static void main(String args[]){
        int swaps = 0; 
        int prevSwaps = 0;
        int array[] = {4,6,9,2,7,};
        for(int turn = 0; turn< array.length ; turn++){
            for(int i= 0; i <array.length - 1 -turn; i++){
                if(array[i]>array[i+1]){
                    //swap current element with the next one
                    int temp = array[i];
                    array[i] = array[i+1] ;
                    array[i+1] = temp ; 
                    swaps++;
                }
            }
            if(prevSwaps == swaps){
                break ; 
            }
            else{
                prevSwaps = swaps ; 
            }
            

        }
        displayArray(array);
        
    }
    public static void displayArray(int Array[])
    {
        for(int i =0 ; i<Array.length ; i++ )
        {
            System.out.print(Array[i] + " ");
        }
        System.out.println() ; 
    }
}
