package RECURSION;

public class friendPairing {
    public static int pair(int n){
        int totalWays =0;
        if(n == 1 || n==2){
            return n; 
        }
        int noPair = pair(n-1);
        int Pair = pair(n-2)*(n-1) ; //if one person is selected, it gives that person n-1 choices.
        totalWays = noPair + Pair ; 
        return totalWays  ;
    }
    public static void main(String args[]){
       System.out.println(pair(3) ); 
    }
}
