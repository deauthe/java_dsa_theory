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
        int i= low-1; //to make space for elements smaller than pivot 
        for(int j=low;j<high;j++){
            if(arr[j]<=pivot){
                i++;
                //swap
                int temp =arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[high]=arr[i];
        arr[i] = temp;
        return i;

    }
    public static void quickSort(int arr[],int low,int high){
        if(low>=high){
            return;
        }
        int pivot=partition(arr, low, high);
        quickSort(arr, low, pivot-1);
        quickSort(arr, pivot+1, high);
    }
    public static void main(String args[]){
        int arr[] = {2,12,34,4,5,3,6,9};
        int n = arr.length ;
        quickSort(arr, 0, n-1);
    }
    
}
