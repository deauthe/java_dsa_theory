package DivAndConq;
//just like binary search but for arrays that are rotated around a pivot but were sorted 
//before this


public class rotateSearch {
    public static int search(int arr[],int target,int si,int ei){
        int mid = si+(ei-si)/2; //(si+ei)/2
        
        //case FOUND!!
        if(arr[mid]==target){
            return mid ; //base case

        }

        //case L1:when mid is on L1:
        if(arr[si]<= arr[mid]){
            //case a: on left and will lie on l1 only
            if(target>=arr[si] && target<=arr[mid]){    
                return search(arr, target, si, mid);
            }
            //case b:on right of mid anywhere
            else{
                return search(arr, target, mid+1, ei);
            }
        }
        //case L2: when mid is on L2
        else{ 
        //case c: right and will lie on L2 only:
            if(target>=arr[mid] && target<=arr[ei]){
                return search(arr, target, mid+1, ei);
            }
            //case d: left of mid and anywher
            else{
                return search(arr, target, si, mid);
            }

   
        }  
    }
    
    public static void main(String args[]){
        int arr[]= {4,5,7,8,0,1,3};
        int target = 0 ;
        int result = search(arr, target, 0, arr.length-1);
        System.out.print(result);
    }
}
