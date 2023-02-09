package Stacks;
import java.util.*;
public class Stack2 {
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static void ReverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int a = s.pop();
        ReverseStack(s);
        pushAtBottom(s,a);
        
    }
    public static void printStack(Stack<Integer> s){
       
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
        
    }
    public static void StockSpan(int[] stock, int[] span){ //important problem;
      
        Stack<Integer> s = new Stack<>();
        span[0]= 1;
        s.push(0);
        for(int i=0;i<stock.length;i++){
            int currPrice = stock[i];
            while(!s.isEmpty()&& currPrice>stock[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]= i+1;
            }else{
                int prevHigh = s.peek();
                span[i] = i - prevHigh; 
            }
            s.push(i);
        }
        

    }
    public static void Printarray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static int[] NextGreater(int[] arr){
        int idx=0;
        Stack<Integer> PrevHigh = new Stack<>();
        PrevHigh.push(arr[0]);
        int result[] = new int[arr.length];
        while(idx<arr.length-1){
            if(arr[idx+1]>PrevHigh.peek()){
                PrevHigh.push(arr[idx+1]);
                result[idx] = arr[idx+1];
            }
            else{
                PrevHigh.push(arr[idx+1]);
                result[idx]= -1;
            }
            idx++;
        }
        result[arr.length-1] = -1;
        return result;
    }

    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        s.push(100);
        s.push(80);
        s.push(60);
        s.push(70);
        s.push(60);
        s.push(85);
        s.push(100);
        int stocks[] = {6,8,0,1,3};
        int span[] = new int[stocks.length];
        
        Printarray(NextGreater(stocks));


        // printStack(s);
        // ReverseStack(s);
        // printStack(s); //printing makes the stack empty because we pop
    }
    
}
