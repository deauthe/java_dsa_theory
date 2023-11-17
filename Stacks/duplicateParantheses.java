package Stacks;
import java.util.*;

public class duplicateParantheses{
    public static boolean uselessBrackets(String str){
        int count= 0;
        Stack<Character> s = new Stack<>();
        int i=0;
        while(i<str.length()){
            char ch = str.charAt(i);
            if(ch == ')'){
                count=0;
                while(!s.isEmpty()){
                    if(s.peek()=='('){
                        if(count==0){
                            return false;
                        }
                        else{
                            s.pop();
                            break;
                        }
                    }
                    else{
                        s.pop();
                        count++;
                    }
                }
            }
            else{
                s.push(str.charAt(i));
            }
            i++;

        }
        if(s.isEmpty())
        {return true;}
        else{return false;}
    }


    public static void main(String args[]){
        String str = "((a+b)+c)(";
        if(uselessBrackets(str)){
            System.out.println("no duplicates");
        }
        else{
            System.out.println("duplicates exist");
        }
    }
}