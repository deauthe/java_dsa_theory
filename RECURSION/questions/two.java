package RECURSION.questions;

public class two {
    public static void toWords(int index,int arr[])
    {
        if(index == arr.length){
            return ; 
        }
        switch(arr[index]){
            
            case 0:
                System.out.print("zero"+" ");
                break;
            case 1:
                System.out.print("one"+" ");
                break;
            case 2:
                System.out.print("two"+" ");
                break;
            case 3:
                System.out.print("three"+" ");
                break;
            case 4:
                System.out.print("four"+" ");
                break;
            case 5:
                System.out.print("five"+" ");
                break;
            case 6:
                System.out.print("six"+" ");
                break;
            case 7:
                System.out.print("seven"+" ");
                break;
            case 8:
                System.out.print("eight"+" ");
                break;
            case 9:
                System.out.print("nine"+" ");
                break;
        
            
        }
        toWords(index+1, arr);
    }
public static void main(String args[])
{
    int arr[] = {1,2,3,4};
    toWords(0, arr);
}
}
