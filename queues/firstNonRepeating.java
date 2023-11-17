package queues;
import java.util.*;
public class firstNonRepeating {
    public static void FirstNonRepeating(String str){
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];
        
        for(int i =0; i<str.length();i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch -'a']++;
        }
        while(freq[q.peek()-'a']>1 ){
            q.remove();
            if(q.isEmpty()){
                System.out.println(-1);
                return;
            }
        }
        
        
            System.out.println(q.peek());
            return;

    }
    public static void main(String args[]){
        String str = "abbacxxc";
        FirstNonRepeating(str);
    }
}
