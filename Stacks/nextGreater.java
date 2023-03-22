package Stacks;
import java.util.Stack;
public class nextGreater {
    public static void NextGreater(int[] arr){
        int idx=0;
        Stack<Integer> PrevHigh = new Stack<>();
        int result[] = new int[arr.length];
        while(idx<arr.length-2){
            if(arr[idx+1]>PrevHigh.peek()){
                PrevHigh.push(arr[idx+1]);
                result[idx] = arr[idx+1];
            }
            else{
                result[idx]= -1;
            }
            idx++;
    }
    }
}

