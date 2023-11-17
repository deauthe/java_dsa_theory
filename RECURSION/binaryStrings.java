package RECURSION;

public class binaryStrings {
    //find numbers such that two 1s dont come up consectively
    public static void PrintBinaryStrings(int stringLength,int lastPlace,String str ){
        if(stringLength ==0){
         
            System.out.println(str) ; 
            return;
        }
        if(lastPlace==0){
            PrintBinaryStrings(stringLength-1, 0, str+"0");
            PrintBinaryStrings(stringLength-1, 1, str+"1");
        }
       
        if(lastPlace == 1){
            PrintBinaryStrings(stringLength-1, 0, str+"0");
        }
        /*the above two if statements can be replaced by:
         * func(n-1,0,str+0)
         * if(LP==0){
         *      func(n-1,1,str+1);     
         * }
         * because one line is common with both of them.
         */
    }
    public static void main(String args[]){
        PrintBinaryStrings(3, 0,"");
    }
}
