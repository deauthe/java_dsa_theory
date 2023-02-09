package RECURSION;
import java.util.*; 

public class removeDuplicates {
    public static void remDup(String str,int idx,StringBuilder newstr,boolean map[]){
        if(idx==str.length()){
            System.out.println(newstr);
            return ;
        }
        char currChar = str.charAt(idx) ;
        if(map[currChar -  'a']==true){
            remDup(str, idx+1, newstr, map);
        }
        else{
            map[currChar - 'a'] = true; 
            
            remDup(str, idx+1, newstr.append(currChar), map);
        }
    }

    public static void main(String args[]){
        
        remDup("asdkjbabdasnfakfnalkfnas",0,new StringBuilder(),new boolean[26]);
    }
}
