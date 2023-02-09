package arrays.sorting;
public class selectionSort{
    public static void main(String args[]){
        int numbers[] = {5,4,7,3,2,1} ; 
        sort(numbers);
    }
    public static void displayArray(int array[]){
        System.out.print("sorted array is : ");
        for(int i= 0; i<array.length; i++)
        {
            System.out.print( array[i]);
        }
    //     System.out.print("length of array is :" + array.length);
     }
    public static void sort(int array[]){
        boolean sorted = false ; 
        
        for(int i = 0; i<array.length-1;i++){
            int bigpos = i ; 
            if(sorted == false){
                for(int j=i+1;j<array.length; j++){
                    if(array[j]<array[bigpos]){
                     bigpos= j ;
    
                    
                    }
                }
                //swap now
                int temp =array[bigpos] ;
                array[bigpos] = array[i] ;
                array[i] = temp ; 
               
    
                //to minimize number of loops executed, checking if array has been sorted
                for(int k =0; k<array.length-1; k++)
                {
                    if(array[k]>array[k+1]){
                        break ; 
                    }
                    //below to check if every element has been checked
                    else if(k == array.length-1)
                    {
                        sorted = true ; 
                    }
                }
            }
            

             
            
        }
        displayArray(array);
    }

}
//this is better than bubble sort slightly as we are doing less number of swaps 
//here swaps are happening in the outside loop rather than inside.