package RECURSION.questions;
//WearegivenastringS,weneedtofindthecountofallcontiguoussubstringsstarting and ending with the same character
public class three {
    //writing this with the intention of having the index and the endIndex both initiated at 0 for the start.
 public static void Count(int index, String str,int endIndex){
       
    if(endIndex==str.length()){//specifically placed above the base case for a reason, check why!
        
        endIndex=index;
        index+=1;
    }
    if(index==str.length()){
        return;//base case
    }   
    if(str.charAt(index)==str.charAt(endIndex)){
        System.out.println(str.substring(index, endIndex+1));
    }
    Count(index,str,endIndex+1);
 }
 public static void main(String args[]){
    String str = "abcab";
    Count(0,str,0);
 }

}