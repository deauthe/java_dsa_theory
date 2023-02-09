package arrays.sorting;

public class countingSort {
    //works only for very small numbers sussually just integers
    public static void main(String args[]){
        int arr[] = {1,2,1,3,4,5,4,3,7} ;
        CountingSort(arr);
        displayArray(arr);
      
    }
    public static void displayArray(int array[]){
        System.out.print("sorted array is : ");
        for(int i= 0; i<array.length; i++)
        {
            System.out.print( array[i] + " ");
        }
    }
    public static void CountingSort(int array[])
    {   
        int largest = Integer.MIN_VALUE;
        int n =array.length ;  
        for(int i=0;i< n; i++){
            largest = Math.max(largest,array[i]);
        }
        int count[] = new int[largest +1];
        for(int i=0; i<array.length; i++){
            count[array[i]]++;
            //notice that the index of count is the array's
            //content itself as it literally starts from 0
            //to every integer in the line. 
            //count is an array to count number of times each of the number appears in the array
            //as we go printing in ascending order we keep decreasing one from count for that specific integer


             
        }
        //sorting
        int j = 0;
        //
        for(int i=0; i<count.length;i++ ){
            //another loop below to decrease the frequency 
            //after it's been used once
            while(count[i]> 0){ 
                array[j] = i;
                j++ ; 
                count[i]--;
            }
        }
        
    }
}
