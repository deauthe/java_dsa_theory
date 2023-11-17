package Stacks;
import java.util.*;
public class reverseStack {
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
    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        // printStack(s);
        ReverseStack(s);
        printStack(s); //printing makes the stack empty because we
    }
}
