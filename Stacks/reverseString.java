package Stacks;
import java.util.*;
public class reverseString {
    public static String reverseString(String str){
        Stack<Character> s =new Stack<>();
        int idx = 0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()){
            result.append(s.pop());
        }
        str = result.toString();
        return str;
    }
    public static void main(String args[]){
        String str = "abc";
        System.out.println(reverseString(str));

    }
}
