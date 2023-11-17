package RECURSION;
//for some reason this doesnt work as it intends to do
//check for the new solution come back later
public class towerOfHanoi {
    public static void shift(int n,String src,String helper, String dest){
        if(n==1){
            System.out.println("transfer " + n + " from " +src+ " to "+dest );
            return;
        }

        shift(n-1,src,dest,helper);
        System.out.println("transfer " + n +  " from " +src+ " to "+helper );
        shift(n-1, helper, src, dest);
        
    }

    public static void main(String args[]){
        shift(4, "A", "B", "C");
        
    }
}
