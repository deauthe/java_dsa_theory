package Stacks;
//implement stacks using LinkedList

import java.util.*;

public class Stacks1 {
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        s.push(2);
        s.push(4);
        s.push(1);
        pushAtBottom(s,5); 
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

}