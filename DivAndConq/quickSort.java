package DivAndConq;
    //pivot and partition 
    //time comp-> 0(nlogn)
            //worst case-> 0(n^2)
    //space comp -> 0(1) crazy good
public class quickSort {


    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }


    public static int partition(int arr[],int low,int high){
        int pivot= arr[arr.length-1];
        System.out.println("first pivot is:" + pivot);
        int i= low-1; //to make space for elements smaller than pivot 
        for(int j=low;j<high;j++){
            if(arr[j]<=pivot){ //if this condition doesnt happen, j increases and i doesnt ;
                i++;
                //swap arr[j] with arr[i], j is always the one ahead;
                int temp =arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        //swapping pivot(at index high) with ith element
        int temp = pivot;
        arr[high]=arr[i];
        arr[i] = temp; //this takes the pivot into position
        System.out.println("current pivot is:" + arr[i]);
        return i;
        

    }
// 2 5 3 8 9 4 1 7 10 6
//2 5 3 4 8 9 1 7 10 6
//2 5 3 4 1 8 9 10 6

    public static void QuickSort(int arr[],int low,int high){
        if(low>=high){
            return;
        }
        int pivot=partition(arr, low, high);
        System.out.println("current pivot is:" + pivot);
        QuickSort(arr, low, pivot-1);
        QuickSort(arr, pivot+1, high);
    }




    public static void main(String args[]){
        int arr[] = {2,12,34,4,5,3,6,9};
        int n = arr.length ;
        QuickSort(arr, 0, n-1);
        printArray(arr);
    }
    //2 4 12 34 5 3 6 9
    //2 4 5 12 34 3 6 9
    //2 4 5 3 12 34 6 9 
    //2 4 5 3 6 12 34 9
    //2 4 5 3 6 9 12 34 
    //  
}
