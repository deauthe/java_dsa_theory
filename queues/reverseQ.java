package queues;

import java.util.*;

public class reverseQ {
    public static void ReverseQ(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }

        
    }
    public static void printQ(Queue q){
        while(!q.isEmpty()){
            System.out.print(q.remove()+ " ");
        }
    }
    public static void main(String args[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        // ReverseQ(q);
        printQ(q);
    }
}
