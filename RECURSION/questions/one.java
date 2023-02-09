package RECURSION.questions;
//ForagivenintegerarrayofsizeN.Youhavetofindalltheoccurrences(indices)ofagivenelement(Key)andprintthem.Usearecursivefunctiontosolvethisproblem.
public class one {
    public static void Occurence(int arr[],int index,int key){
        if(index == arr.length){
            return;
        }
        if(arr[index]==key){
           
            System.out.print(index+" ");
        }        
        Occurence(arr,index+1,key);
        
    }

    public static void main(String args[]){
        int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        Occurence(arr, 0, 2) ; 
    }
}

