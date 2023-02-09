package DivAndConq;
//mergesort complexty  0(nlogn) good
//space complexity -> 0(n) not good
public class mergeSort {
    //approach:
        /*divide-> find mid
         * part left and right
         * find mid of left and right
         * and so on till individual elements are left
         * base case -> individual element is left
         * mid = Si +(Ei+Si)/2
         * mergeSort(left) and mergeSort(right)
         * compare indiviual elements of left and right on the same index
         * and keep filling these per index on a temperary array 
         */
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    public static void mergeSort(int arr[],int si,int ei){

        if(si>=ei){//base case
            return;
        }

        int mid = si+ (ei-si)/2;

        mergeSort(arr,si,mid);      //left part

        mergeSort(arr,mid+1,ei);    //right part

        merge(arr,si,mid,ei);
    }
    public static void merge(int arr[],int si,int mid,int ei){
        int temp[] = new int[ei-si+1]; //+1 to balance out the 0 index in arrays
        int i = si; //iterator for left part
        int j=mid +1;//itereator for right part
        int k=0;

        while(i<=mid  && j<=ei){
            if(arr[i] <arr[j] ){//left part at the same index is smaller

                temp[k] = arr[i];
                i++; k++;
            }
            else{//opposite
                temp[k] =arr[j];
                j++;k++;
            }
        }
        //left part leftovers
        while(i<=mid){
            temp[k++]= arr[i++];
        }
        //right part leftovers
        while(j<=ei){
            temp[k++] =arr[j++];
        }
        //copy temp to original
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]= temp[k];
        }
    }

    public static void main(String args[]){
        int arr[]= {6,3,9,5,2,8};
        mergeSort(arr, 0, arr.length-1);
        printArray(arr);
    }
}   
