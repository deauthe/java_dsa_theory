package Stacks;
import java.util.*;
public class palindrome {
    

    public static void main(String args[]){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(2);
        Node five = new Node(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = null;
        System.out.println("palindrome:" + isPalindrome(one));
        
    }
    public static boolean isPalindrome(Node head){
        Node slow = head;
        Stack<Integer> stack = new Stack<>();
        while(slow!=null){
            stack.push(slow.data); 
            slow=slow.next;
        }
        

        while(head!=null){
            if(head.data == stack.pop()){
                
            }
            else{
                return false;
            }
            head = head.next;
        }
        return true;
    }
    public static class Node{
        int data;
        Node next;
        Node(int d){
            next = null;
            this.data =d;
        }
    }
    }

